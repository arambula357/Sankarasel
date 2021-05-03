package ventanas;

import java.sql.*;
import clases.Conexion;
import clases.ObtenerDatosTabla;
import clases.TicketRecepcion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;

public class InformacionEquipo extends javax.swing.JFrame {

    TicketRecepcion ordenServicio = new TicketRecepcion();

    int IDclienteUpdate = 0, IDequipo = 0;
    String user = "", nom_cliente = "", nombre_usuario;

    public InformacionEquipo() {
        initComponents();
        user = Login.user;
        IDclienteUpdate = ObtenerDatosTabla.IDclienteUpdate;
        IDequipo = InformacionCliente.IDequipo;

        try { // Obtener nombre completo del usuario que inicio sesión.
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_usuario from usuarios where username = '" + user + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombre del usuario " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_cliente from clientes where id_cliente = '" + IDclienteUpdate + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nom_cliente = rs.getString("nombre_cliente");

            }

        } catch (SQLException e) {
            System.err.println("Error al consultar cliente " + e);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from equipos where id_equipo = '" + IDequipo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_TipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_Estatus.setSelectedItem(rs.getString("estatus"));
                txt_Marca.setText(rs.getString("marca"));
                txt_Modelo.setText(rs.getString("modelo"));
                txt_NumeroSerie.setText(rs.getString("num_serie"));
                txt_ModificacionPor.setText(rs.getString("ultima_modificacion"));
                txt_NombreCliente.setText("nombre_cliente");

                String dia, mes, annio;
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");

                txt_Fecha.setText(dia + " / " + mes + " / " + annio);

                jTextPane_Observaciones.setText(rs.getString("observaciones"));
                jTextPane_ComentariosTecnico.setText(rs.getString("comentarios_tecnicos"));
                jLabel_RevisionTecnicaDe.setText("Comentarios y actualizaciones técnicas de " + rs.getString("revision_tecnica_de"));

            }

        } catch (SQLException e) {
            System.err.println("Error al consultar equipo " + e);
        }

        setTitle("Información de equipo - Sesión de " + user);
        setSize(670, 540);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Insertamos imagen de fondo.
        ImageIcon wallpaper = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon boton = new ImageIcon("images/impresora.png");
        Icon iconoB = new ImageIcon(boton.getImage().getScaledInstance(jButton_GenrarTicket.getWidth(), jButton_GenrarTicket.getHeight(), Image.SCALE_DEFAULT));
        jButton_GenrarTicket.setIcon(iconoB);
        this.repaint();

        txt_NombreCliente.setText(nom_cliente);

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
        txt_Modelo = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        txt_NumeroSerie = new javax.swing.JTextField();
        txt_ModificacionPor = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JTextField();
        cmb_TipoEquipo = new javax.swing.JComboBox<>();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_Observaciones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_ComentariosTecnico = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_GenrarTicket = new javax.swing.JButton();
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

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Modelo.setEnabled(false);
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Marca.setEnabled(false);
        getContentPane().add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

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

        cmb_TipoEquipo.setEditable(true);
        cmb_TipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smartphone", "Laptop" }));
        cmb_TipoEquipo.setEnabled(false);
        getContentPane().add(cmb_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jScrollPane1.setViewportView(jTextPane_Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jTextPane_ComentariosTecnico.setEditable(false);
        jScrollPane2.setViewportView(jTextPane_ComentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(3, 37, 251));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar equipo");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 405, 210, 35));

        jButton_GenrarTicket.setBackground(new java.awt.Color(1, 89, 255));
        jButton_GenrarTicket.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_GenrarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenrarTicketActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GenrarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 445, 60, 50));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        int validacion = 0;
        String tipo_equipo, marca, modelo, num_serie, estatus, observaciones;

        tipo_equipo = cmb_TipoEquipo.getSelectedItem().toString();
        estatus = cmb_Estatus.getSelectedItem().toString();
        marca = txt_Marca.getText().trim();
        modelo = txt_Modelo.getText().trim();
        num_serie = txt_NumeroSerie.getText().trim();
        observaciones = jTextPane_Observaciones.getText();

        if (modelo.equals("")) {
            txt_Modelo.setBackground(Color.red);
            validacion++;
        }
        if (num_serie.equals("")) {
            txt_NumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            jTextPane_Observaciones.setText("Sin observaciones");
        }

        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update equipos set tipo_equipo=?, marca=?, modelo=?, num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? "
                        + "where id_equipo = '" + IDequipo + "'");

                pst.setString(1, tipo_equipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);
                pst.setString(4, num_serie);
                pst.setString(5, observaciones);
                pst.setString(6, estatus);
                pst.setString(7, user);

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txt_NombreCliente.setBackground(Color.GREEN);
                txt_Modelo.setBackground(Color.GREEN);
                txt_Fecha.setBackground(Color.GREEN);
                txt_NumeroSerie.setBackground(Color.GREEN);
                txt_ModificacionPor.setText(user);

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en actualizar equipo " + e);
                JOptionPane.showMessageDialog(null, "!Error al actualizar equipo¡ Contacte al Administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_GenrarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GenrarTicketActionPerformed
        String folio = "", nombreCliente = "", vendedor = "", observaciones = "", numeroSerie = "", tipoEquipo = "", marca = "", modelo = "", fechaHora = "";
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select num_serie, marca, modelo, observaciones, dia_ingreso, mes_ingreso, annio_ingreso, tipo_equipo, hora_ingreso from equipos "
                    + "where id_equipo = '" + IDequipo + "' and id_cliente = '" + IDclienteUpdate + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                folio = String.valueOf(IDequipo);
                observaciones = rs.getString("observaciones");
                numeroSerie = rs.getString("num_serie");
                tipoEquipo = rs.getString("tipo_equipo");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                fechaHora = rs.getString("dia_ingreso") + "/" + rs.getString("mes_ingreso") + "/" + rs.getString("annio_ingreso") + " " + rs.getString("hora_ingreso");
                
                nombreCliente = nom_cliente;
                vendedor = nombre_usuario;
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar equipo del cliente " + e.getMessage());
        }
        
        ordenServicio.setFolio(folio);
        ordenServicio.setFechaHora(fechaHora);
        ordenServicio.setNombreCliente(nombreCliente);
        ordenServicio.setNumeroSerie(numeroSerie);
        ordenServicio.setTipoEquipo(tipoEquipo);
        ordenServicio.setMarca(marca);
        ordenServicio.setModelo(modelo);
        ordenServicio.setObservaciones(observaciones);
        ordenServicio.setVendedor(vendedor);
        
        try {
            ordenServicio.LlenarOrden();
        } catch (JRException ex) {
             System.err.println("Error al llenar la informacion del ticket " + ex);
        }
    }//GEN-LAST:event_jButton_GenrarTicketActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JComboBox<String> cmb_TipoEquipo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_GenrarTicket;
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
    private javax.swing.JTextPane jTextPane_ComentariosTecnico;
    private javax.swing.JTextPane jTextPane_Observaciones;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_ModificacionPor;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_NombreCliente.setText("");
        txt_Fecha.setText("");
        txt_Modelo.setText("");
        txt_ModificacionPor.setText("");
        txt_NumeroSerie.setText("");

    }
}
