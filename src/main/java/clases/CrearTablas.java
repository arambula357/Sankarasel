package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CrearTablas {

    ObtenerDatosTabla obtenerDatosTabla = new ObtenerDatosTabla();

    /*
     * Los métodos "CrearTabla" generan la tabla inicial con los datos de la BD.
     * Antes de invocar el metodo debe haber creado los atributos dentro de la clase principal.
     */
    // Generar tabla inicial en "Gestionar usuarios".
    public void CrearTablaUsuarios(DefaultTableModel tablaUsuarios, JTable jTable_Usuarios, JScrollPane jScrollPane_GestionarUsuarios) {
        tablaUsuarios.setRowCount(0);
        tablaUsuarios.setColumnCount(0);        
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("select id_usuario, nombre_usuario, username, tipo_nivel, estatus from usuarios");

            ResultSet rs2 = pst2.executeQuery();

            jTable_Usuarios = new JTable(tablaUsuarios);
            jScrollPane_GestionarUsuarios.setViewportView(jTable_Usuarios);

            tablaUsuarios.addColumn(" ");
            tablaUsuarios.addColumn("Nombre");
            tablaUsuarios.addColumn("Username");
            tablaUsuarios.addColumn("Permisos");
            tablaUsuarios.addColumn("Estatus");

            while (rs2.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs2.getObject(i + 1);
                }
                tablaUsuarios.addRow(fila);

            }
            cn2.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla usuarios! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaUsuarios(tablaUsuarios, jTable_Usuarios);
    }

    // Generar tabla inicial de "Gestionar clientes".
    public void CrearTablaClientes(DefaultTableModel tablaClientes, JTable jTable_Clientes, JScrollPane jScrollPane_GestionarClientes) {
        tablaClientes.setRowCount(0);
        tablaClientes.setColumnCount(0);        
        try { //Obtener datos de la tabla "Clientes"
            Connection cn3 = Conexion.conectar();
            PreparedStatement pst3 = cn3.prepareStatement("select id_cliente, nombre_cliente, mail_cliente, tel_cliente, ultima_modificacion from clientes");

            ResultSet rs3 = pst3.executeQuery();

            jTable_Clientes = new JTable(tablaClientes);
            jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

            tablaClientes.addColumn(" ");
            tablaClientes.addColumn("Nombre");
            tablaClientes.addColumn("email");
            tablaClientes.addColumn("Teléfono");
            tablaClientes.addColumn("Modificado por");

            while (rs3.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs3.getObject(i + 1);
                }
                tablaClientes.addRow(fila);

            }
            cn3.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla clientes! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);
    }

    // Generar tabla inicial de "Gestionar equipos".
    public void CrearTablaEquipos(DefaultTableModel tablaEquipos, JTable jTable_Equipos, JScrollPane jScrollPane_Equipos) {
        tablaEquipos.setRowCount(0);
        tablaEquipos.setColumnCount(0);
        try {
            Connection cn4 = Conexion.conectar();
            PreparedStatement pst4 = cn4.prepareStatement("select id_equipo, tipo_equipo, marca, estatus from equipos");

            ResultSet rs4 = pst4.executeQuery();

            jTable_Equipos = new JTable(tablaEquipos);
            jScrollPane_Equipos.setViewportView(jTable_Equipos);

            tablaEquipos.addColumn(" ");
            tablaEquipos.addColumn("Tipo");
            tablaEquipos.addColumn("Marca");
            tablaEquipos.addColumn("Estatus");

            while (rs4.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs4.getObject(i + 1);
                }
                tablaEquipos.addRow(fila);

            }
            cn4.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla Equipos " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla equipos! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaEquipos(tablaEquipos, jTable_Equipos);
    }

    // Generar tabla inicial de "Productos".
    public void CrearTablaProductos(DefaultTableModel tablaProductos, JTable jTable_Productos, JScrollPane jScrollPane_Productos) {
        tablaProductos.setRowCount(0);
        tablaProductos.setColumnCount(0);
        try {
            Connection cn5 = Conexion.conectar();
            PreparedStatement pst5 = cn5.prepareStatement("select id_articulo, codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto'");
            ResultSet rs5 = pst5.executeQuery();

            jTable_Productos = new JTable(tablaProductos);
            jScrollPane_Productos.setViewportView(jTable_Productos);

            tablaProductos.addColumn(" ");
            tablaProductos.addColumn("Codigo");
            tablaProductos.addColumn("Nombre");
            tablaProductos.addColumn("Cantidad");
            tablaProductos.addColumn("Precio");

            while (rs5.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs5.getObject(i + 1);
                }
                tablaProductos.addRow(fila);
            }
            cn5.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla Productos " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla productos! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);
    }

    // Generar tabla inicial de "Servicios".
    public void CrearTablaServicios(DefaultTableModel tablaServicios, JTable jTable_Servicios, JScrollPane jScrollPane_Servicios) {
        tablaServicios.setRowCount(0);
        tablaServicios.setColumnCount(0);
        try {
            Connection cn5 = Conexion.conectar();
            PreparedStatement pst5 = cn5.prepareStatement("select id_articulo, codigo, nombre, precio from articulos where tipo_articulo = 'servicio'");
            ResultSet rs5 = pst5.executeQuery();

            jTable_Servicios = new JTable(tablaServicios);
            jScrollPane_Servicios.setViewportView(jTable_Servicios);

            tablaServicios.addColumn(" ");
            tablaServicios.addColumn("Codigo");
            tablaServicios.addColumn("Nombre");
            tablaServicios.addColumn("Precio");

            while (rs5.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs5.getObject(i + 1);
                }
                tablaServicios.addRow(fila);
            }
            cn5.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla servicios " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla servicios! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
    }

    // Generar tabla inicial de "Ventas".
    public void crearTablaVentas(DefaultTableModel tablaVentas, JTable jTable_Ventas, JScrollPane jScrollPane_Ventas) {
        tablaVentas.setRowCount(0);
        tablaVentas.setColumnCount(0);
        try {
            Connection cn6 = Conexion.conectar();
            PreparedStatement pst6 = cn6.prepareStatement("select id_venta, id_equipo, tipo_venta, total, fecha_venta from ventas");
            ResultSet rs6 = pst6.executeQuery();
            
            jTable_Ventas = new JTable(tablaVentas);
            jScrollPane_Ventas.setViewportView(jTable_Ventas);
            
            tablaVentas.addColumn(" ");
            tablaVentas.addColumn("Folio");
            tablaVentas.addColumn("Tipo venta");
            tablaVentas.addColumn("total");
            tablaVentas.addColumn("Fecha");
            
            while (rs6.next()) {
                Object[] fila = new Object[5];
                
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs6.getObject(i + 1);
                    
                }
                tablaVentas.addRow(fila);
            }
            cn6.close();
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla ventas " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla ventas! Contacte al administrador");
        }
        obtenerDatosTabla.ObtenerDatosTablaVentas(tablaVentas, jTable_Ventas);

    }

}
