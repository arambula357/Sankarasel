package clases;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BaseDatos {

    private final TicketCorte ticketCorte = new TicketCorte();

    private int idEquipo, idCliente;
    public static String nombreUsuario;

    /*
     * Este método llama a la base de datos y realiza un nuevo registro en la tabla "inicioturno".
     * Este método es invocado en el boton "jButtonS_Generar" de la clase "Login" dentro del "jDialog_InicioTurno".
     * El uso de este método es indispensable para recuperar la informacion capturada en el ticket de corte.
     */
    public void RegistroInicioTurno(double cantidad, String fecha, String usuario){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into inicioturno values (?,?,?,?)");
            
            pst.setInt(1, 0);
            pst.setDouble(2, cantidad);
            pst.setString(3, fecha);
            pst.setString(4, usuario);
            
            pst.executeUpdate();
            cn.close();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException e) {
            System.err.println("Error al registrar la cantidad de inicio de turno " + e.getMessage());
        }
    }
    
    /*
     * Este método llama a la base de datos y realiza una consulta del id del cliente que se esta actualizando en la venta.
     * El resultado de la consulta es usado por los métodos "RegistroVenta()".
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     */
    public void ConsultarCliente(int idEquipo) {
        this.idEquipo = idEquipo;
        if (idEquipo != 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select id_cliente from equipos where id_equipo = '" + idEquipo + "'");
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

    /*
     * Este método llama a la base de datos y realiza una consulta del nombre del usuario que esta activo de forma inmediata.
     * El resultado de la consulta es usado por los métodos "RegistroVenta()" y "ResgistroSalida()".
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     */
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

    /*
     * Este método llama a la base de datos y realiza una actualizacion en la tabla "articulos" sobre escribe la cantidad.
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     */
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

    /*
     * Este método llama a la base de datos y realiza una actualizacion en la tabla "equipos" sobre escribe el estatus.
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     */
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

    /*
     * Este método llama a la base de datos y realiza un nuevo registro en la tabla "sumatoria".
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     * El uso de este método es indispensable para recuperar la informacion capturada en el ticket de corte.
     */
    public void CrearSumatoria(String cantidad, String codigo, String nombre, String precio, String tipoVenta) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.format(date);

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        int cantidadI = Integer.parseInt(cantidad);
        double precioD = Double.parseDouble(precio);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into sumatoria values (?,?,?,?,?,?)");

            pst.setInt(1, cantidadI);
            pst.setString(2, codigo);
            pst.setString(3, nombre);
            pst.setDouble(4, precioD);
            pst.setDate(5, dateSQL);
            pst.setString(6, tipoVenta);

            pst.executeUpdate();
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al dar de alta la sumatoria de articulos " + e);
        }
    }

    /*
     * Este método llama a la base de datos y realiza un nuevo registro en la tabla "ventas".
     * Este método es invocado en el boton "jButton_CerrarVenta" de la clase "Administrador" y/o "Capturista".
     * El uso de este método es indispensable para recuperar la informacion capturada en el ticket de corte.
     */
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

    /*
     * Este método llama a la base de datos y realiza un nuevo registro en la tabla "salidas".
     * Este método es invocado en el boton "jButtonS_Generar" de la clase "Administrador" y/o "Capturista".
     * El uso de este método es indispensable para recuperar la informacion capturada en el ticket de corte.
     */
    public void RegistroSalida(String cantidad, String concepto) {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.format(date);

        LocalDateTime horaDia = LocalDateTime.now();
        String hora = Integer.toString(horaDia.getHour());
        String minuto = Integer.toString(horaDia.getMinute());
        String segundo = Integer.toString(horaDia.getSecond());

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        String horaActual = hora + ":" + minuto + ":" + segundo;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("insert into salidas values (?,?,?,?,?,?)");

            pst.setInt(1, 0);
            pst.setDouble(2, Double.parseDouble(cantidad));
            pst.setString(3, concepto);
            pst.setDate(4, dateSQL);
            pst.setString(5, horaActual);
            pst.setString(6, nombreUsuario);

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Salida exitosa");
        } catch (SQLException e) {
            System.err.println("Error al registrar salida de efectivo " + e.getMessage());
        }
    }

    /*
     * iniciamos la serie de métodos para el corte diario.
     * Este método es invocado en el botón "jButton_CorteDiario" de la clase "Administrador" y/o "Capturista".
     * La continuación de este método es "ConsultaSumatoriaCorteDiario()".
     */
    public void GenerarCorteDiario() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(date);

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        ticketCorte.setFecha();

        ConsultaSumatoriaCorteDiario(dateSQL);
    }

    /*
     * Consultamos y acumulamos los diferentes articulos en la tabla "sumatoria".
     * Este método es invocado en el método "GenerarCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "ConsultaSalidasCorteDiario()".
     */
    private void ConsultaSumatoriaCorteDiario(java.sql.Date date) {
        int[] cantidad = new int[99];
        int[] cantidadT = new int[99];
        String[] nombre = new String[99];
        double[] precio = new double[99];
        double total = 0.0;

        String acumulacion = "", totalS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre, sum(distinct cantidad) as cantidad, sum(distinct precio) as precio from sumatoria where fecha_venta = '"
                    + date + "' group by nombre");

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
            System.err.println("Error al recuperar la información del corte: " + e);
        }
        totalS = String.valueOf(total);

        ticketCorte.setArticulos(acumulacion);
        ticketCorte.setTotal(totalS);

        ConsultaSalidasCorteDiario(date);
    }

    /*
     * Consultamos y acumulamos las salidas en la tabla "salidas".
     * Este método es invocado en el método "ConsultaSumatoriaCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "ConsultarTiposVentaCorteDiario()".
     */
    private void ConsultaSalidasCorteDiario(java.sql.Date date) {
        String[] conceptoSalida = new String[99];
        double[] totalSalidas = new double[99];
        double sumatoriaSalidas = 0.0;
        String acumulacionSalidas = "", sumatoriaSalidasS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct cantidad_salida) as cantidad_salida, sum(distinct concepto_salida) as concepto_salida from salidas "
                    + "where fecha_salida = '" + date + "' group by concepto_salida");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int i = 0;
                do {
                    totalSalidas[i] = rs.getDouble("cantidad_salida");
                    conceptoSalida[i] = rs.getString("concepto_salida");

                    if (acumulacionSalidas.equals("")) {
                        acumulacionSalidas = String.valueOf(totalSalidas[i]) + "  " + conceptoSalida[i] + "\n";
                    } else {
                        acumulacionSalidas = acumulacionSalidas + String.valueOf(totalSalidas[i]) + "  " + conceptoSalida[i] + "\n";
                    }
                    sumatoriaSalidas = sumatoriaSalidas + totalSalidas[i];
                    i++;
                } while (rs.next());
            }
            sumatoriaSalidasS = String.valueOf(sumatoriaSalidas);
        } catch (SQLException e) {
            System.err.println("Error al recuperar la información de las salidas: " + e);
        }

        ticketCorte.setSalidas(acumulacionSalidas);
        ticketCorte.setTotalSalidas(sumatoriaSalidasS);
        
        ConsultarTiposVentaCorteDiario(date);
    }

    /*
     * Consultamos y acumulamos por tipo de venta de la tabla "sumatoria".
     * Este método es invocado en el método "ConsultaSalidasCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "print()" de la clase "TicketCorte".
     */
    private void ConsultarTiposVentaCorteDiario(java.sql.Date date) {
        double sumEfectivo = 0.0;
        double sumTarjeta = 0.0;
        double sumTranfer = 0.0;

        try { // Consulta de la sumatoria de ventas en "Efectivo".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta = '"
                    + date + "' and tipo_venta = 'Efectivo'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumEfectivo = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        try { // Consulta de la sumatoria de ventas en "Tarjeta".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta = '"
                    + date + "' and tipo_venta = 'Tarjeta'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumTarjeta = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        try { // Consulta de la sumatoria de ventas en "Transferencia".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta = '"
                    + date + "' and tipo_venta = 'Transferencia'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumTranfer = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        ticketCorte.setEfectivo(sumEfectivo);
        ticketCorte.setTarjeta(sumTarjeta);
        ticketCorte.setTransfer(sumTranfer);
        ticketCorte.setCantidadI(ConsultarInicioTurno());
        
        try {
            ticketCorte.print(false);
        } catch (IOException ex) {
            System.err.println("Error al enviar información para ticket de corte " + ex.getMessage());
        }
    }
    
    /*
     * Consultamos la cantidad de efectivo al inicio de turno en la tabla "inicioturno".
     * Este método es invocado en el método "ConsultarTiposVentaCorteDiario()" justo al enviar el dato al ticket.
     */
    private double ConsultarInicioTurno(){
        LocalDateTime fechaActual = LocalDateTime.now();
        String dia = String.valueOf(fechaActual.getDayOfMonth());
        String mes = String.valueOf(fechaActual.getMonthValue());
        String annio = String.valueOf(fechaActual.getYear());
        String fecha = dia + "/" + mes + "/" + annio;
        double cantidad = 0.0;
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select cantidad from inicioturno where fecha = '" + fecha + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cantidad = rs.getDouble("cantidad");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        return cantidad;
    }

    /*
     * iniciamos la serie de métodos para el corte diario.
     * Este método es invocado en el botón "jButton_CorteDiario" de la clase "Administrador" y/o "Capturista".
     * La continuación de este método es "ConsultaSumatoriaCorteDiario()".
     */
    public void GenerarCorteCustom(java.sql.Date dateI, java.sql.Date dateF) {
        ticketCorte.setFecha();
        ConsultaSumatoriaCorteCustom(dateI, dateF);
    }

    /*
     * Consultamos y acumulamos los diferentes articulos en la tabla "sumatoria".
     * Este método es invocado en el método "GenerarCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "ConsultaSalidasCorteDiario()".
     */
    private void ConsultaSumatoriaCorteCustom(java.sql.Date dateI, java.sql.Date dateF) {
        int[] cantidad = new int[99];
        int[] cantidadT = new int[99];
        String[] nombre = new String[99];
        double[] precio = new double[99];
        double total = 0.0;

        String acumulacion = "", totalS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre, sum(cantidad) as cantidad, sum(precio) as precio from sumatoria where fecha_venta between '"
                    + dateI + "' and '" + dateF + "' group by nombre");

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

        ticketCorte.setArticulos(acumulacion);
        ticketCorte.setTotal(totalS);
        ConsultaSalidasCorteCustom(dateI, dateF);
    }

    /*
     * Consultamos y acumulamos las salidas en la tabla "salidas".
     * Este método es invocado en el método "ConsultaSumatoriaCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "ConsultarTiposVentaCorteDiario()".
     */
    private void ConsultaSalidasCorteCustom(java.sql.Date dateI, java.sql.Date dateF) {
        String[] conceptoSalida = new String[99];
        double[] totalSalidas = new double[99];
        double sumatoriaSalidas = 0.0;

        String acumulacionSalidas = "", sumatoriaSalidasS = "";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct cantidad_salida) as cantidad_salida, sum(distinct concepto_salida) as concepto_salida from salidas "
                    + "where fecha_salida between '" + dateI + "' and '" + dateF + "' group by concepto_salida");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int i = 0;
                do {
                    totalSalidas[i] = rs.getDouble("cantidad_salida");
                    conceptoSalida[i] = rs.getString("concepto_salida");

                    if (acumulacionSalidas.equals("")) {
                        acumulacionSalidas = String.valueOf(totalSalidas[i]) + "  " + conceptoSalida[i] + "\n";
                    } else {
                        acumulacionSalidas = acumulacionSalidas + String.valueOf(totalSalidas[i]) + "  " + conceptoSalida[i] + "\n";
                    }
                    sumatoriaSalidas = sumatoriaSalidas + totalSalidas[i];
                    i++;
                } while (rs.next());
            }
            sumatoriaSalidasS = String.valueOf(sumatoriaSalidas);
        } catch (SQLException e) {
            System.err.println("Error al recuperar la información de las salidas: " + e);
        }

        ticketCorte.setSalidas(acumulacionSalidas);
        ticketCorte.setTotalSalidas(sumatoriaSalidasS);
        ConsultarTiposVentaCorteCustom(dateI, dateF);
    }

    /*
     * Consultamos y acumulamos por tipo de venta de la tabla "sumatoria".
     * Este método es invocado en el método "ConsultaSalidasCorteDiario()" para disminuir la lineas de código.
     * La continuación de este método es "print()" de la clase "TicketCorte".
     */
    private void ConsultarTiposVentaCorteCustom(java.sql.Date dateI, java.sql.Date dateF) {
        double sumEfectivo = 0.0;
        double sumTarjeta = 0.0;
        double sumTranfer = 0.0;

        try { // Consulta de la sumatoria de ventas en "Efectivo".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                    + dateI + "' and '" + dateF + "' and tipo_venta = 'Efectivo'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumEfectivo = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        try { // Consulta de la sumatoria de ventas en "Tarjeta".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                    + dateI + "' and '" + dateF + "' and tipo_venta = 'Tarjeta'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumTarjeta = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        try { // Consulta de la sumatoria de ventas en "Transferencia".
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                    + dateI + "' and '" + dateF + "' and tipo_venta = 'Transferencia'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                sumTranfer = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el total por tipo de ventas: " + e.getMessage());
        }
        ticketCorte.setEfectivo(sumEfectivo);
        ticketCorte.setTarjeta(sumTarjeta);
        ticketCorte.setTransfer(sumTranfer);
        ticketCorte.setCantidadI(0.0);
        try {
            ticketCorte.print(false);
        } catch (IOException ex) {
            System.err.println("Error al enviar información para ticket de corte " + ex.getMessage());
        }
    }
    
}
