package ventanas;

import java.sql.*;
import clases.Conexion;
import clases.CrearTablas;
import clases.ObtenerDatosTabla;
import clases.codTicket;
import clases.NumeroLetras;
import clases.TicketRecepcion;
import clases.BaseDatos;
import clases.Crear;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Calendar;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import net.sf.jasperreports.engine.JRException;

public class Capturista extends javax.swing.JFrame {

    public static String subTotal, folio;

    String user, nombre_usuario;
    public static DefaultTableModel tablaClientes = new DefaultTableModel();
    public static DefaultTableModel tablaArticulos = new DefaultTableModel();
    public static DefaultTableModel tablaProductos = new DefaultTableModel();
    public static DefaultTableModel tablaServicios = new DefaultTableModel();
    public static DefaultTableModel tablaVentas = new DefaultTableModel();

    CrearTablas crearTablas = new CrearTablas();
    ObtenerDatosTabla obtenerDatosTabla = new ObtenerDatosTabla();
    codTicket ticket = new codTicket();
    NumeroLetras numeroLetras = new NumeroLetras();
    TicketRecepcion ordenServicio = new TicketRecepcion();
    BaseDatos bd = new BaseDatos();

    public Capturista() {
        initComponents();
        user = Login.user;

        setSize(795, 720);
        setTitle("Administrador - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Crear wallpaper = new Crear(jLabel_Wallpaper);

        // Insertamos imagen de fondo "JPanel" Inicio-.
        Crear fondoVistaCapturista = new Crear(jLabel_FondoVistaCapturista);
        Crear fondoRegistraEquipo = new Crear(jLabel_FondoRegistrarEquipo);
        Crear fondoGestionarClientes = new Crear(jLabel_FondoGestionarClientes);
        Crear fondoVistaVentas = new Crear(jLabel_FondoVistaVentas);
        Crear fondoGenerarVentas = new Crear(jLabel_FondoGenerarVenta);
        Crear fondoInventario = new Crear(jLabel_FondoInventario);
        Crear fondoCortes = new Crear(jLabel_FondoCortes);
        // Insertamos imagen de fondo "JPanel" -Fin.

        // Insertamos imagen en botones Inicio-.
        Crear botonRegistrarEquipo = new Crear(jButton_RegistrarEquipo, "images/addSmartphone.png");
        Crear botonImprimir = new Crear(jButton_Imprimir, "images/impresora.png");
        Crear botonBuscarCliente = new Crear(jButton_BuscarCliente, "images/iconoLupa.png");
        Crear botonBuscarEquipo = new Crear(jButton_BuscarEquipo, "images/iconoLupa");
        Crear botonAltas = new Crear(jButton_Altas, "images/iconoSignoMas.png");
        // Insertamos imagen en botones -Fin.

        try { // Obtener nombre completo del usuario que inicio sesión.
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_usuario from usuarios where username = '" + user + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_NombreUsurario.setText(nombre_usuario);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombre del usuario " + e);
        }
        crearTablas.CrearTablaClientes(tablaClientes, jTable_Clientes, jScrollPane_GestionarClientes);
        crearTablas.CrearTablaProductos(tablaProductos, jTable_Productos, jScrollPane_Productos);
        crearTablas.CrearTablaServicios(tablaServicios, jTable_Servicios, jScrollPane_Servicios);
        crearTablas.crearTablaVentas(tablaVentas, jTable_Ventas, jScrollPane_Ventas);

        // Creación de tabla ventas ¡No modificar!
        tablaArticulos.setRowCount(0);
        tablaArticulos.setColumnCount(0);

        jTable_Articulos = new JTable(tablaArticulos);
        jScrollPane_Articulos.setViewportView(jTable_Articulos);

        tablaArticulos.addColumn("Cantidad");
        tablaArticulos.addColumn("Codigo");
        tablaArticulos.addColumn("Nombre");
        tablaArticulos.addColumn("Precio unitario");
        tablaArticulos.addColumn("Precio total");

        for (int i = 0; i < 100; i++) {
            tablaArticulos.addRow(new Object[i]);
        }
        ObtenerDatosTablaArticulos();
        Cambio();
        BuscarHistorial();
        BuscarProducto();
        BuscarServicio();
    }

    // Colocando icono a ventana
    @Override
    public Image getIconImage() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image retValue = tk.getImage("images/icono.png");
        setIconImage(retValue);
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane_General = new javax.swing.JTabbedPane();
        jPanel_VistaCapturista = new javax.swing.JPanel();
        jTabbedPane_VistaCapturista = new javax.swing.JTabbedPane();
        jPanel_RegistrarEquipo = new javax.swing.JPanel();
        jLabel_Titulo2 = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        txt_Modelo = new javax.swing.JTextField();
        jLabel_Nombre4 = new javax.swing.JLabel();
        txt_NumeroSerie = new javax.swing.JTextField();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jScrollPane_Observaciones = new javax.swing.JScrollPane();
        txt_Observaciones = new javax.swing.JTextPane();
        jButton_RegistrarEquipo = new javax.swing.JButton();
        txt_MailCliente = new javax.swing.JTextField();
        txt_TelefonoCliente = new javax.swing.JTextField();
        txt_Dirección = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton_BuscarCliente = new javax.swing.JButton();
        txt_TipoEquipo = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        jLabel_FondoRegistrarEquipo = new javax.swing.JLabel();
        jPanel_GestionarClientes = new javax.swing.JPanel();
        jScrollPane_GestionarClientes = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        jLabel_Titulo3 = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        txt_BuscarHistorial = new javax.swing.JTextField();
        jLabel_FondoGestionarClientes = new javax.swing.JLabel();
        jLabel_FondoVistaCapturista = new javax.swing.JLabel();
        jPanel_VistaVentas = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_GenerarVenta = new javax.swing.JPanel();
        jScrollPane_Articulos = new javax.swing.JScrollPane();
        jTable_Articulos = new javax.swing.JTable();
        jButton_BuscarEquipo = new javax.swing.JButton();
        jButton_CerrarVenta = new javax.swing.JButton();
        txtV_Total = new javax.swing.JTextField();
        jLabel_Total = new javax.swing.JLabel();
        jLabel_PagaCon = new javax.swing.JLabel();
        txtV_PagaCon = new javax.swing.JTextField();
        txtV_Cambio = new javax.swing.JTextField();
        jLabel_Cambio = new javax.swing.JLabel();
        cmbV_TipoVenta = new javax.swing.JComboBox<>();
        cmbV_Ventaregistrada = new javax.swing.JComboBox<>();
        jLabel_NombreCliente = new javax.swing.JLabel();
        txtV_NombreCliente = new javax.swing.JTextField();
        jLabel_Folio = new javax.swing.JLabel();
        txtV_Folio = new javax.swing.JTextField();
        jLabel_Marca = new javax.swing.JLabel();
        txtV_Modelo = new javax.swing.JTextField();
        jLabel_Modelo = new javax.swing.JLabel();
        jLabel_NumeroSerie = new javax.swing.JLabel();
        txtV_NumeroSerie = new javax.swing.JTextField();
        txtV_Marca = new javax.swing.JTextField();
        jLabel_FondoGenerarVenta = new javax.swing.JLabel();
        jLabel_NombreCliente1 = new javax.swing.JLabel();
        jPanel_Inventario = new javax.swing.JPanel();
        jScrollPane_Productos = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jScrollPane_Servicios = new javax.swing.JScrollPane();
        jTable_Servicios = new javax.swing.JTable();
        txt_BuscarServicio = new javax.swing.JTextField();
        txt_BuscarProducto = new javax.swing.JTextField();
        jButton_Altas = new javax.swing.JButton();
        jLabel_FondoInventario = new javax.swing.JLabel();
        jPanel_Cortes = new javax.swing.JPanel();
        jScrollPane_Ventas = new javax.swing.JScrollPane();
        jTable_Ventas = new javax.swing.JTable();
        cmb_DeDia = new javax.swing.JComboBox<>();
        cmb_DeMes = new javax.swing.JComboBox<>();
        cmb_DeAnnio = new javax.swing.JComboBox<>();
        cmb_ADia = new javax.swing.JComboBox<>();
        cmb_AMes = new javax.swing.JComboBox<>();
        cmb_AAnnio = new javax.swing.JComboBox<>();
        jLabel_De = new javax.swing.JLabel();
        jLabel_A = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton_Mostrar = new javax.swing.JButton();
        jButton_CorteDiario = new javax.swing.JButton();
        jButton_CorteCustom = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel_FondoCortes = new javax.swing.JLabel();
        jLabel_FondoVistaVentas = new javax.swing.JLabel();
        jLabel_NombreUsurario = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu_Opciones = new javax.swing.JMenu();
        jMenuItem_CerrarSesion = new javax.swing.JMenuItem();
        jMenuItem_Acercade = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_InfoVersion = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_VistaCapturista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaCapturista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_RegistrarEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_RegistrarEquipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo2.setText("Registro de equipo");
        jPanel_RegistrarEquipo.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 210, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Número de serie:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        txt_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txt_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 210, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Daño reportado y observaciones:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jScrollPane_Observaciones.setViewportView(txt_Observaciones);

        jPanel_RegistrarEquipo.add(jScrollPane_Observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 420, 260));

        jButton_RegistrarEquipo.setBackground(new java.awt.Color(1, 89, 255));
        jButton_RegistrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarEquipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_RegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarEquipoActionPerformed(evt);
            }
        });
        jPanel_RegistrarEquipo.add(jButton_RegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 120, 100));

        txt_MailCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_MailCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_MailCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_MailCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_MailCliente.setToolTipText("");
        txt_MailCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_MailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, -1));

        txt_TelefonoCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_TelefonoCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TelefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_TelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TelefonoCliente.setToolTipText("");
        txt_TelefonoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 210, -1));

        txt_Dirección.setBackground(new java.awt.Color(3, 37, 251));
        txt_Dirección.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Dirección.setForeground(new java.awt.Color(255, 255, 255));
        txt_Dirección.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Dirección.setToolTipText("");
        txt_Dirección.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Dirección, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("email:");
        jPanel_RegistrarEquipo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono:");
        jPanel_RegistrarEquipo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Dirección:");
        jPanel_RegistrarEquipo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButton_BuscarCliente.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarClienteActionPerformed(evt);
            }
        });
        jPanel_RegistrarEquipo.add(jButton_BuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 55, 30, 25));

        txt_TipoEquipo.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 210, -1));
        jPanel_RegistrarEquipo.add(jLabel_FondoRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        jTabbedPane_VistaCapturista.addTab("Registrar equipo", jPanel_RegistrarEquipo);

        jPanel_GestionarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GestionarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

        jPanel_GestionarClientes.add(jScrollPane_GestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 715, 280));

        jLabel_Titulo3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo3.setText("Clientes registrados");
        jPanel_GestionarClientes.add(jLabel_Titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jButton_Imprimir.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Imprimir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Imprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        jPanel_GestionarClientes.add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 355, 120, 100));

        txt_BuscarHistorial.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarHistorial.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarHistorial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarHistorial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GestionarClientes.add(txt_BuscarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 20, 210, 25));
        jPanel_GestionarClientes.add(jLabel_FondoGestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        jTabbedPane_VistaCapturista.addTab("Gestionar clientes", jPanel_GestionarClientes);

        jPanel_VistaCapturista.add(jTabbedPane_VistaCapturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 530));
        jPanel_VistaCapturista.add(jLabel_FondoVistaCapturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Capturista", jPanel_VistaCapturista);

        jPanel_VistaVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel_GenerarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GenerarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Articulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable_Articulos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable_Articulos.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Articulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane_Articulos.setViewportView(jTable_Articulos);
        if (jTable_Articulos.getColumnModel().getColumnCount() > 0) {
            jTable_Articulos.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel_GenerarVenta.add(jScrollPane_Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 500, 230));

        jButton_BuscarEquipo.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarEquipoActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_BuscarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 30, 25));

        jButton_CerrarVenta.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CerrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CerrarVenta.setText("Cerrar venta");
        jButton_CerrarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CerrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CerrarVentaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_CerrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 80, 60));

        txtV_Total.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Total.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Total.setText("0.0");
        txtV_Total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Total.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 295, 120, -1));

        jLabel_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Total.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Total.setText("Total:");
        jPanel_GenerarVenta.add(jLabel_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 300, -1, -1));

        jLabel_PagaCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PagaCon.setText("Paga con:");
        jPanel_GenerarVenta.add(jLabel_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        txtV_PagaCon.setBackground(new java.awt.Color(3, 37, 251));
        txtV_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        txtV_PagaCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_PagaCon.setText("0.0");
        txtV_PagaCon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 325, 120, -1));

        txtV_Cambio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Cambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Cambio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Cambio.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 355, 120, -1));

        jLabel_Cambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cambio.setText("Cambio:");
        jPanel_GenerarVenta.add(jLabel_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 360, -1, -1));

        cmbV_TipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));
        jPanel_GenerarVenta.add(cmbV_TipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 390, 110, -1));

        cmbV_Ventaregistrada.setForeground(new java.awt.Color(0, 0, 0));
        cmbV_Ventaregistrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cmbV_Ventaregistrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbV_VentaregistradaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(cmbV_Ventaregistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        jLabel_NombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreCliente.setText("Nombre cliente:");
        jPanel_GenerarVenta.add(jLabel_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtV_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NombreCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, 25));

        jLabel_Folio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Folio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Folio.setText("Folio:");
        jPanel_GenerarVenta.add(jLabel_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtV_Folio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Folio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Folio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Folio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 210, 25));

        jLabel_Marca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Marca.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Marca.setText("Marca:");
        jPanel_GenerarVenta.add(jLabel_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtV_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Modelo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Modelo.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 210, 25));

        jLabel_Modelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Modelo.setText("Modelo:");
        jPanel_GenerarVenta.add(jLabel_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel_NumeroSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumeroSerie.setText("Número de serie:");
        jPanel_GenerarVenta.add(jLabel_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        txtV_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_NumeroSerie.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, 25));

        txtV_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Marca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Marca.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 25));
        jPanel_GenerarVenta.add(jLabel_FondoGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jLabel_NombreCliente1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_NombreCliente1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreCliente1.setText("¿Venta registrada?");
        jPanel_GenerarVenta.add(jLabel_NombreCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.addTab("Generar venta", jPanel_GenerarVenta);

        jPanel_Inventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_Inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_Productos.setViewportView(jTable_Productos);

        jPanel_Inventario.add(jScrollPane_Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 720, 170));

        jTable_Servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_Servicios.setViewportView(jTable_Servicios);

        jPanel_Inventario.add(jScrollPane_Servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 720, 170));

        txt_BuscarServicio.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarServicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarServicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarServicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Inventario.add(txt_BuscarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 210, 25));

        txt_BuscarProducto.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Inventario.add(txt_BuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 210, 25));

        jButton_Altas.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Altas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Altas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltasActionPerformed(evt);
            }
        });
        jPanel_Inventario.add(jButton_Altas, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 444, 100, 70));
        jPanel_Inventario.add(jLabel_FondoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jTabbedPane1.addTab("Inventario", jPanel_Inventario);

        jPanel_Cortes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_Ventas.setViewportView(jTable_Ventas);

        jPanel_Cortes.add(jScrollPane_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 720, 330));

        cmb_DeDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel_Cortes.add(cmb_DeDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cmb_DeMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel_Cortes.add(cmb_DeMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        cmb_DeAnnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", " " }));
        jPanel_Cortes.add(cmb_DeAnnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        cmb_ADia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel_Cortes.add(cmb_ADia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        cmb_AMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel_Cortes.add(cmb_AMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        cmb_AAnnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jPanel_Cortes.add(cmb_AAnnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel_De.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_De.setText("De:");
        jPanel_Cortes.add(jLabel_De, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel_A.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_A.setText("A:");
        jPanel_Cortes.add(jLabel_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DD      /    MM     /     AAAA");
        jPanel_Cortes.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DD      /    MM     /     AAAA");
        jPanel_Cortes.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, -1));

        jButton_Mostrar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Mostrar.setText("Mostrar");
        jButton_Mostrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MostrarActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 30, 60, -1));

        jButton_CorteDiario.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CorteDiario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_CorteDiario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CorteDiario.setText("Diario");
        jButton_CorteDiario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CorteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CorteDiarioActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_CorteDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 130, 40));

        jButton_CorteCustom.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CorteCustom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_CorteCustom.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CorteCustom.setText("Personalizado");
        jButton_CorteCustom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CorteCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CorteCustomActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_CorteCustom, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 130, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Corte:");
        jPanel_Cortes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 100, 30));
        jPanel_Cortes.add(jLabel_FondoCortes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jTabbedPane1.addTab("Cortes", jPanel_Cortes);

        jPanel_VistaVentas.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 550));
        jPanel_VistaVentas.add(jLabel_FondoVistaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Ventas", jPanel_VistaVentas);

        getContentPane().add(jTabbedPane_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 760, 600));

        jLabel_NombreUsurario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsurario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsurario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsurario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 790, 700));

        jMenu_Opciones.setText("Opciones");

        jMenuItem_CerrarSesion.setText("Cerrar sesión");
        jMenuItem_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CerrarSesionActionPerformed(evt);
            }
        });
        jMenu_Opciones.add(jMenuItem_CerrarSesion);

        jMenuItem_Acercade.setText("Acerca de");
        jMenuItem_Acercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AcercadeActionPerformed(evt);
            }
        });
        jMenu_Opciones.add(jMenuItem_Acercade);

        jMenuBar.add(jMenu_Opciones);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_InfoVersion.setText("info versión");
        jMenuItem_InfoVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_InfoVersionActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_InfoVersion);

        jMenuBar.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarEquipoActionPerformed

        int validacion = 0, IDcliente = 0, IDclienteUpdate = 0, idR;
        String nombreCliente, mail, direccion, telefono, tipo_equipo, marca, modelo, numeroSerie, dia_ingreso, mes_ingreso, annio_ingreso, estatus, observaciones, hora, minuto, segundo, fechaHora,
                hora_ingreso;

        nombreCliente = txt_NombreCliente.getText().trim();
        mail = txt_MailCliente.getText().trim();
        direccion = txt_Dirección.getText().trim();
        telefono = txt_TelefonoCliente.getText().trim();
        tipo_equipo = txt_TipoEquipo.getText().trim();
        marca = txt_Marca.getText().trim();
        modelo = txt_Modelo.getText().trim();
        numeroSerie = txt_NumeroSerie.getText().trim();
        observaciones = txt_Observaciones.getText();
        estatus = "Nuevo ingreso";

        if (tipo_equipo.equals("")) {
            txt_TipoEquipo.setBackground(Color.red);
            validacion++;
        }
        if (marca.equals("")) {
            txt_Marca.setBackground(Color.red);
            validacion++;
        }
        if (modelo.equals("")) {
            txt_Modelo.setBackground(Color.red);
            validacion++;
        }
        if (numeroSerie.equals("")) {
            txt_NumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if (nombreCliente.equals("")) {
            txt_NombreCliente.setBackground(Color.red);
            validacion++;
        }
        /*Habilitar cuando sea necesario*/
        /*if (mail.equals("")) {
            txt_MailCliente.setBackground(Color.red);
            validacion++;
        }*/
        /*if (direccion.equals("")) {
            txt_Dirección.setBackground(Color.red);
            validacion++;
        }*/
        if (telefono.equals("")) {
            txt_TelefonoCliente.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            txt_Observaciones.setText("Sin observaciones.");
            observaciones = "Sin observaciones";
        }

        Calendar calendar = Calendar.getInstance();
        dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH + 1));
        annio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));

        LocalDateTime horaActual = LocalDateTime.now();
        hora = Integer.toString(horaActual.getHour());
        minuto = Integer.toString(horaActual.getMinute());
        segundo = Integer.toString(horaActual.getSecond());

        fechaHora = dia_ingreso + "/" + mes_ingreso + "/" + annio_ingreso + " " + hora + ":" + minuto + ":" + segundo;
        hora_ingreso = hora + ":" + minuto + ":" + segundo;

        try { //Consultamos la existencia del cliente en la base de datos.
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_cliente from clientes where nombre_cliente = '" + nombreCliente + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                IDcliente = rs.getInt("id_cliente");
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al consultar primer id cliente " + e);
        }
        if (validacion == 0) {
            if (IDcliente == 0) { // En caso de que el nombre del cliente no existe en la BD se ingresa un registro nuevo.

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("insert into clientes values (?,?,?,?,?,?)");

                    pst2.setInt(1, 0);
                    pst2.setString(2, nombreCliente);
                    pst2.setString(3, mail);
                    pst2.setString(4, telefono);
                    pst2.setString(5, direccion);
                    pst2.setString(6, user);

                    pst2.executeUpdate();
                    cn2.close();

                } catch (SQLException e) {
                    System.err.println("Error al hacer nuevo registro en la tabla clientes " + e);
                }
            } else { //Si la condicion anterior no se cumple se ejecuta una secundaria, es decir el cliente ya existe en la BD.
                try { // Actualizamos la información del cliente dentro de la BD.
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update clientes set nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? "
                            + "where id_cliente = '" + IDcliente + "'");

                    pst2.setString(1, nombreCliente);
                    pst2.setString(2, mail);
                    pst2.setString(3, telefono);
                    pst2.setString(4, direccion);
                    pst2.setString(5, user);

                    pst2.executeUpdate();
                    cn2.close();

                } catch (SQLException e) {
                    System.err.println("Error al actualizar la tabla clientes " + e);
                }
            }

            try { // Realizamos consulta en la BD para el nuevo id de cliente.
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("select id_cliente from clientes where nombre_cliente = '" + nombreCliente + "'");

                ResultSet rs2 = pst2.executeQuery();

                if (rs2.next()) {
                    IDclienteUpdate = rs2.getInt("id_cliente");
                }

                cn2.close();

            } catch (SQLException e) {
                System.err.println("Error al consultar el segundo id cliente " + e);
            }
            if (IDcliente == 0) { //En caso de que el cliente no haya sido registrado antes se genera un registro nuevo en la BD equipos.
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setInt(2, IDclienteUpdate);
                    pst.setString(3, tipo_equipo);
                    pst.setString(4, marca);
                    pst.setString(5, modelo);
                    pst.setString(6, numeroSerie);
                    pst.setString(7, dia_ingreso);
                    pst.setString(8, mes_ingreso);
                    pst.setString(9, annio_ingreso);
                    pst.setString(10, hora_ingreso);
                    pst.setString(11, observaciones);
                    pst.setString(12, estatus);
                    pst.setString(13, user);
                    pst.setString(14, "");
                    pst.setString(15, "");

                    pst.executeUpdate();
                    cn.close();

                    try {
                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement("select max(id_equipo) as id from equipos");
                        ResultSet rs2 = pst2.executeQuery();

                        if (rs2.next()) {
                            idR = rs2.getInt("id");

                            folio = String.valueOf(idR);
                        }
                        cn2.close();

                    } catch (SQLException e) {
                        System.err.println("Error al consultar el ultimo id registrado: " + e);
                    }
                } catch (SQLException e) {
                    System.err.println("Error en registrar equipo " + e);
                    JOptionPane.showMessageDialog(null, "¡Error al registrar equipo! Contacte al Administrador");

                }
            } else { //Si el cliente ya habia sido registrado se incluye el nuevo equipo con su id cliente
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setInt(2, IDcliente);
                    pst.setString(3, tipo_equipo);
                    pst.setString(4, marca);
                    pst.setString(5, modelo);
                    pst.setString(6, numeroSerie);
                    pst.setString(7, dia_ingreso);
                    pst.setString(8, mes_ingreso);
                    pst.setString(9, annio_ingreso);
                    pst.setString(10, hora_ingreso);
                    pst.setString(11, observaciones);
                    pst.setString(12, estatus);
                    pst.setString(13, user);
                    pst.setString(14, "");
                    pst.setString(15, "");

                    pst.executeUpdate();
                    cn.close();

                    try {
                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement("select max(id_equipo) as id from equipos");
                        ResultSet rs2 = pst2.executeQuery();

                        if (rs2.next()) {
                            idR = rs2.getInt("id");

                            folio = String.valueOf(idR);
                        }
                        cn2.close();

                    } catch (SQLException e) {
                        System.err.println("Error al consultar el ultimo id registrado: " + e);
                    }
                } catch (SQLException e) {
                    System.err.println("Error en registrar equipo " + e);
                    JOptionPane.showMessageDialog(null, "¡Error al registrar equipo! Contacte al Administrador");
                }
            }

            ordenServicio.setFolio(folio);
            ordenServicio.setFechaHora(fechaHora);
            ordenServicio.setNombreCliente(nombreCliente);
            ordenServicio.setContactoCliente(telefono);
            ordenServicio.setNumeroSerie(numeroSerie);
            ordenServicio.setTipoEquipo(tipo_equipo);
            ordenServicio.setMarca(marca);
            ordenServicio.setModelo(modelo);
            ordenServicio.setObservaciones(observaciones);
            ordenServicio.setVendedor(nombre_usuario);

            try {
                ordenServicio.LlenarOrden();
            } catch (JRException ex) {
                System.err.println("Error al llenar la informacion del ticket " + ex);
            }
            txt_NombreCliente.setText("");
            txt_MailCliente.setText("");
            txt_TelefonoCliente.setText("");
            txt_Dirección.setText("");
            txt_TipoEquipo.setText("");
            txt_Marca.setText("");
            txt_Modelo.setText("");
            txt_NumeroSerie.setText("");
            txt_Observaciones.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_jButton_RegistrarEquipoActionPerformed

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Cartera Cliente.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/main/java/images/BannerPDF.jpg");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Email");
            tablaCliente.addCell("Telefono");
            tablaCliente.addCell("Direccion");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tablaCliente.addCell(rs.getString("id_cliente"));
                        tablaCliente.addCell(rs.getString("nombre_cliente"));
                        tablaCliente.addCell(rs.getString("mail_cliente"));
                        tablaCliente.addCell(rs.getString("tel_cliente"));
                        tablaCliente.addCell(rs.getString("dir_cliente"));
                    } while (rs.next());

                    documento.add(tablaCliente);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los datos del cliente para el documento " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
        }
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

    private void jMenuItem_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CerrarSesionActionPerformed

        Login login = new Login();
        login.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenuItem_CerrarSesionActionPerformed

    private void jMenuItem_AcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcercadeActionPerformed

        JOptionPane.showMessageDialog(null, "Creado por Diego arambula", "Acerca de", HEIGHT);

    }//GEN-LAST:event_jMenuItem_AcercadeActionPerformed

    private void jButton_BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarClienteActionPerformed

        String nombreCliente, mailCliente = "", telefonoCliente = "", direccionCliente = "";

        nombreCliente = txt_NombreCliente.getText().trim();

        if (!(txt_NombreCliente.getText().trim()).equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes where nombre_cliente = '" + nombreCliente + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    mailCliente = rs.getString("mail_cliente");
                    telefonoCliente = rs.getString("tel_cliente");
                    direccionCliente = rs.getString("dir_cliente");

                } else {

                    JOptionPane.showMessageDialog(null, "El cliente no existe", "Buscar cliente", HEIGHT);
                }
                cn.close();

            } catch (SQLException e) {
                System.err.println("Error al cargar cliente " + e);
            }
            // Llenamos campos con los datos en la BD.
            txt_MailCliente.setText(mailCliente);
            txt_TelefonoCliente.setText(telefonoCliente);
            txt_Dirección.setText(direccionCliente);

        } else {
            JOptionPane.showMessageDialog(null, "El campo Nombre del cliente esta vacio");
        }

    }//GEN-LAST:event_jButton_BuscarClienteActionPerformed

    private void jButton_BuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarEquipoActionPerformed

        int folioInt, idCliente;
        String nombreCliente, folio;

        nombreCliente = txtV_NombreCliente.getText().trim();
        folio = txtV_Folio.getText().trim();

        if (!nombreCliente.equals("") && !folio.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select id_cliente from clientes where nombre_cliente = '" + nombreCliente + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente");
                    folioInt = Integer.parseInt(folio);

                    try {
                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement("select marca, modelo, num_serie from equipos where id_equipo = '" + folioInt + "' and id_cliente = '" + idCliente + "'");

                        ResultSet rs2 = pst2.executeQuery();

                        if (rs2.next()) {
                            txtV_Marca.setText(rs2.getString("marca"));
                            txtV_Modelo.setText(rs2.getString("modelo"));
                            txtV_NumeroSerie.setText(rs2.getString("num_serie"));

                        } else {
                            JOptionPane.showMessageDialog(null, "El equipo no pertenece al cliente");
                        }

                        cn2.close();
                    } catch (SQLException e) {
                        System.err.println("Error al recuperar la informacion del equipo " + e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre del cliente no existe");
                }
                cn.close();

            } catch (SQLException e) {
                System.err.println("Error al recuperar el nombre del cliente " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar los campos Nombre cliente y Folio");
        }
    }//GEN-LAST:event_jButton_BuscarEquipoActionPerformed

    private void jButton_CerrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CerrarVentaActionPerformed

        String nombreCliente, folioV, modelo, numeroSerie, subTotalS, total, recibo, cambio, articulos = "", fecha, dia, mes, annio, tipoVenta;
        String empresa, propietario, rfc, direccion, telefono, matriz, totalLetra, vendedor, rfcCliente;

        int IDequipo, validacion = 0;
        int columnaCantidad = tablaArticulos.findColumn("Cantidad");
        int columnaCodigo = tablaArticulos.findColumn("Codigo");
        int columnaNombreArticulo = tablaArticulos.findColumn("Nombre");
        int columnaPrecioU = tablaArticulos.findColumn("Precio unitario");
        int columnaPrecioT = tablaArticulos.findColumn("Precio total");

        String[] cantidad = new String[99];
        String[] codigo = new String[99];
        String[] nombre = new String[99];
        String[] precio = new String[99];

        nombreCliente = txtV_NombreCliente.getText().trim();
        folioV = txtV_Folio.getText().trim();
        modelo = txtV_Modelo.getText().trim();
        numeroSerie = txtV_NumeroSerie.getText().trim();

        subTotalS = txtV_Total.getText().trim();
        total = txtV_Total.getText().trim();
        recibo = txtV_PagaCon.getText().trim();
        cambio = txtV_Cambio.getText().trim();
        tipoVenta = cmbV_TipoVenta.getSelectedItem().toString();

        Calendar calendar = Calendar.getInstance();
        dia = Integer.toString(calendar.get(Calendar.DATE));
        mes = Integer.toString(calendar.get(Calendar.MONTH + 1));
        annio = Integer.toString(calendar.get(Calendar.YEAR));

        if (nombreCliente.equals("")) {
            txtV_NombreCliente.setBackground(Color.red);
            validacion++;
        }
        if (folioV.equals("")) {
            txtV_Folio.setBackground(Color.red);
            validacion++;
        }
        if (modelo.equals("")) {
            txtV_Modelo.setBackground(Color.red);
            validacion++;
        }
        if (numeroSerie.equals("")) {
            txtV_NumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if ((cmbV_Ventaregistrada.getSelectedItem().toString()).equals("No")) {
            fecha = dia + " / " + mes + " / " + annio;
            IDequipo = Integer.parseInt(folioV);
            bd.ConsultarCliente(IDequipo);
            bd.ConsultarUsuario(user);
            totalLetra = numeroLetras.Convertir(total, true);
            vendedor = nombre_usuario;
            empresa = "SANKARASEL REFACIONES";
            propietario = "SERGIO ALEJANDRO CHAVIRA MORENO";
            rfc = "CAMS9711039P7";
            direccion = "    AV TECNOLOGICO No 11308-B\n"
                    + "      COL. REVOLUCION CP 31135\n"
                    + "     CHIHUAHUA,CHIHUAHUA, MEXICO";
            telefono = "6146191507";

            for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                if ((jTable_Articulos.getValueAt(i, columnaCantidad)) != null && (jTable_Articulos.getValueAt(i, columnaCodigo)) != null) {
                    cantidad[i] = (String) jTable_Articulos.getValueAt(i, columnaCantidad);
                    codigo[i] = (String) jTable_Articulos.getValueAt(i, columnaCodigo);
                    nombre[i] = (String) jTable_Articulos.getValueAt(i, columnaNombreArticulo);
                    precio[i] = (jTable_Articulos.getValueAt(i, columnaPrecioT)).toString();
                    if (articulos.equals("")) {
                        articulos = cantidad[i] + "   " + nombre[i] + "   " + precio[i] + "\n";
                    } else {
                        articulos = articulos + cantidad[i] + "   " + nombre[i] + "   " + precio[i] + "\n";
                    }

                    bd.RegistroVenta(articulos, total, tipoVenta);
                    bd.CrearSumatoria(cantidad[i], codigo[i], nombre[i], precio[i]);
                    bd.ActualizarEstatus(IDequipo);
                    bd.ActualizarCantidad(codigo[i], cantidad[i]);
                }
            }
            /*Comenzamos la impresion del ticket*/
            ticket.setEmpresa(empresa);
            ticket.setPropietario(propietario);
            ticket.setRfc(rfc);
            ticket.setDireccion(direccion);
            ticket.setTelefono(telefono);
            ticket.setFolio("S/Folio");
            ticket.setCliente("S/Registro");
            ticket.setArticulos(articulos);
            ticket.setSubTotal(subTotalS);
            ticket.setTotal(total);
            ticket.setRecibo(recibo);
            ticket.setCambio(cambio);
            ticket.setTotalLetra(totalLetra);
            ticket.setVendedor(vendedor);
            ticket.setFecha(fecha);
            try {
                ticket.print(true);
            } catch (IOException ex) {
                System.err.println("Error al generar venta " + ex.getMessage());
            }
            /*Terminamos la impresion del ticket*/
            txtV_NombreCliente.setText("");
            txtV_Total.setText("0.0");
            txtV_PagaCon.setText("0.0");
            txtV_Cambio.setText("0.0");
            for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                tablaArticulos.setValueAt(null, i, columnaCantidad);
                tablaArticulos.setValueAt(null, i, columnaCodigo);
                tablaArticulos.setValueAt(null, i, columnaNombreArticulo);
                tablaArticulos.setValueAt(null, i, columnaPrecioU);
                tablaArticulos.setValueAt(null, i, columnaPrecioT);
            }
            JOptionPane.showMessageDialog(null, "Venta exitosa");

        } else if ((cmbV_Ventaregistrada.getSelectedItem().toString()).equals("Si")) {
            if (validacion == 0) {
                fecha = dia + " / " + mes + " / " + annio;
                IDequipo = Integer.parseInt(folioV);
                bd.ConsultarCliente(IDequipo);
                bd.ConsultarUsuario(user);
                totalLetra = numeroLetras.Convertir(total, true);
                vendedor = nombre_usuario;
                empresa = "SANKARASEL REFACIONES";
                propietario = "SERGIO ALEJANDRO CHAVIRA MORENO";
                rfc = "CAMS9711039P7";
                direccion = "    AV TECNOLOGICO No 11308-B\n"
                        + "      COL. REVOLUCION CP 31135\n"
                        + "     CHIHUAHUA,CHIHUAHUA, MEXICO";
                telefono = "6146191507";

                for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                    if ((jTable_Articulos.getValueAt(i, columnaCantidad)) != null && (jTable_Articulos.getValueAt(i, columnaCodigo)) != null) {
                        cantidad[i] = (String) jTable_Articulos.getValueAt(i, columnaCantidad);
                        codigo[i] = (String) jTable_Articulos.getValueAt(i, columnaCodigo);
                        nombre[i] = (String) jTable_Articulos.getValueAt(i, columnaNombreArticulo);
                        precio[i] = (jTable_Articulos.getValueAt(i, columnaPrecioT)).toString();
                        if (articulos.equals("")) {
                            articulos = cantidad[i] + "   " + nombre[i] + "   " + precio[i] + "\n";
                        } else {
                            articulos = articulos + cantidad[i] + "   " + nombre[i] + "   " + precio[i] + "\n";
                        }

                        bd.RegistroVenta(articulos, total, tipoVenta);
                        bd.CrearSumatoria(cantidad[i], codigo[i], nombre[i], precio[i]);
                        bd.ActualizarEstatus(IDequipo);
                        bd.ActualizarCantidad(codigo[i], cantidad[i]);
                    }
                }
                /*Comenzamos la impresion del ticket*/
                ticket.setEmpresa(empresa);
                ticket.setPropietario(propietario);
                ticket.setRfc(rfc);
                ticket.setDireccion(direccion);
                ticket.setTelefono(telefono);
                ticket.setFolio(folioV);
                ticket.setCliente(nombreCliente);
                ticket.setArticulos(articulos);
                ticket.setSubTotal(subTotalS);
                ticket.setTotal(total);
                ticket.setRecibo(recibo);
                ticket.setCambio(cambio);
                ticket.setTotalLetra(totalLetra);
                ticket.setVendedor(vendedor);
                ticket.setFecha(fecha);
                try {
                    ticket.print(true);
                } catch (IOException ex) {
                    System.err.println("Error al generar venta " + ex.getMessage());
                }
                /*Terminamos la impresion del ticket*/
                txtV_NombreCliente.setText("");
                txtV_Folio.setText("");
                txtV_Modelo.setText("");
                txtV_NumeroSerie.setText("");
                txtV_Total.setText("0.0");
                txtV_PagaCon.setText("0.0");
                txtV_Cambio.setText("0.0");
                for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                    tablaArticulos.setValueAt(null, i, columnaCantidad);
                    tablaArticulos.setValueAt(null, i, columnaCodigo);
                    tablaArticulos.setValueAt(null, i, columnaNombreArticulo);
                    tablaArticulos.setValueAt(null, i, columnaPrecioU);
                    tablaArticulos.setValueAt(null, i, columnaPrecioT);
                }
                JOptionPane.showMessageDialog(null, "Venta exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            }
        }
    }//GEN-LAST:event_jButton_CerrarVentaActionPerformed

    private void jButton_AltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltasActionPerformed
        NuevoArticulo nuevoArticulo = new NuevoArticulo();
        nuevoArticulo.setVisible(true);
    }//GEN-LAST:event_jButton_AltasActionPerformed

    private void jButton_CorteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CorteDiarioActionPerformed

        try {
            bd.GenerarCorteDiario();
        } catch (IOException ex) {
            System.err.println("Error al generar ticket para el corte " + ex);
            JOptionPane.showMessageDialog(null, "¡Error al generar ticket! Contacte al Administrador\n Error: " + ex);
        }

    }//GEN-LAST:event_jButton_CorteDiarioActionPerformed

    private void jButton_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MostrarActionPerformed
        tablaVentas.setRowCount(0);
        tablaVentas.setColumnCount(0);

        String deDia, deMes, deAnnio, aDia, aMes, aAnnio, fechaI, fechaF;

        deDia = cmb_DeDia.getSelectedItem().toString();
        deMes = cmb_DeMes.getSelectedItem().toString();
        deAnnio = cmb_DeAnnio.getSelectedItem().toString();
        aDia = cmb_ADia.getSelectedItem().toString();
        aMes = cmb_AMes.getSelectedItem().toString();
        aAnnio = cmb_AAnnio.getSelectedItem().toString();

        fechaI = deAnnio + "-" + deMes + "-" + deDia;
        fechaF = aAnnio + "-" + aMes + "-" + aDia;

        java.sql.Date dateSQLI = java.sql.Date.valueOf(fechaI);
        java.sql.Date dateSQLF = java.sql.Date.valueOf(fechaF);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_venta, id_equipo, tipo_venta, total, fecha_venta from ventas where fecha_venta between '" + dateSQLI + "' and '" + dateSQLF + "'");
            ResultSet rs = pst.executeQuery();

            jTable_Ventas = new JTable(tablaVentas);
            jScrollPane_Ventas.setViewportView(jTable_Ventas);

            tablaVentas.addColumn(" ");
            tablaVentas.addColumn("Folio");
            tablaVentas.addColumn("Tipo venta");
            tablaVentas.addColumn("total");
            tablaVentas.addColumn("Fecha");

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int j = 0; j < 5; j++) {
                    fila[j] = rs.getObject(j + 1);

                }
                tablaVentas.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla ventas " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar tabla ventas! Contacte al administrador");
        }


    }//GEN-LAST:event_jButton_MostrarActionPerformed

    private void jButton_CorteCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CorteCustomActionPerformed
        String deDia, deMes, deAnnio, aDia, aMes, aAnnio, fechaI, fechaF;

        deDia = cmb_DeDia.getSelectedItem().toString();
        deMes = cmb_DeMes.getSelectedItem().toString();
        deAnnio = cmb_DeAnnio.getSelectedItem().toString();
        aDia = cmb_ADia.getSelectedItem().toString();
        aMes = cmb_AMes.getSelectedItem().toString();
        aAnnio = cmb_AAnnio.getSelectedItem().toString();

        fechaI = deAnnio + "-" + deMes + "-" + deDia;
        fechaF = aAnnio + "-" + aMes + "-" + aDia;

        java.sql.Date dateSQLI = java.sql.Date.valueOf(fechaI);
        java.sql.Date dateSQLF = java.sql.Date.valueOf(fechaF);

        try {
            bd.GenerarCortePersonalizado(dateSQLI, dateSQLF);
        } catch (IOException ex) {
            System.err.println("Error al generar ticket para el corte " + ex);
            JOptionPane.showMessageDialog(null, "¡Error al generar ticket! Contacte al Administrador\n Error: " + ex);
        }
    }//GEN-LAST:event_jButton_CorteCustomActionPerformed

    private void cmbV_VentaregistradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbV_VentaregistradaActionPerformed
        String seleccion = cmbV_Ventaregistrada.getSelectedItem().toString();

        if (seleccion.equals("Si")) {
            txtV_NombreCliente.setEnabled(true);
            txtV_Folio.setEnabled(true);
            jButton_BuscarEquipo.setEnabled(true);
        } else if (seleccion.equals("No")) {
            txtV_NombreCliente.setEnabled(false);
            txtV_Folio.setEnabled(false);
            jButton_BuscarEquipo.setEnabled(false);
        }
    }//GEN-LAST:event_cmbV_VentaregistradaActionPerformed

    private void jMenuItem_InfoVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InfoVersionActionPerformed
        InfoVersion infoVersion = new InfoVersion();
        infoVersion.setVisible(true);
    }//GEN-LAST:event_jMenuItem_InfoVersionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Capturista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbV_TipoVenta;
    private javax.swing.JComboBox<String> cmbV_Ventaregistrada;
    private javax.swing.JComboBox<String> cmb_AAnnio;
    private javax.swing.JComboBox<String> cmb_ADia;
    private javax.swing.JComboBox<String> cmb_AMes;
    private javax.swing.JComboBox<String> cmb_DeAnnio;
    private javax.swing.JComboBox<String> cmb_DeDia;
    private javax.swing.JComboBox<String> cmb_DeMes;
    private javax.swing.JButton jButton_Altas;
    private javax.swing.JButton jButton_BuscarCliente;
    private javax.swing.JButton jButton_BuscarEquipo;
    private javax.swing.JButton jButton_CerrarVenta;
    private javax.swing.JButton jButton_CorteCustom;
    private javax.swing.JButton jButton_CorteDiario;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_Mostrar;
    private javax.swing.JButton jButton_RegistrarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_A;
    private javax.swing.JLabel jLabel_Cambio;
    private javax.swing.JLabel jLabel_De;
    private javax.swing.JLabel jLabel_Folio;
    private javax.swing.JLabel jLabel_FondoCortes;
    private javax.swing.JLabel jLabel_FondoGenerarVenta;
    private javax.swing.JLabel jLabel_FondoGestionarClientes;
    private javax.swing.JLabel jLabel_FondoInventario;
    private javax.swing.JLabel jLabel_FondoRegistrarEquipo;
    private javax.swing.JLabel jLabel_FondoVistaCapturista;
    private javax.swing.JLabel jLabel_FondoVistaVentas;
    private javax.swing.JLabel jLabel_Marca;
    private javax.swing.JLabel jLabel_Modelo;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_NombreCliente;
    private javax.swing.JLabel jLabel_NombreCliente1;
    private javax.swing.JLabel jLabel_NombreUsurario;
    private javax.swing.JLabel jLabel_NumeroSerie;
    private javax.swing.JLabel jLabel_PagaCon;
    private javax.swing.JLabel jLabel_Titulo2;
    private javax.swing.JLabel jLabel_Titulo3;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_Acercade;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion;
    private javax.swing.JMenuItem jMenuItem_InfoVersion;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_Opciones;
    private javax.swing.JPanel jPanel_Cortes;
    private javax.swing.JPanel jPanel_GenerarVenta;
    private javax.swing.JPanel jPanel_GestionarClientes;
    private javax.swing.JPanel jPanel_Inventario;
    private javax.swing.JPanel jPanel_RegistrarEquipo;
    private javax.swing.JPanel jPanel_VistaCapturista;
    private javax.swing.JPanel jPanel_VistaVentas;
    private javax.swing.JScrollPane jScrollPane_Articulos;
    private javax.swing.JScrollPane jScrollPane_GestionarClientes;
    private javax.swing.JScrollPane jScrollPane_Observaciones;
    private javax.swing.JScrollPane jScrollPane_Productos;
    private javax.swing.JScrollPane jScrollPane_Servicios;
    private javax.swing.JScrollPane jScrollPane_Ventas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane_General;
    private javax.swing.JTabbedPane jTabbedPane_VistaCapturista;
    private javax.swing.JTable jTable_Articulos;
    private javax.swing.JTable jTable_Clientes;
    private javax.swing.JTable jTable_Productos;
    private javax.swing.JTable jTable_Servicios;
    private javax.swing.JTable jTable_Ventas;
    private javax.swing.JTextField txtV_Cambio;
    private javax.swing.JTextField txtV_Folio;
    private javax.swing.JTextField txtV_Marca;
    private javax.swing.JTextField txtV_Modelo;
    private javax.swing.JTextField txtV_NombreCliente;
    private javax.swing.JTextField txtV_NumeroSerie;
    private javax.swing.JTextField txtV_PagaCon;
    private javax.swing.JTextField txtV_Total;
    private javax.swing.JTextField txt_BuscarHistorial;
    private javax.swing.JTextField txt_BuscarProducto;
    private javax.swing.JTextField txt_BuscarServicio;
    private javax.swing.JTextField txt_Dirección;
    private javax.swing.JTextField txt_MailCliente;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    private javax.swing.JTextPane txt_Observaciones;
    private javax.swing.JTextField txt_TelefonoCliente;
    private javax.swing.JTextField txt_TipoEquipo;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTablaArticulos() {
        jTable_Articulos.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    String precioString = "", nombre = "";
                    double totalDouble = 0.0, subTotalDouble, precioDouble;

                    int columnaCantidad = tablaArticulos.findColumn("Cantidad");
                    int columnaCodigo = tablaArticulos.findColumn("Codigo");
                    int columnaNombreServicio = tablaArticulos.findColumn("Nombre");
                    int columnaPrecioUnitario = tablaArticulos.findColumn("Precio unitario");
                    int columnaPrecioTotal = tablaArticulos.findColumn("Precio total");

                    for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                        if (jTable_Articulos.getValueAt(i, columnaCantidad) != null && jTable_Articulos.getValueAt(i, columnaCodigo) != null) {
                            int cantidad = Integer.parseInt(jTable_Articulos.getValueAt(i, columnaCantidad).toString());
                            String codigo = (String) jTable_Articulos.getValueAt(i, columnaCodigo);

                            try {
                                Connection cn = Conexion.conectar();
                                PreparedStatement pst = cn.prepareStatement("select nombre, precio from articulos where codigo = '" + codigo + "'");

                                ResultSet rs = pst.executeQuery();
                                if (rs.next()) {
                                    nombre = rs.getString("nombre");
                                    precioString = rs.getString("precio");
                                } else {
                                    int seleccion = JOptionPane.showOptionDialog(null, "¿Desea agregarlo como articulo nuevo?",
                                            "El articulo no existe",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            new Object[]{"SI", "NO"},
                                            "SI");
                                    if (seleccion == 0) {
                                        NuevoArticulo nuevoArticulo = new NuevoArticulo();
                                        nuevoArticulo.setVisible(true);
                                    }
                                }
                                jTable_Articulos.setValueAt(nombre, i, columnaNombreServicio);

                                precioDouble = Double.parseDouble(precioString);
                                jTable_Articulos.setValueAt(precioDouble, i, columnaPrecioUnitario);

                                subTotalDouble = precioDouble * cantidad;
                                jTable_Articulos.setValueAt(subTotalDouble, i, columnaPrecioTotal);

                                totalDouble = totalDouble + subTotalDouble;
                                txtV_Total.setText(String.valueOf(totalDouble));

                                cn.close();

                            } catch (SQLException e) {
                                System.err.println("Error al mostrar precio del articulo " + e);
                            }
                        }
                    }
                }
            }
        });
    }

    public void Cambio() {
        txtV_PagaCon.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    double total = Double.parseDouble(txtV_Total.getText());
                    double pagaCon;
                    double cambio;

                    if ((Double.parseDouble(txtV_PagaCon.getText().trim()) >= total) && !(txtV_PagaCon.getText()).equals("")) {
                        pagaCon = Double.parseDouble(txtV_PagaCon.getText().trim());

                        cambio = pagaCon - total;

                        txtV_PagaCon.setText(String.valueOf(pagaCon));
                        txtV_Cambio.setText(String.valueOf(cambio));

                    } else {
                        txtV_PagaCon.setBackground(Color.red);
                        JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad que el cliente le ha entregado");

                    }

                }
            }
        });
    }

    public void BuscarHistorial() {
        txt_BuscarHistorial.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombreCliente;

                    tablaClientes.setRowCount(0);
                    tablaClientes.setColumnCount(0);

                    nombreCliente = txt_BuscarHistorial.getText().trim();

                    if (!nombreCliente.equals("")) {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select nombre_cliente from clientes where nombre_cliente = '" + nombreCliente + "'");

                            ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                try {
                                    Connection cn2 = Conexion.conectar();
                                    PreparedStatement pst2 = cn2.prepareStatement("select id_cliente, nombre_cliente, mail_cliente, tel_cliente, ultima_modificacion from clientes where "
                                            + "nombre_cliente = '" + nombreCliente + "'");

                                    ResultSet rs2 = pst2.executeQuery();

                                    jTable_Clientes = new JTable(tablaClientes);
                                    jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

                                    tablaClientes.addColumn(" ");
                                    tablaClientes.addColumn("Nombre");
                                    tablaClientes.addColumn("email");
                                    tablaClientes.addColumn("Teléfono");
                                    tablaClientes.addColumn("Modificado por");

                                    while (rs2.next()) {
                                        Object[] fila = new Object[5];

                                        for (int i = 0; i < 5; i++) {
                                            fila[i] = rs2.getObject(i + 1);
                                        }
                                        tablaClientes.addRow(fila);

                                    }
                                    cn2.close();

                                } catch (SQLException e) {
                                    System.err.println("Error al recuperar informacion del cliente " + e);
                                }
                                obtenerDatosTabla.ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);

                            } else {
                                JOptionPane.showMessageDialog(null, "El cliente no existe");
                            }
                            cn.close();

                        } catch (SQLException e) {
                            System.err.println("Error al consultar cliente " + e);
                        }

                    } else {
                        try { // Si el campo se encuentra vacio mostrara todos los registros.
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
                            JOptionPane.showMessageDialog(null, "Error al mostrar la información, contacte al administrador");
                        }
                        obtenerDatosTabla.ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);
                    }

                }
            }
        });
    }

    public void BuscarProducto() {
        txt_BuscarProducto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombre;

                    tablaProductos.setColumnCount(0);
                    tablaProductos.setRowCount(0);
                    nombre = txt_BuscarProducto.getText().trim();

                    if (!(txt_BuscarProducto.getText().trim()).equals("")) {
                        try {
                            Connection cn5 = Conexion.conectar();
                            PreparedStatement pst5 = cn5.prepareStatement("select id_articulo, codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto' and nombre = '" + nombre + "'");
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
                        }
                        obtenerDatosTabla.ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);

                    } else {
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
                            JOptionPane.showMessageDialog(null, "Error al mostrar los productos, contacte al administrador");
                        }
                        obtenerDatosTabla.ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);
                    }

                }
            }

        });
    }

    public void BuscarServicio() {
        txt_BuscarServicio.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombre;

                    tablaServicios.setColumnCount(0);
                    tablaServicios.setRowCount(0);
                    nombre = txt_BuscarServicio.getText().trim();

                    if (!(txt_BuscarServicio.getText().trim()).equals("")) {
                        try {
                            Connection cn5 = Conexion.conectar();
                            PreparedStatement pst5 = cn5.prepareStatement("select id_articulo, codigo, nombre, precio from articulos where tipo_articulo = 'servicio' and nombre = '" + nombre + "'");
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
                            System.err.println("Error al llenar la tabla Servicios " + e);
                        }
                        obtenerDatosTabla.ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
                    } else {
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
                            System.err.println("Error al llenar la tabla Servicios " + e);
                        }
                        obtenerDatosTabla.ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
                    }
                }
            }
        });
    }
}
