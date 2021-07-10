package com.cortes;

import com.bd.Conexion;
import com.bd.Consultar;

import java.sql.*;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Arambula
 */
public class CorteCustom {

    public void GenerarCorteCustom(java.sql.Date dateI, java.sql.Date dateF) {
        ticketCorte = new TicketCorte(Consultar.ConsultarInfoEmpresa());
        ticketCorte.setFecha();
        setSumatoriaArticulos(dateI, dateF);
    }

    private void setSumatoriaArticulos(java.sql.Date dateI, java.sql.Date dateF) {
        int[] cantidad = new int[99];
        int[] cantidadT = new int[99];
        String[] nombre = new String[99];
        double[] precio = new double[99];
        double total = 0.0;

        String acumulacion = "", totalS = "";

        try {
            try ( Connection cn = Conexion.getConexion()) {
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
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar la sumatoria de articulos para el corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar la sumatoria de articulos para el corte,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        totalS = String.valueOf(total);

        ticketCorte.setArticulos(acumulacion);
        ticketCorte.setTotal(totalS);
        setSalidasEfectivo(dateI, dateF);
    }

    private void setSalidasEfectivo(java.sql.Date dateI, java.sql.Date dateF) {
        String[] conceptoSalida = new String[99];
        double[] totalSalidas = new double[99];
        double sumatoriaSalidas = 0.0;

        String acumulacionSalidas = "", sumatoriaSalidasS = "";

        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select concepto_salida, sum(cantidad_salida) as cantidad_salida from salidas "
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
            }
            sumatoriaSalidasS = String.valueOf(sumatoriaSalidas);
        } catch (SQLException e) {
            System.out.println("Error al recuperar las salidas de efectivo para el corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar las salidas de efectivo para el corte,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

        ticketCorte.setSalidas(acumulacionSalidas);
        ticketCorte.setTotalSalidas(sumatoriaSalidasS);
        setTiposVenta(dateI, dateF);
    }

    private void setTiposVenta(java.sql.Date dateI, java.sql.Date dateF) {
        ticketCorte.setEfectivo(getVentasEfectivo(dateI, dateF));
        ticketCorte.setTarjeta(getVentasTarjeta(dateI, dateF));
        ticketCorte.setTransfer(getVentasTransfer(dateI, dateF));
        ticketCorte.setCantidadI(0.0);
        try {
            ticketCorte.print(false);
        } catch (IOException ex) {
            System.out.println("Error al enviar información para ticket de corte " + ex.getMessage());
        }
    }

    private double getVentasEfectivo(java.sql.Date dateI, java.sql.Date dateF) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                        + dateI + "' and '" + dateF + "' and tipo_venta = 'Efectivo'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getDouble("precio");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar las ventas en efectivo para el corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar las ventas en efectivo para el corte,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0.0;
    }

    private double getVentasTarjeta(java.sql.Date dateI, java.sql.Date dateF) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                        + dateI + "' and '" + dateF + "' and tipo_venta = 'Tarjeta'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getDouble("precio");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar las ventas en tarjeta para el corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar las ventas en tarjeta para el corte,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0.0;
    }

    private double getVentasTransfer(java.sql.Date dateI, java.sql.Date dateF) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select sum(distinct precio) as precio from sumatoria where fecha_venta between '"
                        + dateI + "' and '" + dateF + "' and tipo_venta = 'Transferencia'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getDouble("precio");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar las ventas en tranferencia para el corte: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar las transferencia en tarjeta para el corte,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0.0;
    }

    /*Declaración de objetos y variables de clase*/
    TicketCorte ticketCorte;
}
