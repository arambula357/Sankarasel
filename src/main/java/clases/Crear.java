package clases;

/*
 * @author Diego Arambula.
 */
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanas.InformacionCliente;
import ventanas.InformacionEquipoTecnico;
import ventanas.InformacionUsuario;
import ventanas.InformacionVenta;
import ventanas.Producto;
import ventanas.Servicio;

public class Crear {

    public static String userUpdate;
    public static int IDclienteUpdate, IDequipoUpdate, IDproducto, IDservicio, IDventa, IDequipo;

    public Crear() {
    }

    public void CrearFondo(JLabel Wallpaper) {
        ImageIcon fondo = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon ico = new ImageIcon(fondo.getImage().getScaledInstance(Wallpaper.getWidth(), Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        Wallpaper.setIcon(ico);
        Wallpaper.repaint();
    }

    public void CrearFondo(JButton boton, String ruta, boolean margen) {
        if (margen) {
            ImageIcon ImageBoton = new ImageIcon(ruta);
            Icon iconoBoton = new ImageIcon(ImageBoton.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
            boton.setIcon(iconoBoton);
        } else {
            ImageIcon ImageBoton = new ImageIcon(ruta);
            Icon iconoBoton = new ImageIcon(ImageBoton.getImage());
            boton.setIcon(iconoBoton);
        }
    }

    /*
     * Los métodos "CrearTabla" y "ObtenerDatosTabla" Contienen el codigo para iniciar las tablas asi como tambien sus funciones.
     * El método "CrearTabla" es invocado en interior de "initComponents()" de cada JFrame.
     * El método "ObtenerDatosTabla" es invocado dentro del metodo "CrearTabla".
     * El nombre del método hace referencia a la tabla que se le asigna.
     */
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
        ObtenerDatosTablaUsuarios(tablaUsuarios, jTable_Usuarios);
        EventRefreshTable(tablaUsuarios, jTable_Usuarios, jScrollPane_GestionarUsuarios, "Usuarios");
    }

    public void ObtenerDatosTablaUsuarios(DefaultTableModel tablaUsuarios, JTable jTable_Usuarios) {
        jTable_Usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Usuarios.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (e.getClickCount() == 2) {
                    userUpdate = (String) tablaUsuarios.getValueAt(fila_point, columna_point);
                    InformacionUsuario informacionUsuario = new InformacionUsuario();
                    informacionUsuario.setVisible(true);

                }

            }

        });

    }

    public void CrearTablaClientes(DefaultTableModel tablaClientes, JTable jTable_Clientes, JScrollPane jScrollPane_GestionarClientes) {
        tablaClientes.setRowCount(0);
        tablaClientes.setColumnCount(0);
        try { //Obtener datos de la tabla "Clientes"
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_cliente, nombre_cliente, tel_cliente, ultima_modificacion from clientes");

            ResultSet rs = pst.executeQuery();

            jTable_Clientes = new JTable(tablaClientes);
            jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

            tablaClientes.addColumn(" ");
            tablaClientes.addColumn("Nombre");
            tablaClientes.addColumn("Teléfono");
            tablaClientes.addColumn("Modificado por");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tablaClientes.addRow(fila);

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla clientes! Contacte al administrador");
        }
        ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);
        EventRefreshTable(tablaClientes, jTable_Clientes, jScrollPane_GestionarClientes, "Clientes");
    }

    public void ObtenerDatosTablaClientes(DefaultTableModel tablaClientes, JTable jTable_Clientes) {
        jTable_Clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    IDclienteUpdate = (int) tablaClientes.getValueAt(fila_point, columna_point);
                    InformacionCliente informacionCliente = new InformacionCliente();
                    informacionCliente.setVisible(true);
                }

            }

        });
    }

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
        ObtenerDatosTablaEquipos(tablaEquipos, jTable_Equipos);
        EventRefreshTable(tablaEquipos, jTable_Equipos, jScrollPane_Equipos, "Equipos");
    }

    public void ObtenerDatosTablaEquipos(DefaultTableModel tablaEquipos, JTable jTable_Equipos) {
        jTable_Equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    IDequipoUpdate = (int) tablaEquipos.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico informacionEquipoTecnico = new InformacionEquipoTecnico();
                    informacionEquipoTecnico.setVisible(true);
                }

            }

        });
    }

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
        ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);
        EventRefreshTable(tablaProductos, jTable_Productos, jScrollPane_Productos, "Productos");
    }

    public void ObtenerDatosTablaProductos(DefaultTableModel tablaProductos, JTable jTable_Productos) {
        jTable_Productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    IDproducto = (int) tablaProductos.getValueAt(fila_point, columna_point);
                    Producto producto = new Producto();
                    producto.setVisible(true);
                }
            }
        });
    }

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
        ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
        EventRefreshTable(tablaServicios, jTable_Servicios, jScrollPane_Servicios, "Servicios");
    }

    public void ObtenerDatosTablaServicios(DefaultTableModel tablaServicios, JTable jTable_Servicios) {
        jTable_Servicios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Servicios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    IDservicio = (int) tablaServicios.getValueAt(fila_point, columna_point);
                    Servicio servicio = new Servicio();
                    servicio.setVisible(true);
                }

            }

        });
    }

    public void CrearTablaVentas(DefaultTableModel tablaVentas, JTable jTable_Ventas, JScrollPane jScrollPane_Ventas) {
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
        ObtenerDatosTablaVentas(tablaVentas, jTable_Ventas);
        EventRefreshTable(tablaVentas, jTable_Ventas, jScrollPane_Ventas, "Ventas");
    }

    public void ObtenerDatosTablaVentas(DefaultTableModel tablaVentas, JTable jTable_Ventas) {
        jTable_Ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    IDventa = (int) tablaVentas.getValueAt(fila_point, columna_point);
                    InformacionVenta informacionVenta = new InformacionVenta();
                    informacionVenta.setVisible(true);
                }

            }

        });
    }

    public void EventRefreshTable(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String nombreTabla) {
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    switch (nombreTabla) {
                        case "Usuarios":
                            CrearTablaUsuarios(modelTabla, tabla, scroll);
                            break;
                        case "Clientes":
                            CrearTablaClientes(modelTabla, tabla, scroll);
                            break;
                        case "Equipos":
                            CrearTablaEquipos(modelTabla, tabla, scroll);
                            break;
                        case "Productos":
                            CrearTablaProductos(modelTabla, tabla, scroll);
                            break;
                        case "Servicios":
                            CrearTablaServicios(modelTabla, tabla, scroll);
                            break;
                        case "Ventas":
                            CrearTablaVentas(modelTabla, tabla, scroll);
                            break;
                    }

                }
            }
        });
    }

}
