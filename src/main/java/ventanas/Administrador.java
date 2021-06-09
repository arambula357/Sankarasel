package ventanas;

import java.sql.*;
import clases.Conexion;
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
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;

public class Administrador extends javax.swing.JFrame {

    public static String subTotal, folio;
    public String recibirCantidad, recibirNombre, recibirPrecio, recibirPrecioU;

    String user, nombre_usuario;
    public static DefaultTableModel tablaUsuarios;
    public static DefaultTableModel tablaClientes;
    public static DefaultTableModel tablaEquipos;
    public static DefaultTableModel tablaArticulos;
    public static DefaultTableModel tablaProductos;
    public static DefaultTableModel tablaServicios;
    public static DefaultTableModel tablaVentas;

    codTicket ticket = new codTicket();
    NumeroLetras numeroLetras = new NumeroLetras();
    TicketRecepcion ordenServicio = new TicketRecepcion();
    BaseDatos bd = new BaseDatos();
    Crear crear = new Crear();

    public Administrador() {
        initComponents();
        user = Login.user;

        setSize(795, 720);
        setTitle("Administrador - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Crear wallpaper = new Crear(jLabel_Wallpaper);
        Crear fondoUsuarios = new Crear(jLabel_FondoUsuarios);
        Crear fondoRegistrarUsuario = new Crear(jLabel_FondoRegistrarUsuario);
        Crear fondoGestionarUsuarios = new Crear(jLabel_FondoGestionarUsuarios);
        Crear fondoVistaCapturista = new Crear(jLabel_FondoVistaCapturista);
        Crear fondoRegistraEquipo = new Crear(jLabel_FondoRegistrarEquipo);
        Crear fondoGestionarClientes = new Crear(jLabel_FondoGestionarClientes);
        Crear fondoVistaTecnico = new Crear(jLabel_FondoVistaTecnico);
        Crear fondoGestionarEquipos = new Crear(jLabel_FondoGestionarEquipos);
        Crear fondoVistaVentas = new Crear(jLabel_FondoVistaVentas);
        Crear fondoGenerarVentas = new Crear(jLabel_FondoGenerarVenta);
        Crear fondoInventario = new Crear(jLabel_FondoInventario);
        Crear fondoCortes = new Crear(jLabel_FondoCortes);

        Crear botonRegistrarUsuario = new Crear(jButton_RegistrarUsuario, "images/add.png", "No");
        Crear botonRegistrarEquipo = new Crear(jButton_RegistrarEquipo, "images/addSmartphone.png", "No");
        Crear botonBuscarCliente = new Crear(jButton_BuscarCliente, "images/iconoLupa.png", "Si");
        Crear botonImprimir = new Crear(jButton_Imprimir, "images/impresora.png", "No");
        Crear botonBuscarEquipo = new Crear(jButton_BuscarEquipo, "images/iconoLupa.png", "Si");
        Crear botonAltas = new Crear(jButton_Altas, "images/iconoSignoMas.png", "No");

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

        CrearTablaArticulos();

        Cambio();
        BuscarHistorial();
        BuscarProducto();
        BuscarServicio();
        addProducto();
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

        jDialog_Comun = new javax.swing.JDialog();
        jLabelC_Cantidad = new javax.swing.JLabel();
        txtC_Cantidad = new javax.swing.JTextField();
        jLabelC_Nombre = new javax.swing.JLabel();
        txtC_Nombre = new javax.swing.JTextField();
        jLabelC_Precio = new javax.swing.JLabel();
        txtC_Precio = new javax.swing.JTextField();
        jButtonC_Agregar = new javax.swing.JButton();
        jLabelC_FondoComun = new javax.swing.JLabel();
        jDialog_Descuento = new javax.swing.JDialog();
        jLabelD_Monto = new javax.swing.JLabel();
        txtD_Monto = new javax.swing.JTextField();
        jLabelD_Porcentaje = new javax.swing.JLabel();
        txtD_Porcentaje = new javax.swing.JTextField();
        jButtonD_Aceptar = new javax.swing.JButton();
        jLabelD_Porcentaje1 = new javax.swing.JLabel();
        jLabel_FondoDescuento = new javax.swing.JLabel();
        jDialog_Salida = new javax.swing.JDialog();
        jLabel_Cantidad = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jLabel_Concepto = new javax.swing.JLabel();
        txt_Concepto = new javax.swing.JTextField();
        jButtonS_Generar = new javax.swing.JButton();
        jLabel_FondoSalida = new javax.swing.JLabel();
        jTabbedPane_General = new javax.swing.JTabbedPane();
        jPanel_Usuarios = new javax.swing.JPanel();
        jTabbedPane_Usuarios = new javax.swing.JTabbedPane();
        jPanel_RegistrarUsuarios = new javax.swing.JPanel();
        jLabel_Titulo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Mail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        cmb_Niveles = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jButton_RegistrarUsuario = new javax.swing.JButton();
        jLabel_FondoRegistrarUsuario = new javax.swing.JLabel();
        jPanel_GestionarUsuarios = new javax.swing.JPanel();
        jScrollPane_GestionarUsuarios = new javax.swing.JScrollPane();
        jTable_Usuarios = new javax.swing.JTable();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_FondoGestionarUsuarios = new javax.swing.JLabel();
        jLabel_FondoUsuarios = new javax.swing.JLabel();
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
        txt_TipoEquipo = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        txt_TelefonoCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton_BuscarCliente = new javax.swing.JButton();
        jLabel_FondoRegistrarEquipo = new javax.swing.JLabel();
        jPanel_GestionarClientes = new javax.swing.JPanel();
        jScrollPane_GestionarClientes = new javax.swing.JScrollPane();
        jTable_Clientes = new javax.swing.JTable();
        jLabel_Titulo3 = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        txt_BuscarHistorial = new javax.swing.JTextField();
        jLabel_FondoGestionarClientes = new javax.swing.JLabel();
        jLabel_FondoVistaCapturista = new javax.swing.JLabel();
        jPanel_VistaTecnico = new javax.swing.JPanel();
        jTabbedPane_VistaTecnico = new javax.swing.JTabbedPane();
        jPanel_GestionarEquipos = new javax.swing.JPanel();
        jLabel_Titulo4 = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jScrollPane_Equipos = new javax.swing.JScrollPane();
        jTable_Equipos = new javax.swing.JTable();
        jLabel_FondoGestionarEquipos = new javax.swing.JLabel();
        jLabel_FondoVistaTecnico = new javax.swing.JLabel();
        jPanel_VistaVentas = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_GenerarVenta = new javax.swing.JPanel();
        jLabelV_NombreCliente = new javax.swing.JLabel();
        txtV_NombreCliente = new javax.swing.JTextField();
        jLabelV_Folio = new javax.swing.JLabel();
        txtV_Folio = new javax.swing.JTextField();
        jLabelV_Modelo = new javax.swing.JLabel();
        txtV_Modelo = new javax.swing.JTextField();
        jLabelV_NumeroSerie = new javax.swing.JLabel();
        txtV_NumeroSerie = new javax.swing.JTextField();
        jLabelV_Marca = new javax.swing.JLabel();
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
        cmbV_VentaRegistrada = new javax.swing.JComboBox<>();
        txtV_Marca = new javax.swing.JTextField();
        jLabel_VentaRegistrada = new javax.swing.JLabel();
        jButton_Comun = new javax.swing.JButton();
        jButton_Salida = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        txtV_addProducto = new javax.swing.JTextField();
        jLabel_FondoGenerarVenta = new javax.swing.JLabel();
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
        jLabel_Corte = new javax.swing.JLabel();
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

        jDialog_Comun.setSize(430, 300);
        jDialog_Comun.setResizable(false);
        jDialog_Comun.setLocationRelativeTo(null);
        jDialog_Comun.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_Comun.setTitle("Producto Comun");
        jDialog_Comun.setBackground(new java.awt.Color(37, 150, 190));
        jDialog_Comun.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelC_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelC_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelC_Cantidad.setText("Cantidad:");
        jDialog_Comun.getContentPane().add(jLabelC_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtC_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txtC_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtC_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtC_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtC_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Comun.getContentPane().add(txtC_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 25));

        jLabelC_Nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelC_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelC_Nombre.setText("Nombre:");
        jDialog_Comun.getContentPane().add(jLabelC_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtC_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txtC_Nombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtC_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txtC_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtC_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Comun.getContentPane().add(txtC_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 25));

        jLabelC_Precio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelC_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelC_Precio.setText("Precio:");
        jDialog_Comun.getContentPane().add(jLabelC_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtC_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txtC_Precio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtC_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txtC_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtC_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Comun.getContentPane().add(txtC_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, 25));

        jButtonC_Agregar.setBackground(new java.awt.Color(1, 89, 255));
        jButtonC_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonC_Agregar.setText("Agregar");
        jButtonC_Agregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonC_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonC_AgregarActionPerformed(evt);
            }
        });
        jDialog_Comun.getContentPane().add(jButtonC_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 100, 40));
        ImageIcon ImageAgregar = new ImageIcon("images/accept.png");
        Icon iconoAgregar = new ImageIcon(ImageAgregar.getImage());
        jButtonC_Agregar.setIcon(iconoAgregar);
        jDialog_Comun.getContentPane().add(jLabelC_FondoComun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 310));
        ImageIcon fondoComun = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon icoComun = new ImageIcon(fondoComun.getImage());
        jLabelC_FondoComun.setIcon(icoComun);
        jLabelC_FondoComun.repaint();

        jDialog_Descuento.setSize(330, 230);
        jDialog_Descuento.setResizable(false);
        jDialog_Descuento.setLocationRelativeTo(null);
        jDialog_Descuento.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_Descuento.setTitle("Descuento");
        jDialog_Descuento.setIconImage(getIconImage());
        jDialog_Descuento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelD_Monto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelD_Monto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelD_Monto.setText("Nuevo precio:");
        jDialog_Descuento.getContentPane().add(jLabelD_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtD_Monto.setBackground(new java.awt.Color(3, 37, 251));
        txtD_Monto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtD_Monto.setForeground(new java.awt.Color(255, 255, 255));
        txtD_Monto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtD_Monto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Descuento.getContentPane().add(txtD_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 25));

        jLabelD_Porcentaje.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelD_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelD_Porcentaje.setText("Porcentaje:");
        jDialog_Descuento.getContentPane().add(jLabelD_Porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtD_Porcentaje.setBackground(new java.awt.Color(3, 37, 251));
        txtD_Porcentaje.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtD_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        txtD_Porcentaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtD_Porcentaje.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Descuento.getContentPane().add(txtD_Porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 25));

        jButtonD_Aceptar.setBackground(new java.awt.Color(1, 89, 255));
        jButtonD_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonD_Aceptar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cloud\\Documents\\NetBeansProjects\\Sankarasel\\images\\accept.png")); // NOI18N
        jButtonD_Aceptar.setText("Aceptar");
        jButtonD_Aceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonD_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonD_AceptarActionPerformed(evt);
            }
        });
        jDialog_Descuento.getContentPane().add(jButtonD_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 100, 40));
        ImageIcon ImageAceptar = new ImageIcon("images/accept.png");
        Icon iconoAceptar = new ImageIcon(ImageAceptar.getImage());
        jButtonD_Aceptar.setIcon(iconoAceptar);

        jLabelD_Porcentaje1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelD_Porcentaje1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelD_Porcentaje1.setText("%");
        jDialog_Descuento.getContentPane().add(jLabelD_Porcentaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 100, -1, 30));
        jDialog_Descuento.getContentPane().add(jLabel_FondoDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));
        ImageIcon fondoDescuento = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon icoDescuento = new ImageIcon(fondoDescuento.getImage());
        jLabel_FondoDescuento.setIcon(icoDescuento);
        jLabel_FondoDescuento.repaint();

        jDialog_Salida.setSize(410, 240);
        jDialog_Salida.setResizable(false);
        jDialog_Salida.setLocationRelativeTo(null);
        jDialog_Salida.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_Salida.setTitle("Salida de efectivo");
        jDialog_Salida.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cantidad.setText("Cantidad:");
        jDialog_Salida.getContentPane().add(jLabel_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Salida.getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 25));

        jLabel_Concepto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Concepto.setText("Concepto:");
        jDialog_Salida.getContentPane().add(jLabel_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_Concepto.setBackground(new java.awt.Color(3, 37, 251));
        txt_Concepto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        txt_Concepto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Concepto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_Salida.getContentPane().add(txt_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, 25));

        jButtonS_Generar.setBackground(new java.awt.Color(1, 89, 255));
        jButtonS_Generar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonS_Generar.setText("Generar");
        jButtonS_Generar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonS_Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonS_GenerarActionPerformed(evt);
            }
        });
        jDialog_Salida.getContentPane().add(jButtonS_Generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 40));
        ImageIcon ImageGenerar = new ImageIcon("images/accept.png");
        Icon iconoGenerar = new ImageIcon(ImageGenerar.getImage());
        jButtonS_Generar.setIcon(iconoGenerar);
        jDialog_Salida.getContentPane().add(jLabel_FondoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));
        ImageIcon fondoSalida= new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon icoSalida = new ImageIcon(fondoSalida.getImage());
        jLabel_FondoSalida.setIcon(icoSalida);
        jLabel_FondoSalida.repaint();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Usuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_Usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_RegistrarUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_RegistrarUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo1.setText("Registro de usuarios");
        jPanel_RegistrarUsuarios.add(jLabel_Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel_RegistrarUsuarios.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setToolTipText("");
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarUsuarios.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("eMail:");
        jPanel_RegistrarUsuarios.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_Mail.setBackground(new java.awt.Color(3, 37, 251));
        txt_Mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_Mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Mail.setToolTipText("");
        txt_Mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarUsuarios.add(txt_Mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        jPanel_RegistrarUsuarios.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_Telefono.setBackground(new java.awt.Color(3, 37, 251));
        txt_Telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Telefono.setToolTipText("");
        txt_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarUsuarios.add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        cmb_Niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        jPanel_RegistrarUsuarios.add(cmb_Niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Permisos de:");
        jPanel_RegistrarUsuarios.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txt_Username.setBackground(new java.awt.Color(3, 37, 251));
        txt_Username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Username.setForeground(new java.awt.Color(255, 255, 255));
        txt_Username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Username.setToolTipText("");
        txt_Username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarUsuarios.add(txt_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        jPanel_RegistrarUsuarios.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password:");
        jPanel_RegistrarUsuarios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txt_Password.setBackground(new java.awt.Color(3, 37, 251));
        txt_Password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarUsuarios.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 210, -1));

        jButton_RegistrarUsuario.setBackground(new java.awt.Color(1, 89, 255));
        jButton_RegistrarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarUsuarioActionPerformed(evt);
            }
        });
        jPanel_RegistrarUsuarios.add(jButton_RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, 100));
        jPanel_RegistrarUsuarios.add(jLabel_FondoRegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 460));

        jTabbedPane_Usuarios.addTab("Registrar usuario", jPanel_RegistrarUsuarios);

        jPanel_GestionarUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GestionarUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_GestionarUsuarios.setViewportView(jTable_Usuarios);
        tablaUsuarios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaUsuarios.setRowCount(0);
        tablaUsuarios.setColumnCount(0);
        jTable_Usuarios = new JTable(tablaUsuarios);
        jScrollPane_GestionarUsuarios.setViewportView(jTable_Usuarios);
        crear.CrearTablaUsuarios(tablaUsuarios, jTable_Usuarios, jScrollPane_GestionarUsuarios);

        jPanel_GestionarUsuarios.add(jScrollPane_GestionarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 715, 300));

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Usuarios registrados");
        jPanel_GestionarUsuarios.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 320, -1));
        jPanel_GestionarUsuarios.add(jLabel_FondoGestionarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 460));

        jTabbedPane_Usuarios.addTab("Gestionar usuarios", jPanel_GestionarUsuarios);

        jPanel_Usuarios.add(jTabbedPane_Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 485));
        jPanel_Usuarios.add(jLabel_FondoUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Usuarios", jPanel_Usuarios);

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
        jPanel_RegistrarEquipo.add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Número de serie:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txt_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txt_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 210, -1));

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

        txt_TipoEquipo.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 210, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, -1));

        txt_TelefonoCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_TelefonoCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TelefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_TelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TelefonoCliente.setToolTipText("");
        txt_TelefonoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono:");
        jPanel_RegistrarEquipo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jButton_BuscarCliente.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarClienteActionPerformed(evt);
            }
        });
        jPanel_RegistrarEquipo.add(jButton_BuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 55, 30, 25));
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
        tablaClientes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaClientes.setRowCount(0);
        tablaClientes.setColumnCount(0);
        jTable_Clientes = new JTable(tablaClientes);
        jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);
        crear.CrearTablaClientes(tablaClientes, jTable_Clientes, jScrollPane_GestionarClientes);

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

        jPanel_VistaTecnico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaTecnico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_GestionarEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GestionarEquipos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo4.setText("Equipos registrados");
        jPanel_GestionarEquipos.add(jLabel_Titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "En revision", "Reparado", "No reparado", "Entregado" }));
        cmb_Estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_EstatusActionPerformed(evt);
            }
        });
        jPanel_GestionarEquipos.add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 130, -1));

        jTable_Equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Equipos.setToolTipText("");
        jScrollPane_Equipos.setViewportView(jTable_Equipos);
        tablaEquipos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaEquipos.setRowCount(0);
        tablaEquipos.setColumnCount(0);
        jTable_Equipos = new JTable(tablaEquipos);
        jScrollPane_Equipos.setViewportView(jTable_Equipos);
        crear.CrearTablaEquipos(tablaEquipos, jTable_Equipos, jScrollPane_Equipos);

        jPanel_GestionarEquipos.add(jScrollPane_Equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 715, 370));
        jPanel_GestionarEquipos.add(jLabel_FondoGestionarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 740, 457));

        jTabbedPane_VistaTecnico.addTab("Gestionar equipos", jPanel_GestionarEquipos);

        jPanel_VistaTecnico.add(jTabbedPane_VistaTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 485));
        jPanel_VistaTecnico.add(jLabel_FondoVistaTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Tecnico", jPanel_VistaTecnico);

        jPanel_VistaVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel_GenerarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GenerarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelV_NombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_NombreCliente.setText("Nombre cliente:");
        jPanel_GenerarVenta.add(jLabelV_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtV_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NombreCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 25));

        jLabelV_Folio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Folio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Folio.setText("Folio:");
        jPanel_GenerarVenta.add(jLabelV_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtV_Folio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Folio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Folio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Folio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 25));

        jLabelV_Modelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Modelo.setText("Modelo:");
        jPanel_GenerarVenta.add(jLabelV_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtV_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Modelo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Modelo.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 210, 25));

        jLabelV_NumeroSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_NumeroSerie.setText("Número de serie:");
        jPanel_GenerarVenta.add(jLabelV_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        txtV_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_NumeroSerie.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, 25));

        jLabelV_Marca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Marca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Marca.setText("Marca:");
        jPanel_GenerarVenta.add(jLabelV_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jTable_Articulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jTable_Articulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane_Articulos.setViewportView(jTable_Articulos);
        if (jTable_Articulos.getColumnModel().getColumnCount() > 0) {
            jTable_Articulos.getColumnModel().getColumn(0).setPreferredWidth(5);
        }
        tablaArticulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaArticulos.setRowCount(0);
        tablaArticulos.setColumnCount(0);
        jTable_Articulos = new JTable(tablaArticulos);
        jScrollPane_Articulos.setViewportView(jTable_Articulos);

        jPanel_GenerarVenta.add(jScrollPane_Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 500, 230));

        jButton_BuscarEquipo.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarEquipoActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_BuscarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 30, 25));

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
        txtV_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_Total.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Total.setText("0.0");
        txtV_Total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Total.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 100, 30));

        jLabel_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Total.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Total.setText("Total:");
        jPanel_GenerarVenta.add(jLabel_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel_PagaCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PagaCon.setText("Paga con:");
        jPanel_GenerarVenta.add(jLabel_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        txtV_PagaCon.setBackground(new java.awt.Color(3, 37, 251));
        txtV_PagaCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        txtV_PagaCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_PagaCon.setText("0.0");
        txtV_PagaCon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 100, 30));

        txtV_Cambio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Cambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Cambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Cambio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Cambio.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 100, 30));

        jLabel_Cambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cambio.setText("Cambio:");
        jPanel_GenerarVenta.add(jLabel_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, -1, -1));

        cmbV_TipoVenta.setForeground(new java.awt.Color(0, 0, 0));
        cmbV_TipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Transferencia" }));
        jPanel_GenerarVenta.add(cmbV_TipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, -1));

        cmbV_VentaRegistrada.setForeground(new java.awt.Color(0, 0, 0));
        cmbV_VentaRegistrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cmbV_VentaRegistrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbV_VentaRegistradaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(cmbV_VentaRegistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        txtV_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Marca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Marca.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, 25));

        jLabel_VentaRegistrada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_VentaRegistrada.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_VentaRegistrada.setText("¿Venta registrada?");
        jPanel_GenerarVenta.add(jLabel_VentaRegistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_Comun.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Comun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Comun.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Comun.setText("Común");
        jButton_Comun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ComunActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Comun, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 85, 25));

        jButton_Salida.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Salida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Salida.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salida.setText("Salida");
        jButton_Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalidaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 75, 25));

        jButton_Eliminar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Eliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 90, 25));

        txtV_addProducto.setBackground(new java.awt.Color(3, 37, 251));
        txtV_addProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtV_addProducto.setForeground(new java.awt.Color(255, 255, 255));
        txtV_addProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtV_addProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_addProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 220, 25));
        jPanel_GenerarVenta.add(jLabel_FondoGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

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
        tablaProductos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaProductos.setRowCount(0);
        tablaProductos.setColumnCount(0);
        jTable_Productos = new JTable(tablaProductos);
        jScrollPane_Productos.setViewportView(jTable_Productos);
        crear.CrearTablaProductos(tablaProductos, jTable_Productos, jScrollPane_Productos);

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
        tablaServicios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaServicios.setRowCount(0);
        tablaServicios.setColumnCount(0);
        jTable_Servicios = new JTable(tablaServicios);
        jScrollPane_Servicios.setViewportView(jTable_Servicios);
        crear.CrearTablaServicios(tablaServicios, jTable_Servicios, jScrollPane_Servicios);

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
        jPanel_Inventario.add(jButton_Altas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 100, 70));
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
        tablaVentas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaVentas.setRowCount(0);
        tablaVentas.setColumnCount(0);
        jTable_Ventas = new JTable(tablaVentas);
        jScrollPane_Ventas.setViewportView(jTable_Ventas);
        crear.CrearTablaVentas(tablaVentas, jTable_Ventas, jScrollPane_Ventas);

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

        jLabel_Corte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_Corte.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Corte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Corte.setText("Corte:");
        jPanel_Cortes.add(jLabel_Corte, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 100, 30));
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

    private void jButton_RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarUsuarioActionPerformed

        int permisos_cmb, validacion = 0;
        String nombre, mail, telefono, username, pass, permisos_string = "";

        nombre = txt_Nombre.getText().trim();
        mail = txt_Mail.getText().trim();
        telefono = txt_Telefono.getText().trim();
        username = txt_Username.getText().trim();
        pass = txt_Password.getText().trim();

        permisos_cmb = cmb_Niveles.getSelectedIndex() + 1;

        if (nombre.equals("")) {
            validacion++;
        }
        if (mail.equals("")) {
            validacion++;
        }
        if (telefono.equals("")) {
            validacion++;
        }
        if (username.equals("")) {
            validacion++;
        }
        if (pass.equals("")) {
            validacion++;
        }
        switch (permisos_cmb) {
            case 1:
                permisos_string = "Administrador";
                break;
            case 2:
                permisos_string = "Capturista";
                break;
            case 3:
                permisos_string = "Tecnico";
                break;
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select username from usuarios where username = '" + username + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_Username.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                cn.close();
            } else {

                cn.close();

                if (validacion == 0) {

                    try {

                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement("insert into usuarios values (?,?,?,?,?,?,?,?,?)");

                        pst2.setInt(1, 0);
                        pst2.setString(2, nombre);
                        pst2.setString(3, mail);
                        pst2.setString(4, telefono);
                        pst2.setString(5, username);
                        pst2.setString(6, pass);
                        pst2.setString(7, permisos_string);
                        pst2.setString(8, "Activo");
                        pst2.setString(9, user);

                        pst2.executeUpdate();
                        cn2.close();

                        LimpiarRegistrarUsuario(); //Declarado en la linea 320.

                        JOptionPane.showMessageDialog(null, "Registro exitoso");

                    } catch (SQLException e) {
                        System.err.println("Error en Registrar usuario " + e);
                        JOptionPane.showMessageDialog(null, "¡Error al registar!, contacte al Administrador");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }
            }

        } catch (SQLException e) {
            System.err.println("¡Error al validar nombre de usuario!" + e);
            JOptionPane.showMessageDialog(null, "¡Error al comparar usuario! Contacte al Administrador");
        }
    }//GEN-LAST:event_jButton_RegistrarUsuarioActionPerformed

    private void jButton_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarEquipoActionPerformed

        int validacion = 0, IDcliente = 0, IDclienteUpdate = 0, idR;
        String nombreCliente, telefono, tipo_equipo, marca, modelo, numeroSerie, dia_ingreso, mes_ingreso, annio_ingreso, estatus, observaciones, hora, minuto, segundo, fechaHora,
                hora_ingreso;

        nombreCliente = txt_NombreCliente.getText().trim();
        telefono = txt_TelefonoCliente.getText().trim();
        tipo_equipo = txt_TipoEquipo.getText().trim();
        marca = txt_Marca.getText().trim();
        modelo = txt_Modelo.getText().trim();
        numeroSerie = txt_NumeroSerie.getText().trim();
        observaciones = txt_Observaciones.getText();
        estatus = "Nuevo ingreso";

        if (tipo_equipo.equals("")) {
            validacion++;
        }
        if (marca.equals("")) {
            validacion++;
        }
        if (modelo.equals("")) {
            validacion++;
        }
        if (numeroSerie.equals("")) {
            validacion++;
        }
        if (nombreCliente.equals("")) {
            validacion++;
        }
        if (telefono.equals("")) {
            validacion++;
        }
        if (observaciones.equals("")) {
            txt_Observaciones.setText("Sin observaciones.");
            observaciones = "Sin observaciones";
        }

        LocalDateTime tiempoActual = LocalDateTime.now();
        dia_ingreso = String.valueOf(tiempoActual.getDayOfMonth());
        mes_ingreso = String.valueOf(tiempoActual.getMonthValue());
        annio_ingreso = String.valueOf(tiempoActual.getYear());
        hora = Integer.toString(tiempoActual.getHour());
        minuto = Integer.toString(tiempoActual.getMinute());
        segundo = Integer.toString(tiempoActual.getSecond());

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
                    PreparedStatement pst2 = cn2.prepareStatement("insert into clientes values (?,?,?,?)");

                    pst2.setInt(1, 0);
                    pst2.setString(2, nombreCliente);
                    pst2.setString(3, telefono);
                    pst2.setString(4, user);

                    pst2.executeUpdate();
                    cn2.close();

                } catch (SQLException e) {
                    System.err.println("Error al hacer nuevo registro en la tabla clientes " + e);
                }
            } else { //Si la condicion anterior no se cumple se ejecuta una secundaria, es decir el cliente ya existe en la BD.
                try { // Actualizamos la información del cliente dentro de la BD.
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update clientes set nombre_cliente=?, tel_cliente=?, ultima_modificacion=? "
                            + "where id_cliente = '" + IDcliente + "'");

                    pst2.setString(1, nombreCliente);
                    pst2.setString(2, telefono);
                    pst2.setString(3, user);

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
            txt_TelefonoCliente.setText("");
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

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("images/BannerPDF.jpg");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del cliente\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tablaCliente = new PdfPTable(3);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Telefono");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tablaCliente.addCell(rs.getString("id_cliente"));
                        tablaCliente.addCell(rs.getString("nombre_cliente"));
                        tablaCliente.addCell(rs.getString("tel_cliente"));
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

        String nombreCliente, telefonoCliente = "";

        nombreCliente = txt_NombreCliente.getText().trim();

        if (!(txt_NombreCliente.getText().trim()).equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes where nombre_cliente = '" + nombreCliente + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    telefonoCliente = rs.getString("tel_cliente");

                } else {

                    JOptionPane.showMessageDialog(null, "El cliente no existe", "Buscar cliente", HEIGHT);
                }
                cn.close();

            } catch (SQLException e) {
                System.err.println("Error al cargar cliente " + e);
            }
            txt_TelefonoCliente.setText(telefonoCliente);
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

        String nombreCliente, folioV, modelo, marca, numeroSerie, subTotalS, total, recibo, cambio, articulosT = "", articulosV = "", fecha, dia, mes, annio, tipoVenta;
        String empresa, propietario, rfc, direccion, telefono, totalLetra, vendedor, seleccion;

        int IDequipo, validacion = 0;
        int columnaCantidad = tablaArticulos.findColumn("Cantidad");
        int columnaCodigo = tablaArticulos.findColumn("Codigo");
        int columnaNombreArticulo = tablaArticulos.findColumn("Nombre");
        int columnaPrecioT = tablaArticulos.findColumn("Precio total");

        String[] cantidad = new String[99];
        String[] codigo = new String[99];
        String[] nombre = new String[99];
        String[] precio = new String[99];

        seleccion = cmbV_VentaRegistrada.getSelectedItem().toString();
        nombreCliente = txtV_NombreCliente.getText().trim();
        folioV = txtV_Folio.getText().trim();
        marca = txtV_Marca.getText().trim();
        modelo = txtV_Modelo.getText().trim();
        numeroSerie = txtV_NumeroSerie.getText().trim();

        subTotalS = txtV_Total.getText().trim();
        total = txtV_Total.getText().trim();
        recibo = txtV_PagaCon.getText().trim();
        cambio = txtV_Cambio.getText().trim();
        tipoVenta = cmbV_TipoVenta.getSelectedItem().toString();

        LocalDateTime fechaActual = LocalDateTime.now();
        dia = String.valueOf(fechaActual.getDayOfMonth());
        mes = String.valueOf(fechaActual.getMonthValue());
        annio = String.valueOf(fechaActual.getYear());

        if (nombreCliente.equals("")) {
            validacion++;
        }
        if (folioV.equals("")) {
            validacion++;
        }
        if (marca.equals("")) {
            validacion++;
        }
        if (modelo.equals("")) {
            validacion++;
        }
        if (numeroSerie.equals("")) {
            validacion++;
        }

        if (seleccion.equals("No")) {
            if (Double.parseDouble(recibo) >= Double.parseDouble(total)) {
                fecha = dia + " / " + mes + " / " + annio;
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
                        if (articulosT.equals("")) { //Genera la acumulacion de articulos para el ticket.
                            articulosT = cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                        } else {
                            articulosT = articulosT + cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                        }

                        if (articulosV.equals("")) {//Genera la acumulacion de articulos para la base de datos.
                            articulosV = cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
                        } else {
                            articulosV = articulosV + cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
                        }
                        
                        

                        bd.RegistroVenta(articulosV, total, tipoVenta);
                        bd.CrearSumatoria(cantidad[i], codigo[i], nombre[i], precio[i], tipoVenta);
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
                ticket.setArticulos(articulosT);
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
                txtV_Total.setText("0.0");
                txtV_PagaCon.setText("0.0");
                txtV_Cambio.setText("");
                for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                    tablaArticulos.removeRow(i);
                }
                JOptionPane.showMessageDialog(null, "Venta exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad recibida no puede ser menor al total");
            }
        } else if (seleccion.equals("Si")) {
            if (validacion == 0) {
                if (Double.parseDouble(recibo) >= Double.parseDouble(total)) {
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
                            if (articulosT.equals("")) { //Genera la acumulacion de articulos para el ticket.
                                articulosT = cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                            } else {
                                articulosT = articulosT + cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                            }

                            if (articulosV.equals("")) {//Genera la acumulacion de articulos para la base de datos.
                                articulosV = cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
                            } else {
                                articulosV = articulosV + cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
                            }

                            bd.RegistroVenta(articulosV, total, tipoVenta);
                            bd.CrearSumatoria(cantidad[i], codigo[i], nombre[i], precio[i], tipoVenta);
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
                    ticket.setArticulos(articulosT);
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
                    txtV_Marca.setText("");
                    txtV_Modelo.setText("");
                    txtV_NumeroSerie.setText("");
                    txtV_Total.setText("0.0");
                    txtV_PagaCon.setText("0.0");
                    txtV_Cambio.setText("");
                    for (int i = 0; i < tablaArticulos.getRowCount(); i++) {
                        tablaArticulos.removeRow(i);
                    }
                    JOptionPane.showMessageDialog(null, "Venta exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad recibida no puede ser menor al total");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos con la información del equipo");
            }
        }
    }//GEN-LAST:event_jButton_CerrarVentaActionPerformed

    private void cmb_EstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_EstatusActionPerformed
        String seleccion = cmb_Estatus.getSelectedItem().toString();
        String query;

        tablaEquipos.setRowCount(0);
        tablaEquipos.setColumnCount(0);

        try {
            Connection cn4 = Conexion.conectar();

            if (seleccion.equals("Todos")) {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos";
            } else {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + seleccion + "'";
            }
            PreparedStatement pst4 = cn4.prepareStatement(query);
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
            System.err.println("Error al recuperar los registros de equipos " + e);
        }
        crear.ObtenerDatosTablaEquipos(tablaEquipos, jTable_Equipos);

    }//GEN-LAST:event_cmb_EstatusActionPerformed

    private void jButton_AltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltasActionPerformed
        NuevoArticulo nuevoArticulo = new NuevoArticulo();
        nuevoArticulo.setVisible(true);
    }//GEN-LAST:event_jButton_AltasActionPerformed

    private void jButton_CorteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CorteDiarioActionPerformed

        bd.GenerarCorteDiario();

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
        crear.ObtenerDatosTablaVentas(tablaVentas, jTable_Ventas);
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

        bd.GenerarCorteCustom(dateSQLI, dateSQLF);
    }//GEN-LAST:event_jButton_CorteCustomActionPerformed

    private void cmbV_VentaRegistradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbV_VentaRegistradaActionPerformed
        String seleccion = cmbV_VentaRegistrada.getSelectedItem().toString();
        if (seleccion.equals("Si")) {
            txtV_NombreCliente.setEnabled(true);
            txtV_Folio.setEnabled(true);
            jButton_BuscarEquipo.setEnabled(true);
            jLabelV_NombreCliente.setVisible(true);
            jLabelV_Folio.setVisible(true);
            jLabelV_Marca.setVisible(true);
            jLabelV_Modelo.setVisible(true);
            jLabelV_NumeroSerie.setVisible(true);
            txtV_NombreCliente.setVisible(true);
            txtV_Folio.setVisible(true);
            txtV_Marca.setVisible(true);
            txtV_Modelo.setVisible(true);
            txtV_NumeroSerie.setVisible(true);
            jButton_BuscarEquipo.setVisible(true);
        } else if (seleccion.equals("No")) {
            txtV_NombreCliente.setEnabled(false);
            txtV_Folio.setEnabled(false);
            jButton_BuscarEquipo.setEnabled(false);
            jLabelV_NombreCliente.setVisible(false);
            jLabelV_Folio.setVisible(false);
            jLabelV_Marca.setVisible(false);
            jLabelV_Modelo.setVisible(false);
            jLabelV_NumeroSerie.setVisible(false);
            txtV_NombreCliente.setVisible(false);
            txtV_Folio.setVisible(false);
            txtV_Marca.setVisible(false);
            txtV_Modelo.setVisible(false);
            txtV_NumeroSerie.setVisible(false);
            jButton_BuscarEquipo.setVisible(false);
        }
    }//GEN-LAST:event_cmbV_VentaRegistradaActionPerformed

    private void jMenuItem_InfoVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InfoVersionActionPerformed
        InfoVersion infoVersion = new InfoVersion();
        infoVersion.setVisible(true);
    }//GEN-LAST:event_jMenuItem_InfoVersionActionPerformed

    private void jButton_SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalidaActionPerformed
        jDialog_Salida.setVisible(true);
    }//GEN-LAST:event_jButton_SalidaActionPerformed

    private void jButtonC_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonC_AgregarActionPerformed
        String cantidad, nombre, precio, precioT, total;
        int validacion = 0;
        DefaultTableModel m;

        cantidad = txtC_Cantidad.getText().trim();
        nombre = txtC_Nombre.getText().trim();
        precio = txtC_Precio.getText().trim();

        if (cantidad.equals("")) {
            txtC_Cantidad.setBackground(Color.red);
            validacion++;
        }
        if (nombre.equals("")) {
            txtC_Nombre.setBackground(Color.red);
            validacion++;
        }
        if (precio.equals("")) {
            txtC_Precio.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            precioT = String.valueOf(Integer.parseInt(cantidad) * Double.parseDouble(precio));
            total = String.valueOf(Double.parseDouble(txtV_Total.getText().trim()) + Double.parseDouble(precioT));

            m = (DefaultTableModel) jTable_Articulos.getModel();

            String filaNueva[] = {cantidad, "P. Comun", nombre, precio, precioT};

            m.addRow(filaNueva);

            txtC_Cantidad.setText("");
            txtC_Nombre.setText("");
            txtC_Precio.setText("");

            txtV_Total.setText(total);

            jDialog_Comun.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar los campos 'Cantidad', 'Nombre' y 'Precio' para continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonC_AgregarActionPerformed

    private void jButton_ComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ComunActionPerformed
        jDialog_Comun.setVisible(true);
    }//GEN-LAST:event_jButton_ComunActionPerformed

    private void jButtonD_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonD_AceptarActionPerformed
        int filaEditar, columnaCantidad, columnaCodigo, columnaPrecioU, columnaPrecioT;
        int cantidadI;
        double precioD = 0.0, montoD = 0.0, porcentajeD, precioTotalD = 0.0, totalActualD = 0.0, nuevoTotalD = 0.0, operacionPrecio = 0.0, operacionPorcien = 0.0;
        String monto = "", porcentaje = "", cantidad, codigo, precio = "", precioTotal, totalActual, nuevoTotal;

        filaEditar = jTable_Articulos.getSelectedRow();
        columnaCantidad = tablaArticulos.findColumn("Cantidad");
        columnaCodigo = tablaArticulos.findColumn("Codigo");
        columnaPrecioU = tablaArticulos.findColumn("Precio unitario");
        columnaPrecioT = tablaArticulos.findColumn("Precio total");

        cantidad = (String) jTable_Articulos.getValueAt(filaEditar, columnaCantidad);
        codigo = (String) jTable_Articulos.getValueAt(filaEditar, columnaCodigo);

        totalActual = txtV_Total.getText().trim();
        monto = txtD_Monto.getText().trim();
        porcentaje = txtD_Porcentaje.getText().trim();

        if (!monto.equals("") && !porcentaje.equals("")) {
            JOptionPane.showMessageDialog(null, "Solo es posible realizar un calculo a la vez");
        } else if (!monto.equals("") || !porcentaje.equals("")) {
            if (!monto.equals("")) {

                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select precio from articulos where codigo = '" + codigo + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        precio = rs.getString("precio");

                    }
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Error al consultar precio");
                    JOptionPane.showMessageDialog(null, "El producto no cuenta con un registro previo");
                }

                /*Conversion de datos de String a numéricos*/
                cantidadI = Integer.parseInt(cantidad);
                precioD = Double.parseDouble(precio);
                montoD = Double.parseDouble(monto);
                totalActualD = Double.parseDouble(totalActual);

                operacionPrecio = cantidadI * precioD;
                precioTotalD = cantidadI * montoD;

                nuevoTotalD = (totalActualD - operacionPrecio) + precioTotalD;

                /*Conversión de datos de numéricos a String*/
                precioTotal = String.valueOf(precioTotalD);
                nuevoTotal = String.valueOf(nuevoTotalD);

                jTable_Articulos.setValueAt(monto, filaEditar, columnaPrecioU);
                jTable_Articulos.setValueAt(precioTotal, filaEditar, columnaPrecioT);

                txtV_Total.setText(nuevoTotal);

                txtD_Monto.setText("");
                txtD_Porcentaje.setText("");
                jDialog_Descuento.dispose();
            } else if (!porcentaje.equals("")) {

                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select precio from articulos where codigo = '" + codigo + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        precio = rs.getString("precio");

                    }
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Error al consultar precio");
                    JOptionPane.showMessageDialog(null, "El producto no cuenta con un registro previo");
                }

                /*Conversion de datos de String a numéricos*/
                cantidadI = Integer.parseInt(cantidad);
                precioD = Double.parseDouble(precio);
                porcentajeD = Integer.parseInt(porcentaje);
                totalActualD = Double.parseDouble(totalActual);

                operacionPorcien = (porcentajeD * precioD) / 100;
                operacionPrecio = cantidadI * precioD;
                montoD = precioD - operacionPorcien;
                precioTotalD = cantidadI * montoD;

                nuevoTotalD = (totalActualD - operacionPrecio) + precioTotalD;

                /*Conversión de datos de numéricos a String*/
                precioTotal = String.valueOf(precioTotalD);
                nuevoTotal = String.valueOf(nuevoTotalD);
                monto = String.valueOf(montoD);

                jTable_Articulos.setValueAt(monto, filaEditar, columnaPrecioU);
                jTable_Articulos.setValueAt(precioTotal, filaEditar, columnaPrecioT);

                txtV_Total.setText(nuevoTotal);

                txtD_Monto.setText("");
                txtD_Porcentaje.setText("");
                jDialog_Descuento.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar al menos uno de los campos");
        }
    }//GEN-LAST:event_jButtonD_AceptarActionPerformed

    private void jButtonS_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonS_GenerarActionPerformed
        String cantidad, concepto;

        cantidad = txt_Cantidad.getText().trim();
        concepto = txt_Concepto.getText().trim();

        if (!cantidad.equals("") && !concepto.equals("")) {
            bd.RegistroSalida(cantidad, concepto);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar ambos campos");
        }
        jDialog_Salida.dispose();
    }//GEN-LAST:event_jButtonS_GenerarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        int filaSeleccionada = jTable_Articulos.getSelectedRow();
        int columnaPrecioT = tablaArticulos.findColumn("Precio total");
        String precioTotalActual = (String) jTable_Articulos.getValueAt(filaSeleccionada, columnaPrecioT);
        String totalActual = txtV_Total.getText().trim();
        String totalNuevo = String.valueOf(Double.parseDouble(totalActual) - Double.parseDouble(precioTotalActual));
        
        txtV_Total.setText(totalNuevo);
        tablaArticulos.removeRow(filaSeleccionada);
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbV_TipoVenta;
    private javax.swing.JComboBox<String> cmbV_VentaRegistrada;
    private javax.swing.JComboBox<String> cmb_AAnnio;
    private javax.swing.JComboBox<String> cmb_ADia;
    private javax.swing.JComboBox<String> cmb_AMes;
    private javax.swing.JComboBox<String> cmb_DeAnnio;
    private javax.swing.JComboBox<String> cmb_DeDia;
    private javax.swing.JComboBox<String> cmb_DeMes;
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JComboBox<String> cmb_Niveles;
    private javax.swing.JButton jButtonC_Agregar;
    private javax.swing.JButton jButtonD_Aceptar;
    private javax.swing.JButton jButtonS_Generar;
    private javax.swing.JButton jButton_Altas;
    private javax.swing.JButton jButton_BuscarCliente;
    private javax.swing.JButton jButton_BuscarEquipo;
    private javax.swing.JButton jButton_CerrarVenta;
    private javax.swing.JButton jButton_Comun;
    private javax.swing.JButton jButton_CorteCustom;
    private javax.swing.JButton jButton_CorteDiario;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_Mostrar;
    private javax.swing.JButton jButton_RegistrarEquipo;
    private javax.swing.JButton jButton_RegistrarUsuario;
    private javax.swing.JButton jButton_Salida;
    private javax.swing.JDialog jDialog_Comun;
    private javax.swing.JDialog jDialog_Descuento;
    private javax.swing.JDialog jDialog_Salida;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelC_Cantidad;
    private javax.swing.JLabel jLabelC_FondoComun;
    private javax.swing.JLabel jLabelC_Nombre;
    private javax.swing.JLabel jLabelC_Precio;
    private javax.swing.JLabel jLabelD_Monto;
    private javax.swing.JLabel jLabelD_Porcentaje;
    private javax.swing.JLabel jLabelD_Porcentaje1;
    private javax.swing.JLabel jLabelV_Folio;
    private javax.swing.JLabel jLabelV_Marca;
    private javax.swing.JLabel jLabelV_Modelo;
    private javax.swing.JLabel jLabelV_NombreCliente;
    private javax.swing.JLabel jLabelV_NumeroSerie;
    private javax.swing.JLabel jLabel_A;
    private javax.swing.JLabel jLabel_Cambio;
    private javax.swing.JLabel jLabel_Cantidad;
    private javax.swing.JLabel jLabel_Concepto;
    private javax.swing.JLabel jLabel_Corte;
    private javax.swing.JLabel jLabel_De;
    private javax.swing.JLabel jLabel_FondoCortes;
    private javax.swing.JLabel jLabel_FondoDescuento;
    private javax.swing.JLabel jLabel_FondoGenerarVenta;
    private javax.swing.JLabel jLabel_FondoGestionarClientes;
    private javax.swing.JLabel jLabel_FondoGestionarEquipos;
    private javax.swing.JLabel jLabel_FondoGestionarUsuarios;
    private javax.swing.JLabel jLabel_FondoInventario;
    private javax.swing.JLabel jLabel_FondoRegistrarEquipo;
    private javax.swing.JLabel jLabel_FondoRegistrarUsuario;
    private javax.swing.JLabel jLabel_FondoSalida;
    private javax.swing.JLabel jLabel_FondoUsuarios;
    private javax.swing.JLabel jLabel_FondoVistaCapturista;
    private javax.swing.JLabel jLabel_FondoVistaTecnico;
    private javax.swing.JLabel jLabel_FondoVistaVentas;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_NombreUsurario;
    private javax.swing.JLabel jLabel_PagaCon;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Titulo1;
    private javax.swing.JLabel jLabel_Titulo2;
    private javax.swing.JLabel jLabel_Titulo3;
    private javax.swing.JLabel jLabel_Titulo4;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JLabel jLabel_VentaRegistrada;
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
    private javax.swing.JPanel jPanel_GestionarEquipos;
    private javax.swing.JPanel jPanel_GestionarUsuarios;
    private javax.swing.JPanel jPanel_Inventario;
    private javax.swing.JPanel jPanel_RegistrarEquipo;
    private javax.swing.JPanel jPanel_RegistrarUsuarios;
    private javax.swing.JPanel jPanel_Usuarios;
    private javax.swing.JPanel jPanel_VistaCapturista;
    private javax.swing.JPanel jPanel_VistaTecnico;
    private javax.swing.JPanel jPanel_VistaVentas;
    private javax.swing.JScrollPane jScrollPane_Articulos;
    private javax.swing.JScrollPane jScrollPane_Equipos;
    private javax.swing.JScrollPane jScrollPane_GestionarClientes;
    private javax.swing.JScrollPane jScrollPane_GestionarUsuarios;
    private javax.swing.JScrollPane jScrollPane_Observaciones;
    private javax.swing.JScrollPane jScrollPane_Productos;
    private javax.swing.JScrollPane jScrollPane_Servicios;
    private javax.swing.JScrollPane jScrollPane_Ventas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane_General;
    private javax.swing.JTabbedPane jTabbedPane_Usuarios;
    private javax.swing.JTabbedPane jTabbedPane_VistaCapturista;
    private javax.swing.JTabbedPane jTabbedPane_VistaTecnico;
    private javax.swing.JTable jTable_Articulos;
    private javax.swing.JTable jTable_Clientes;
    private javax.swing.JTable jTable_Equipos;
    private javax.swing.JTable jTable_Productos;
    private javax.swing.JTable jTable_Servicios;
    public javax.swing.JTable jTable_Usuarios;
    private javax.swing.JTable jTable_Ventas;
    private javax.swing.JTextField txtC_Cantidad;
    private javax.swing.JTextField txtC_Nombre;
    private javax.swing.JTextField txtC_Precio;
    private javax.swing.JTextField txtD_Monto;
    private javax.swing.JTextField txtD_Porcentaje;
    private javax.swing.JTextField txtV_Cambio;
    private javax.swing.JTextField txtV_Folio;
    private javax.swing.JTextField txtV_Marca;
    private javax.swing.JTextField txtV_Modelo;
    private javax.swing.JTextField txtV_NombreCliente;
    private javax.swing.JTextField txtV_NumeroSerie;
    private javax.swing.JTextField txtV_PagaCon;
    private javax.swing.JTextField txtV_Total;
    private javax.swing.JTextField txtV_addProducto;
    private javax.swing.JTextField txt_BuscarHistorial;
    private javax.swing.JTextField txt_BuscarProducto;
    private javax.swing.JTextField txt_BuscarServicio;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Concepto;
    private javax.swing.JTextField txt_Mail;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    private javax.swing.JTextPane txt_Observaciones;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_TelefonoCliente;
    private javax.swing.JTextField txt_TipoEquipo;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables

    public void LimpiarRegistrarUsuario() {

        txt_Nombre.setText("");
        txt_Mail.setText("");
        txt_Telefono.setText("");
        txt_Username.setText("");
        txt_Password.setText("");
        cmb_Niveles.setSelectedIndex(0);
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
                                    PreparedStatement pst2 = cn2.prepareStatement("select id_cliente, nombre_cliente, tel_cliente, ultima_modificacion from clientes where "
                                            + "nombre_cliente = '" + nombreCliente + "'");

                                    ResultSet rs2 = pst2.executeQuery();

                                    jTable_Clientes = new JTable(tablaClientes);
                                    jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

                                    tablaClientes.addColumn(" ");
                                    tablaClientes.addColumn("Nombre");
                                    tablaClientes.addColumn("Teléfono");
                                    tablaClientes.addColumn("Modificado por");

                                    while (rs2.next()) {
                                        Object[] fila = new Object[4];

                                        for (int i = 0; i < 4; i++) {
                                            fila[i] = rs2.getObject(i + 1);
                                        }
                                        tablaClientes.addRow(fila);

                                    }
                                    cn2.close();

                                } catch (SQLException e) {
                                    System.err.println("Error al recuperar informacion del cliente " + e);
                                }
                                crear.ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);

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
                            PreparedStatement pst3 = cn3.prepareStatement("select id_cliente, nombre_cliente, tel_cliente, ultima_modificacion from clientes");

                            ResultSet rs3 = pst3.executeQuery();

                            jTable_Clientes = new JTable(tablaClientes);
                            jScrollPane_GestionarClientes.setViewportView(jTable_Clientes);

                            tablaClientes.addColumn(" ");
                            tablaClientes.addColumn("Nombre");
                            tablaClientes.addColumn("Teléfono");
                            tablaClientes.addColumn("Modificado por");

                            while (rs3.next()) {
                                Object[] fila = new Object[4];

                                for (int i = 0; i < 4; i++) {
                                    fila[i] = rs3.getObject(i + 1);
                                }
                                tablaClientes.addRow(fila);

                            }
                            cn3.close();

                        } catch (SQLException e) {
                            System.err.println("Error al llenar la tabla " + e);
                            JOptionPane.showMessageDialog(null, "Error al mostrar la información, contacte al administrador");
                        }
                        crear.ObtenerDatosTablaClientes(tablaClientes, jTable_Clientes);
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
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select id_articulo, codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto' and nombre = '" + nombre + "'");
                            ResultSet rs = pst.executeQuery();

                            jTable_Productos = new JTable(tablaProductos);
                            jScrollPane_Productos.setViewportView(jTable_Productos);

                            tablaProductos.addColumn(" ");
                            tablaProductos.addColumn("Codigo");
                            tablaProductos.addColumn("Nombre");
                            tablaProductos.addColumn("Cantidad");
                            tablaProductos.addColumn("Precio");

                            while (rs.next()) {
                                Object[] fila = new Object[5];

                                for (int i = 0; i < 5; i++) {
                                    fila[i] = rs.getObject(i + 1);
                                }
                                tablaProductos.addRow(fila);
                            }
                            cn.close();

                        } catch (SQLException e) {
                            System.err.println("Error al llenar la tabla Productos " + e);
                        }
                        crear.ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);

                    } else {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select id_articulo, codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto'");
                            ResultSet rs = pst.executeQuery();

                            jTable_Productos = new JTable(tablaProductos);
                            jScrollPane_Productos.setViewportView(jTable_Productos);

                            tablaProductos.addColumn(" ");
                            tablaProductos.addColumn("Codigo");
                            tablaProductos.addColumn("Nombre");
                            tablaProductos.addColumn("Cantidad");
                            tablaProductos.addColumn("Precio");

                            while (rs.next()) {
                                Object[] fila = new Object[5];

                                for (int i = 0; i < 5; i++) {
                                    fila[i] = rs.getObject(i + 1);
                                }
                                tablaProductos.addRow(fila);
                            }
                            cn.close();

                        } catch (SQLException e) {
                            System.err.println("Error al llenar la tabla Productos " + e);
                            JOptionPane.showMessageDialog(null, "Error al mostrar los productos, contacte al administrador");
                        }
                        crear.ObtenerDatosTablaProductos(tablaProductos, jTable_Productos);
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
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select id_articulo, codigo, nombre, precio from articulos where tipo_articulo = 'servicio' and nombre = '" + nombre + "'");
                            ResultSet rs = pst.executeQuery();

                            jTable_Servicios = new JTable(tablaServicios);
                            jScrollPane_Servicios.setViewportView(jTable_Servicios);

                            tablaServicios.addColumn(" ");
                            tablaServicios.addColumn("Codigo");
                            tablaServicios.addColumn("Nombre");
                            tablaServicios.addColumn("Precio");

                            while (rs.next()) {
                                Object[] fila = new Object[4];

                                for (int i = 0; i < 4; i++) {
                                    fila[i] = rs.getObject(i + 1);
                                }
                                tablaServicios.addRow(fila);
                            }
                            cn.close();

                        } catch (SQLException e) {
                            System.err.println("Error al llenar la tabla Servicios " + e);
                        }
                        crear.ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
                    } else {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select id_articulo, codigo, nombre, precio from articulos where tipo_articulo = 'servicio'");
                            ResultSet rs = pst.executeQuery();

                            jTable_Servicios = new JTable(tablaServicios);
                            jScrollPane_Servicios.setViewportView(jTable_Servicios);

                            tablaServicios.addColumn(" ");
                            tablaServicios.addColumn("Codigo");
                            tablaServicios.addColumn("Nombre");
                            tablaServicios.addColumn("Precio");

                            while (rs.next()) {
                                Object[] fila = new Object[4];

                                for (int i = 0; i < 4; i++) {
                                    fila[i] = rs.getObject(i + 1);
                                }
                                tablaServicios.addRow(fila);
                            }
                            cn.close();

                        } catch (SQLException e) {
                            System.err.println("Error al llenar la tabla Servicios " + e);
                        }
                        crear.ObtenerDatosTablaServicios(tablaServicios, jTable_Servicios);
                    }
                }
            }
        });
    }

    public void CrearTablaArticulos() {
        tablaArticulos.setRowCount(0);
        tablaArticulos.setColumnCount(0);

        jTable_Articulos = new JTable(tablaArticulos);
        jScrollPane_Articulos.setViewportView(jTable_Articulos);

        tablaArticulos.addColumn("Cantidad");
        tablaArticulos.addColumn("Codigo");
        tablaArticulos.addColumn("Nombre");
        tablaArticulos.addColumn("Precio unitario");
        tablaArticulos.addColumn("Precio total");

        DobleClick();
    }

    public void DobleClick() {
        jTable_Articulos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Articulos.rowAtPoint(e.getPoint());
                int columna_point = 2;
                String codigo = "";

                if (e.getClickCount() == 2) {
                    codigo = (String) tablaArticulos.getValueAt(fila_point, columna_point);
                    if (codigo.equals("P. Comun")) {
                        JOptionPane.showMessageDialog(null, "No puedes realizar un descuento a articulos sin registro", "Articulo sin registro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        jDialog_Descuento.setVisible(true);
                    }
                }
            }
        });
    }

    public void addProducto() {
        txtV_addProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String cantidad = "", codigo = "", nombre = "", precio = "", precioT = "", parte1 = "", parte2 = "";
                    String cadena = txtV_addProducto.getText().trim();

                    char[] cadenaDiv = cadena.toCharArray();
                    for (int i = 0; i < cadenaDiv.length; i++) {
                        char simbolo = cadena.charAt(i);
                        if (simbolo == '*') {
                            String[] division = cadena.split("\\*");
                            parte1 = division[0];
                            parte2 = division[1];
                        }
                    }
                    if (!parte1.equals("") && !parte2.equals("")) {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select nombre, precio from articulos where codigo = '" + parte2 + "'");

                            ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                cantidad = parte1;
                                codigo = parte2;
                                nombre = rs.getString("nombre");
                                precio = rs.getString("precio");

                                precioT = String.valueOf(Integer.parseInt(cantidad) * Double.parseDouble(precio));

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
                            String[] valores = {cantidad, codigo, nombre, precio, precioT};

                            tablaArticulos.addRow(valores);
                            txtV_addProducto.setText("");
                            String total = String.valueOf(Double.parseDouble(txtV_Total.getText().trim()) + Double.parseDouble(precioT));
                            txtV_Total.setText(total);
                        } catch (SQLException e) {
                            System.err.println("Error al caprurar datos en tabla articulos: " + e.getMessage());
                        }
                    } else {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select nombre, precio from articulos where codigo = '" + cadena + "'");

                            ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                cantidad = "1";
                                codigo = cadena;
                                nombre = rs.getString("nombre");
                                precio = rs.getString("precio");

                                precioT = String.valueOf(Integer.parseInt(cantidad) * Double.parseDouble(precio));

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
                            String[] valores = {cantidad, codigo, nombre, precio, precioT};

                            tablaArticulos.addRow(valores);
                            txtV_addProducto.setText("");
                            String total = String.valueOf(Double.parseDouble(txtV_Total.getText().trim()) + Double.parseDouble(precioT));
                            txtV_Total.setText(total);
                        } catch (SQLException e) {
                            System.err.println("Error al capturar datos en tabla articulos: " + e.getMessage());
                        }
                    }
                }
            }
        });
    }
}
