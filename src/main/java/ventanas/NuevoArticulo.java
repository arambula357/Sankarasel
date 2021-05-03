package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class NuevoArticulo extends javax.swing.JFrame {

    String user = "";

    public NuevoArticulo() {
        initComponents();
        user = Login.user;

        setSize(435, 455);
        setTitle("Nuevo articulo - Sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon boton = new ImageIcon("images/iconoNubeFlecha.png");
        Icon iconoB = new ImageIcon(boton.getImage());
        jButton_Alta.setIcon(iconoB);
        this.repaint();
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

        jLabel_Titulo = new javax.swing.JLabel();
        cmb_TipoArticulo = new javax.swing.JComboBox<>();
        jLabel_TipoArticulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel_CantidadActual = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jButton_Alta = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Nuevo articulo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        cmb_TipoArticulo.setEditable(true);
        cmb_TipoArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Servicio" }));
        cmb_TipoArticulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_TipoArticuloItemStateChanged(evt);
            }
        });
        getContentPane().add(cmb_TipoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel_TipoArticulo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_TipoArticulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TipoArticulo.setText("Tipo de articulo:");
        getContentPane().add(jLabel_TipoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jLabel_Codigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Codigo.setText("Código:");
        getContentPane().add(jLabel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_Codigo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Codigo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jLabel_Precio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Precio.setText("Precio:");
        getContentPane().add(jLabel_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Precio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        jLabel_CantidadActual.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_CantidadActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CantidadActual.setText("Cantidad:");
        getContentPane().add(jLabel_CantidadActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, -1));

        jButton_Alta.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 110, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltaActionPerformed
        int validacion = 0;
        String tipoArticulo, nombreArticulo, codigoArticulo, precioArticulo, cantidadArticulo;

        tipoArticulo = (cmb_TipoArticulo.getSelectedItem()).toString();
        nombreArticulo = txt_Nombre.getText().trim();
        codigoArticulo = txt_Codigo.getText().trim();
        precioArticulo = txt_Precio.getText().trim();
        cantidadArticulo = txt_Cantidad.getText().trim();

        if (nombreArticulo.equals("")) {
            txt_Nombre.setBackground(Color.red);
            validacion++;
        }
        if (codigoArticulo.equals("")) {
            txt_Codigo.setBackground(Color.red);
            validacion++;
        }
        if (precioArticulo.equals("")) {
            txt_Precio.setBackground(Color.red);
            validacion++;
        }
        if (tipoArticulo.equals("Producto")) {
            if (cantidadArticulo.equals("")) {
                txt_Cantidad.setBackground(Color.red);
                validacion++;
            }
        }

        try {
            Connection cn1 = Conexion.conectar();
            PreparedStatement pst1 = cn1.prepareStatement("select codigo from articulos where codigo = '" + codigoArticulo + "'");
            ResultSet rs1 = pst1.executeQuery();

            if (rs1.next()) {
                txt_Codigo.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El codigo de aticulo no esta disponible");
                cn1.close();
            } else {
                if (validacion == 0) {
                    if (tipoArticulo.equals("Producto")) {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("insert into articulos values (?,?,?,?,?,?,?)");

                            pst.setInt(1, 0);
                            pst.setString(2, codigoArticulo);
                            pst.setString(3, nombreArticulo);
                            pst.setString(4, cantidadArticulo);
                            pst.setString(5, precioArticulo);
                            pst.setString(6, tipoArticulo);
                            pst.setString(7, user);

                            pst.executeUpdate();
                            cn.close();

                            LimpiarCampos();

                            txt_Nombre.setBackground(Color.GREEN);
                            txt_Codigo.setBackground(Color.GREEN);
                            txt_Precio.setBackground(Color.GREEN);
                            txt_Cantidad.setBackground(Color.GREEN);

                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                        } catch (SQLException e) {
                            System.err.println("Error al ingresar producto " + e);
                        }
                    }
                    if (tipoArticulo.equals("Servicio")) {
                        try {
                            Connection cn = Conexion.conectar();
                            PreparedStatement pst = cn.prepareStatement("insert into articulos values (?,?,?,?,?,?,?)");

                            pst.setInt(1, 0);
                            pst.setString(2, codigoArticulo);
                            pst.setString(3, nombreArticulo);
                            pst.setString(4, "");
                            pst.setString(5, precioArticulo);
                            pst.setString(6, tipoArticulo);
                            pst.setString(7, user);

                            pst.executeUpdate();
                            cn.close();

                            LimpiarCampos();

                            txt_Nombre.setBackground(Color.GREEN);
                            txt_Codigo.setBackground(Color.GREEN);
                            txt_Precio.setBackground(Color.GREEN);
                            txt_Cantidad.setBackground(Color.GREEN);

                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                        } catch (SQLException e) {
                            System.err.println("Error al ingresar servicio " + e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar los campos requeridos");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar codigo de articulo " + e);
            JOptionPane.showMessageDialog(null, "¡Error al comparar articulo! Contacte al Administrador");
        }
    }//GEN-LAST:event_jButton_AltaActionPerformed

    private void cmb_TipoArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoArticuloItemStateChanged

        if ((cmb_TipoArticulo.getSelectedItem()).equals("Producto")) {
            txt_Cantidad.setEnabled(true);
        } else {
            txt_Cantidad.setEnabled(false);
        }


    }//GEN-LAST:event_cmb_TipoArticuloItemStateChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoArticulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_TipoArticulo;
    private javax.swing.JButton jButton_Alta;
    private javax.swing.JLabel jLabel_CantidadActual;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JLabel jLabel_TipoArticulo;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables

    private void LimpiarCampos() {
        txt_Nombre.setText("");
        txt_Codigo.setText("");
        txt_Precio.setText("");
        txt_Cantidad.setText("");
    }

}
