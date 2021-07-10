package com.bd;

import com.utilidades.Utilidades;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Arambula
 */
public class Actualizar {

    public static void ActualizarInfoEmpresa(String[] infoEmpresa) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update preferencias set empresa=?, propietario=?, rfc=?, direccion=?, telefono=?, condiciones=? "
                        + "where nombre = 'InfoEmpresa'");

                pst.setString(1, infoEmpresa[0]);
                pst.setString(2, infoEmpresa[1]);
                pst.setString(3, infoEmpresa[2]);
                pst.setString(4, infoEmpresa[3]);
                pst.setString(5, infoEmpresa[4]);
                pst.setString(6, infoEmpresa[5]);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Actualización de información correcta");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos de la empresa " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos de la empresa,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ActualizarInfoUsuario(int idUsuario, String[] infoUsuario) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=? "
                        + "where id_usuario = '" + idUsuario + "'");

                pst.setString(1, infoUsuario[0]);
                pst.setString(2, infoUsuario[1]);
                pst.setString(3, infoUsuario[2]);
                pst.setString(4, infoUsuario[3]);
                pst.setString(5, infoUsuario[4]);
                pst.setString(6, infoUsuario[5]);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ActualizarPass(int idUsuario, String pass) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update usuarios set password=? where id_usuario = '" + idUsuario + "'");

                pst.setString(1, pass);

                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        } catch (SQLException e) {
            System.out.println("Error al restaurar la contraseña del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al restaurar la contraseña del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ActualizarInfoCliente(int idCliente, String[] infoCliente) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update clientes set nombre_cliente=?, tel_cliente=?, ultima_modificacion=? "
                        + "where id_cliente = '" + idCliente + "'");

                pst.setString(1, infoCliente[0]);
                pst.setString(2, infoCliente[1]);
                pst.setString(3, Utilidades.getUsuarioActivo());

                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        } catch (SQLException e) {
            System.err.println("Error en actualizar cliente " + e);
            JOptionPane.showMessageDialog(null, "¡Error al actualizar cliente! Contacte al Administrador");
        }
    }

    public static void ActualizarInfoEquipo(int idEquipo, String[] infoEquipo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update equipos set observaciones=?, estatus=?, ultima_modificacion=? where id_equipo = '" + idEquipo + "'");

                pst.setString(1, infoEquipo[0]);
                pst.setString(2, infoEquipo[1]);
                pst.setString(3, infoEquipo[2]);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
        } catch (SQLException e) {
            System.err.println("Error en actualizar equipo " + e);
            JOptionPane.showMessageDialog(null, "!Error al actualizar equipo¡ Contacte al Administrador");
        }
    }
    
    public static void ActualizarInfoEquipoT(int idEquipo, String[] infoEquipo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update equipos set comentarios_tecnicos=?, estatus=?, revision_tecnica_de=? where id_equipo = '" + idEquipo + "'");

                pst.setString(1, infoEquipo[0]);
                pst.setString(2, infoEquipo[1]);
                pst.setString(3, infoEquipo[2]);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            }
        } catch (SQLException e) {
            System.err.println("Error en actualizar equipo " + e);
            JOptionPane.showMessageDialog(null, "!Error al actualizar equipo¡ Contacte al Administrador");
        }
    }
    
    public static void ActualizarInfoProducto(int idProducto, String[] infoProducto) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update articulos set codigo=?, nombre=?, cantidad=?, precio=?, ultima_modificacion=? where id_articulo = '" + idProducto + "'");

                pst.setString(1, infoProducto[0]);
                pst.setString(2, infoProducto[1]);
                pst.setString(3, infoProducto[2]);
                pst.setString(4, infoProducto[3]);
                pst.setString(5, infoProducto[4]);

                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Actualización exitosa");

        } catch (SQLException e) {
            System.err.println("Error en actualizar producto " + e);
            JOptionPane.showMessageDialog(null, "!Error al actualizar articulo¡ Contacte al Administrador");
        }
    }

    public static void ActualizarInfoServicio(int idProducto, String[] infoServicio) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update articulos set codigo=?, nombre=?, precio=?, ultima_modificacion=? where id_articulo = '" + idProducto + "'");

                pst.setString(1, infoServicio[0]);
                pst.setString(2, infoServicio[1]);
                pst.setString(3, infoServicio[2]);
                pst.setString(4, infoServicio[3]);

                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
        } catch (SQLException e) {
            System.err.println("Error en actualizar servicio " + e);
            JOptionPane.showMessageDialog(null, "!Error al actualizar articulo¡ Contacte al Administrador");
        }
    }

    public static void ActualizarCantidad(String codigo, String cantidadT) {
        int nCantidad = (Consultar.ConsultarCantidad(codigo) - Integer.parseInt(cantidadT));

        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update articulos set cantidad=? where codigo = '" + codigo + "'");

                pst.setInt(1, nCantidad);
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar la cantidad del producto " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad del producto,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ActualizarEstatus(int IDequipo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("update equipos set estatus=? where id_equipo = '" + IDequipo + "'");
                pst.setString(1, "Entregado");
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar estatus del equipo " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar estatus del equipo,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*Declaración de objetos y variables de clase*/
}
