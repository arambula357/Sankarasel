package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import clases.Crear;
import clases.BaseDatos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";
    BaseDatos bd = new BaseDatos();

    public Login() {
        initComponents();
        setSize(500, 750);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        Crear wallpaper = new Crear(jLabel_Wallpaper);

        ImageIcon logo = new ImageIcon("images/logo-sankarasel-mediano.png");
        Icon icono_logo = new ImageIcon(logo.getImage().getScaledInstance(jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();

        Ingresar();
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

        jDialog_InicioTurno = new javax.swing.JDialog();
        txt_Cantidad = new javax.swing.JTextField();
        jLabel_Cantidad = new javax.swing.JLabel();
        jButtonS_Generar = new javax.swing.JButton();
        jLabel_FondoInicio = new javax.swing.JLabel();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_User = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        jLabel_Password = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        jDialog_InicioTurno.setSize(300, 200);
        jDialog_InicioTurno.setResizable(false);
        jDialog_InicioTurno.setLocationRelativeTo(null);
        jDialog_InicioTurno.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDialog_InicioTurno.getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 25));

        jLabel_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cantidad.setText("Cantidad inicio:");
        jDialog_InicioTurno.getContentPane().add(jLabel_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jButtonS_Generar.setBackground(new java.awt.Color(1, 89, 255));
        jButtonS_Generar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonS_Generar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cloud\\Documents\\NetBeansProjects\\Sankarasel\\images\\accept.png")); // NOI18N
        jButtonS_Generar.setText("Aceptar");
        jButtonS_Generar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonS_Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonS_GenerarActionPerformed(evt);
            }
        });
        jDialog_InicioTurno.getContentPane().add(jButtonS_Generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 100, 40));

        jLabel_FondoInicio.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cloud\\Documents\\NetBeansProjects\\Sankarasel\\images\\wallpaperPrincipal.jpg")); // NOI18N
        jDialog_InicioTurno.getContentPane().add(jLabel_FondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 220));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 204));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 270, 270));

        jLabel_User.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_User.setText("Usuario:");
        getContentPane().add(jLabel_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        txt_User.setBackground(new java.awt.Color(3, 37, 251));
        txt_User.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_User.setForeground(new java.awt.Color(255, 255, 255));
        txt_User.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_User.setToolTipText("");
        txt_User.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 270, -1));

        jLabel_Password.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_Password.setText("Password:");
        getContentPane().add(jLabel_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        txt_Password.setBackground(new java.awt.Color(3, 37, 251));
        txt_Password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 270, -1));

        jButton_Acceder.setBackground(new java.awt.Color(3, 37, 251));
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 120, 30));

        jLabel_Footer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("Creado por Diego Arambula");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 687, 500, 20));

        jLabel_Wallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Wallpaper.setAutoscrolls(true);
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Programación del botón.
    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        user = txt_User.getText().trim();
        pass = txt_Password.getText().trim();
        if (!user.equals("") || !pass.equals("")) { // Solo si ambos campos estan llenos se ejecuntan las intrucciones
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select tipo_nivel, estatus from usuarios where username = '" + user + "' and password = '" + pass + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        if (ComprobarInicio()) {
                            dispose();
                            new Capturista().setVisible(true);
                        } else {
                            jDialog_InicioTurno.setVisible(true);
                        }
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                    txt_User.setText("");
                    txt_Password.setText("");
                }
            } catch (SQLException e) {
                System.err.println("Error en el boton acceder: " + e.getMessage()); //Envia un mensaje color rojo
                JOptionPane.showMessageDialog(null, "¡Error al iniciar sesión!, contacte al admministrador");
            }
        } else { //En caso de no llenar alguno de los dos campos se envia este mensaje
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void jButtonS_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonS_GenerarActionPerformed
        String cantidadS = txt_Cantidad.getText().trim();
        double cantidad = Double.parseDouble(cantidadS);

        LocalDateTime fechaActual = LocalDateTime.now();
        String dia = String.valueOf(fechaActual.getDayOfMonth());
        String mes = String.valueOf(fechaActual.getMonthValue());
        String annio = String.valueOf(fechaActual.getYear());
        
        String fecha = dia + "/" + mes + "/" + annio;

        if (!cantidadS.equals("")) {
            bd.RegistroInicioTurno(cantidad, fecha, user);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar el campo para iniciar");
        }
        jDialog_InicioTurno.dispose();
        this.dispose();
        new Capturista().setVisible(true);
    }//GEN-LAST:event_jButtonS_GenerarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonS_Generar;
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JDialog jDialog_InicioTurno;
    private javax.swing.JLabel jLabel_Cantidad;
    private javax.swing.JLabel jLabel_FondoInicio;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLabel jLabel_User;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables

    private void Ingresar() {
        txt_Password.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    user = txt_User.getText().trim();
                    pass = txt_Password.getText().trim();
                    if (!user.equals("") || !pass.equals("")) { // Solo si ambos campos estan llenos se ejecuntan las intrucciones
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("select tipo_nivel, estatus from usuarios where username = '" + user + "' and password = '" + pass + "'");
                            ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                String tipo_nivel = rs.getString("tipo_nivel");
                                String estatus = rs.getString("estatus");
                                if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                                    dispose();
                                    new Administrador().setVisible(true);
                                } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                                    if (ComprobarInicio()) {
                                        dispose();
                                        new Capturista().setVisible(true);
                                    } else {
                                        jDialog_InicioTurno.setVisible(true);
                                    }
                                } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                                    dispose();
                                    new Tecnico().setVisible(true);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                                txt_User.setText("");
                                txt_Password.setText("");
                            }
                        } catch (SQLException e) {
                            System.err.println("Error al acceder: " + e);
                            JOptionPane.showMessageDialog(null, "¡Error el iniciar sesión!, contacte al admministrador");
                        }
                    } else { //En caso de no llenar alguno de los dos campos se envia este mensaje
                        JOptionPane.showMessageDialog(null, "Debe llenar ambos campos");
                    }
                }
            }
        });
    }

    private boolean ComprobarInicio() {
        LocalDateTime fechaActual = LocalDateTime.now();
        String dia = String.valueOf(fechaActual.getDayOfMonth());
        String mes = String.valueOf(fechaActual.getMonthValue());
        String annio = String.valueOf(fechaActual.getYear());
        
        String fecha = dia + "/" + mes + "/" + annio;

        boolean comprobación = false;
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_inicioturno from inicioturno where fecha = '" + fecha + "'");
            ResultSet rs = pst.executeQuery();

            comprobación = rs.next();

        } catch (SQLException e) {
            System.err.println("Error al consultar el inicio de turno");
        }
        return comprobación;
    }
}
