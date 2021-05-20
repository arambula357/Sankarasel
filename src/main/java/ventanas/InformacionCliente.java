package ventanas;

import java.sql.*;
import clases.Conexion;
import clases.Crear;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Importamos las bibliotecas que permiten impriir PDF desde nuestro programa Inicio-
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
// Importamos las bibliotecas que permiten impriir PDF desde nuestro programa -Fin.

public class InformacionCliente extends javax.swing.JFrame {

    int IDcliente_Update;
    public static int IDequipo;
    String user, nombre_cliente;

    DefaultTableModel tablaInfoCliente;

    public InformacionCliente() {
        initComponents();
        user = Login.user;
        IDcliente_Update = Crear.IDclienteUpdate;

        setSize(650, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Insertamos imagen de fondo.
        Crear wallpaper = new Crear(jLabel_Wallpaper);

        // Insertamos icono al botón.
        Crear botonImprimir = new Crear(jButton_ImprimirReporte, "images/impresora.png", "No");

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = '" + IDcliente_Update + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setTitle("Información del cliente " + rs.getString("nombre_cliente") + " - Sesión de " + user);
                jLabel_Titulo.setText("Información del cliente " + rs.getString("nombre_cliente"));

                txt_Nombre.setText(rs.getString("nombre_cliente"));
                txt_Telefono.setText(rs.getString("tel_cliente"));
                txt_ModificadoPor.setText(rs.getString("ultima_modificacion"));
                nombre_cliente = rs.getString("nombre_cliente");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar usuario " + e);
            JOptionPane.showMessageDialog(null, "¡Error al cargar! Contacte al Administrador.");
        }
        CrearTablaInfoCliente();
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

        jScrollPane_Equipos = new javax.swing.JScrollPane();
        jTable_Equipos = new javax.swing.JTable();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Telefono = new javax.swing.JLabel();
        jLabel_ModificadoPor = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_ModificadoPor = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane_Equipos.setViewportView(jTable_Equipos);
        tablaInfoCliente = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getContentPane().add(jScrollPane_Equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del cliente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Telefono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Teléfono:");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel_ModificadoPor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_ModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificadoPor.setText("Modificado por:");
        getContentPane().add(jLabel_ModificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_Telefono.setBackground(new java.awt.Color(3, 37, 251));
        txt_Telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, -1));

        txt_ModificadoPor.setBackground(new java.awt.Color(3, 37, 251));
        txt_ModificadoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModificadoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ModificadoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ModificadoPor.setEnabled(false);
        getContentPane().add(txt_ModificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(3, 37, 251));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar cliente");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 255, 210, 35));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(3, 37, 251));
        jButton_ImprimirReporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 255, 120, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Programación de botón "Actualizar cliente".
    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        int validacion = 0;
        String nombre, telefono;

        nombre = txt_Nombre.getText().trim();

        telefono = txt_Telefono.getText().trim();

        if (nombre.equals("")) {
            txt_Nombre.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txt_Telefono.setBackground(Color.red);
            validacion++;
        }
        if (validacion == 0) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update clientes set nombre_cliente=?, tel_cliente=?, ultima_modificacion=? "
                        + "where id_cliente = '" + IDcliente_Update + "'");

                pst.setString(1, nombre);
                pst.setString(2, telefono);
                pst.setString(3, user);

                pst.executeUpdate();
                cn.close();

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error en actualizar cliente " + e);
                JOptionPane.showMessageDialog(null, "¡Error al actualizar cliente! Contacte al Administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    // Programación del botón "Imprimir".
    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed

        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + nombre_cliente + ".pdf"));

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
                PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = '" + IDcliente_Update + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tablaCliente.addCell(rs.getString("id_cliente"));
                        tablaCliente.addCell(rs.getString("nombre_cliente"));
                        tablaCliente.addCell(rs.getString("tel_cliente"));
                    } while (rs.next());

                    documento.add(tablaCliente);
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n\nEquipos registrados\n\n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tablaEquipos = new PdfPTable(6);
                tablaEquipos.addCell("ID");
                tablaEquipos.addCell("Tipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Modelo");
                tablaEquipos.addCell("No. Serie");
                tablaEquipos.addCell("Estatus");

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("select id_equipo, tipo_equipo, marca, modelo, num_serie, estatus from equipos where id_cliente = '" + IDcliente_Update + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        do {
                            tablaEquipos.addCell(rs2.getString("id_equipo"));
                            tablaEquipos.addCell(rs2.getString("tipo_equipo"));
                            tablaEquipos.addCell(rs2.getString("marca"));
                            tablaEquipos.addCell(rs2.getString("modelo"));
                            tablaEquipos.addCell(rs2.getString("num_serie"));
                            tablaEquipos.addCell(rs2.getString("estatus"));                            
                        } while (rs2.next());
                        documento.add(tablaEquipos);
                    }
                    cn2.close();
                } catch (SQLException e) {
                    System.err.println("Error al obtener los equipos del cliente " + e);
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error al obtener los datos del cliente para el documento " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
        }
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JLabel jLabel_ModificadoPor;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane_Equipos;
    private javax.swing.JTable jTable_Equipos;
    private javax.swing.JTextField txt_ModificadoPor;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    private void CrearTablaInfoCliente(){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_Update + "'");

            ResultSet rs = pst.executeQuery();

            jTable_Equipos = new JTable(tablaInfoCliente);
            jScrollPane_Equipos.setViewportView(jTable_Equipos);

            tablaInfoCliente.addColumn("ID equipo");
            tablaInfoCliente.addColumn("Tipo de equipo");
            tablaInfoCliente.addColumn("Marca");
            tablaInfoCliente.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tablaInfoCliente.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en el llenado equipos " + e);
        }
        ObtenerDatosTablaInfoCliente();
    }
    
    private void ObtenerDatosTablaInfoCliente(){
        jTable_Equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo = (int) tablaInfoCliente.getValueAt(fila_point, columna_point);
                    InformacionEquipo informacionEquipo = new InformacionEquipo();
                    informacionEquipo.setVisible(true);

                }

            }

        });
    }
}
