package ventanas;

import java.sql.*;
import clases.Conexion;
import clases.Crear;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Producto extends javax.swing.JFrame {

    int cantidadActual, masCantidad, IDproducto = 0;
    String nombre, codigo, precio, user = "";
    
    Crear crear = new Crear();

    public Producto() {
        initComponents();
        user = Login.user;
        IDproducto = Crear.IDproducto;

        setSize(435, 455);
        setTitle("Información producto");
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        crear.CrearFondo(jLabel_Wallpaper);
        crear.CrearFondo(jButton_ActualizarProducto, "images/iconoActualizar.png", false);
        
        
        try { // Obtener nombre completo del usuario que inicio sesión.
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select codigo from articulos where id_articulo = '" + IDproducto + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jLabel_Titulo.setText("Informacion del producto " + rs.getString("codigo"));

            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar codigo del producto " + e);
        }
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select codigo, nombre, cantidad, precio, ultima_modificacion from articulos where id_articulo = '" + IDproducto + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                txt_Nombre.setText(rs.getString("nombre"));
                txt_Codigo.setText(rs.getString("codigo"));
                txt_CantidadActual.setText(rs.getString("cantidad"));
                txt_Precio.setText(rs.getString("precio"));
                txt_UltimaActualizacion.setText(rs.getString("ultima_modificacion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar la informacion del producto " + e);
        }
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
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel_CantidadActual = new javax.swing.JLabel();
        txt_CantidadActual = new javax.swing.JTextField();
        jLabel_MasCantidad = new javax.swing.JLabel();
        txt_MasCantidad = new javax.swing.JTextField();
        jLabel_UltimaActualizacion = new javax.swing.JLabel();
        txt_UltimaActualizacion = new javax.swing.JTextField();
        jButton_ActualizarProducto = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del producto");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        jLabel_Codigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Codigo.setText("Código:");
        getContentPane().add(jLabel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txt_Codigo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Codigo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jLabel_Precio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Precio.setText("Precio:");
        getContentPane().add(jLabel_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Precio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jLabel_CantidadActual.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_CantidadActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CantidadActual.setText("Cantidad actual:");
        getContentPane().add(jLabel_CantidadActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_CantidadActual.setBackground(new java.awt.Color(3, 37, 251));
        txt_CantidadActual.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_CantidadActual.setForeground(new java.awt.Color(255, 255, 255));
        txt_CantidadActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CantidadActual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_CantidadActual.setEnabled(false);
        getContentPane().add(txt_CantidadActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, -1));

        jLabel_MasCantidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_MasCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_MasCantidad.setText("Agrgar la cantidad de:");
        getContentPane().add(jLabel_MasCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_MasCantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_MasCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_MasCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_MasCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_MasCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_MasCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, -1));

        jLabel_UltimaActualizacion.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_UltimaActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UltimaActualizacion.setText("Ultima modificacion:");
        getContentPane().add(jLabel_UltimaActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        txt_UltimaActualizacion.setBackground(new java.awt.Color(3, 37, 251));
        txt_UltimaActualizacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_UltimaActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltimaActualizacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_UltimaActualizacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltimaActualizacion.setEnabled(false);
        getContentPane().add(txt_UltimaActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        jButton_ActualizarProducto.setBackground(new java.awt.Color(1, 89, 255));
        jButton_ActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 110, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarProductoActionPerformed
        int validacion = 0, nuevaCantidad;
        String nuevaCantidadS;
        
        String cantidadActualS = txt_CantidadActual.getText().trim();
        String masCantidadS = txt_MasCantidad.getText().trim();
        nombre = txt_Nombre.getText().trim();
        codigo = txt_Codigo.getText().trim();
        precio = txt_Precio.getText().trim();
        
        if (nombre.equals("")) {
            validacion++;
        }
        if (codigo.equals("")) {
            validacion++;
        }
        if (precio.equals("")) {
            validacion++;
        }
        if (cantidadActualS.equals("")) {
            validacion++;
        }
        if (masCantidadS.equals("")) {
            masCantidadS = "0";
        }

        if (validacion == 0) {
            cantidadActual = Integer.parseInt(cantidadActualS);
            masCantidad = Integer.parseInt(masCantidadS);
            
            nuevaCantidad = cantidadActual + masCantidad;
            
            nuevaCantidadS = String.valueOf(nuevaCantidad);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update articulos set codigo=?, nombre=?, cantidad=?, precio=?, ultima_modificacion=? where id_articulo = '" + IDproducto + "'");

                pst.setString(1, codigo);
                pst.setString(2, nombre);
                pst.setString(3, nuevaCantidadS);
                pst.setString(4, precio);
                pst.setString(5, user);

                pst.executeUpdate();
                cn.close();

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en actualizar producto " + e);
                JOptionPane.showMessageDialog(null, "!Error al actualizar articulo¡ Contacte al Administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_jButton_ActualizarProductoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarProducto;
    private javax.swing.JLabel jLabel_CantidadActual;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_MasCantidad;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_UltimaActualizacion;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_CantidadActual;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_MasCantidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_UltimaActualizacion;
    // End of variables declaration//GEN-END:variables
}
