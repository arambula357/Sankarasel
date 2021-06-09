package ventanas;

import java.sql.*;
import clases.Conexion;
import clases.Crear;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class InformacionEquipoTecnico extends javax.swing.JFrame {

    int IDequipo = 0, sesion_usuario;
    String user = "";
    private String stat = "";

    public InformacionEquipoTecnico() {
        initComponents();
        user = Login.user;
        IDequipo = Crear.IDequipoUpdate;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from equipos where id_equipo = '" + IDequipo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_TipoEquipo.setText(rs.getString("tipo_equipo"));
                cmb_Estatus.setSelectedItem(rs.getString("estatus"));
                txt_Marca.setText(rs.getString("marca"));
                txt_Modelo.setText(rs.getString("modelo"));
                txt_NumeroSerie.setText(rs.getString("num_serie"));
                txt_ModificacionPor.setText(rs.getString("ultima_modificacion"));

                String dia = "", mes = "", annio = "";
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");

                txt_Fecha.setText(dia + " / " + mes + " / " + annio);

                txt_Observaciones.setText(rs.getString("observaciones"));
                txt_ComentariosTecnico.setText(rs.getString("comentarios_tecnicos"));
                jLabel_RevisionTecnicaDe.setText("Comentarios y actualizaciones técnicas de " + rs.getString("revision_tecnica_de"));

                stat = rs.getString("estatus");
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar equipo " + e);
        }

        setTitle("Información de equipo - Sesión de " + user);
        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Crear wallpaper = new Crear(jLabel_Wallpaper);

        if (!stat.equals("Entregado")) {
            cmb_Estatus.setEnabled(true);
            txt_ComentariosTecnico.setEditable(true);
            jButton_Actualizar.setEnabled(true);
        } else {
            cmb_Estatus.setEnabled(false);
            txt_ComentariosTecnico.setEditable(false);
            jButton_Actualizar.setEnabled(false);
            jLabel_Titulo.setText("Información de equipo (Entregado)");
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
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jLabel_RevisionTecnicaDe = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        txt_TipoEquipo = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_NumeroSerie = new javax.swing.JTextField();
        txt_ModificacionPor = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JTextField();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ComentariosTecnico = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información de equipo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Número de serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de ingreso:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima modificación por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_Nombre7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus:");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel_RevisionTecnicaDe.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_RevisionTecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RevisionTecnicaDe.setText("Comentarios y actualizaciones técnicas:");
        getContentPane().add(jLabel_RevisionTecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NombreCliente.setEnabled(false);
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_TipoEquipo.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_TipoEquipo.setEnabled(false);
        getContentPane().add(txt_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Marca.setEnabled(false);
        getContentPane().add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Modelo.setEnabled(false);
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txt_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NumeroSerie.setEnabled(false);
        getContentPane().add(txt_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ModificacionPor.setBackground(new java.awt.Color(3, 37, 251));
        txt_ModificacionPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ModificacionPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModificacionPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ModificacionPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ModificacionPor.setEnabled(false);
        getContentPane().add(txt_ModificacionPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_Fecha.setBackground(new java.awt.Color(3, 37, 251));
        txt_Fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_Fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Fecha.setEnabled(false);
        getContentPane().add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "En revision", "Reparado", "No reparado" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        txt_Observaciones.setEditable(false);
        jScrollPane1.setViewportView(txt_Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jScrollPane2.setViewportView(txt_ComentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(3, 37, 251));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Comentar y actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 405, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Programación de botón.
    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        String estatus, comentariosTecnicos;

        estatus = cmb_Estatus.getSelectedItem().toString();
        comentariosTecnicos = txt_ComentariosTecnico.getText();

        if (comentariosTecnicos.equals("")) {
            txt_ComentariosTecnico.setText("Sin comentarios");
            comentariosTecnicos = "Sin comentarios";
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("update equipos set estatus=?, comentarios_tecnicos=?, revision_tecnica_de=?, ultima_modificacion=? where id_equipo = '" + IDequipo + "'");

            pst.setString(1, estatus);
            pst.setString(2, comentariosTecnicos);
            pst.setString(3, user);
            pst.setString(4, user);

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Actualización exitosa");
            this.dispose();

        } catch (SQLException e) {
            System.err.println("Error al actualizar equipo " + e);
            JOptionPane.showMessageDialog(null, "¡Error al actualizar equipo! Contacte al Administrador");
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipoTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipoTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_RevisionTecnicaDe;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txt_ComentariosTecnico;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_ModificacionPor;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    private javax.swing.JTextPane txt_Observaciones;
    private javax.swing.JTextField txt_TipoEquipo;
    // End of variables declaration//GEN-END:variables

}
