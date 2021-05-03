package clases;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseDatos {

    private TicketCorte ticketCorte = new TicketCorte();

    private int idEquipo, idCliente;
    public static String nombreUsuario;

    public void ConsultarCliente(int IDequipo) {
        idEquipo = IDequipo;
        if (IDequipo != 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select id_cliente from equipos where id_equipo = '" + IDequipo + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente");
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al consultar id_cliente " + e);
            }
        }

    }

    public void ConsultarUsuario(String usuario) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_usuario from usuarios where username = '" + usuario + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreUsuario = rs.getString("nombre_usuario");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar nombre completo del usuario " + e);
        }
    }

    public void ActualizarCantidad(String codigo, String cantidadT) {
        int cantidadB, nCantidad = 0;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select cantidad from articulos where codigo = '" + codigo + "' and tipo_articulo = 'Producto'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cantidadB = rs.getInt("cantidad");

                nCantidad = (cantidadB - Integer.parseInt(cantidadT));
                

            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar la cantidad de articulo " + e);
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("update articulos set cantidad=? where codigo = '" + codigo + "'");

            pst.setInt(1, nCantidad);
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar la cantidad del producto " + e);
        }

    }

    public void ActualizarEstatus(int IDequipo) {

        if (IDequipo != 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update equipos set estatus=? where id_equipo = '" + IDequipo + "'");
                pst.setString(1, "Entregado");
                pst.executeUpdate();
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al actualizar estatus del equipo " + e);
            }
        }
    }

    public void CrearSumatoria(String cantidad, String codigo, String nombre, String precio) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.format(date);

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        int cantidadI = Integer.parseInt(cantidad);
        double precioD = Double.parseDouble(precio);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into sumatoria values (?,?,?,?,?)");

            pst.setInt(1, cantidadI);
            pst.setString(2, codigo);
            pst.setString(3, nombre);
            pst.setDouble(4, precioD);
            pst.setDate(5, dateSQL);

            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al dar de alta la sumatoria de articulos " + e);
        }
    }

    public void RegistroVenta(String articulos, String total, String tipoVenta) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.format(date);

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into ventas values (?,?,?,?,?,?,?,?)");

            pst.setInt(1, 0);
            pst.setInt(2, idCliente);
            pst.setInt(3, idEquipo);
            pst.setString(4, articulos);
            pst.setString(5, tipoVenta);
            pst.setString(6, total);
            pst.setDate(7, dateSQL);
            pst.setString(8, nombreUsuario);

            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al registrar venta " + e);
        }
    }

    public void GenerarCorteDiario() throws IOException {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(date);

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        int[] cantidad = new int[99];
        int[] cantidadT = new int[99];
        String[] nombre = new String[99];
        double[] precio = new double[99];
        double total = 0.0;
        String acumulacion = "", totalS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre, sum(distinct cantidad) as cantidad, sum(distinct precio) as precio from sumatoria where fecha_venta = '" + dateSQL + "' group by nombre");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int i = 0;
                do {
                    cantidad[i] = rs.getInt("cantidad");
                    nombre[i] = rs.getString("nombre");
                    precio[i] = rs.getDouble("precio");

                    cantidadT[i] = cantidadT[i] + cantidad[i];

                    if (acumulacion.equals("")) {
                        acumulacion = String.valueOf(cantidad[i]) + "  " + nombre[i] + "  " + String.valueOf(precio[i]) + "\n";
                    } else {
                        acumulacion = acumulacion + String.valueOf(cantidad[i]) + "  " + nombre[i] + "  " + String.valueOf(precio[i]) + "\n";
                    }
                    total = total + precio[i];
                    i++;
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar la información del corte " + e);
        }

        totalS = String.valueOf(total);

        /*
        * Comenzamos con la impresión del ticket
         */
        ticketCorte.setFecha();
        ticketCorte.setArticulos(acumulacion);
        ticketCorte.setTotal(totalS);

        ticketCorte.print(true);
    }
    
    public void GenerarCortePersonalizado(java.sql.Date dateI, java.sql.Date dateF) throws IOException{
        int[] cantidad = new int[99];
        int[] cantidadT = new int[99];
        String[] nombre = new String[99];
        double[] precio = new double[99];
        double total = 0.0;
        String acumulacion = "", totalS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre, sum(cantidad) as cantidad, sum(precio) as precio from sumatoria where fecha_venta between '" + dateI + "' and '" + dateF + "' group by nombre");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int i = 0;
                do {
                    cantidad[i] = rs.getInt("cantidad");
                    nombre[i] = rs.getString("nombre");
                    precio[i] = rs.getDouble("precio");

                    cantidadT[i] = cantidadT[i] + cantidad[i];

                    if (acumulacion.equals("")) {
                        acumulacion = String.valueOf(cantidad[i]) + "  " + nombre[i] + "  " + String.valueOf(precio[i]) + "\n";
                    } else {
                        acumulacion = acumulacion + String.valueOf(cantidad[i]) + "  " + nombre[i] + "  " + String.valueOf(precio[i]) + "\n";
                    }
                    total = total + precio[i];
                    i++;
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar la información del corte " + e);
        }
        
        totalS = String.valueOf(total);

        /*
        * Comenzamos con la impresión del ticket
         */
        ticketCorte.setFecha();
        ticketCorte.setArticulos(acumulacion);
        ticketCorte.setTotal(totalS);

        ticketCorte.print(true);      
    }
}
