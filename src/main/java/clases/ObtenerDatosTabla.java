package clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanas.InformacionCliente;
import ventanas.InformacionEquipoTecnico;
import ventanas.InformacionUsuario;
import ventanas.InformacionVenta;
import ventanas.Producto;
import ventanas.Servicio;

public class ObtenerDatosTabla {

    public static String userUpdate;
    public static int IDclienteUpdate, IDequipoUpdate, IDproducto, IDservicio, IDventa;

    public void ObtenerDatosTablaUsuarios(DefaultTableModel tablaUsuarios, JTable jTable_Usuarios) {
        jTable_Usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Usuarios.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (fila_point > -1) {
                    userUpdate = (String) tablaUsuarios.getValueAt(fila_point, columna_point);
                    InformacionUsuario informacionUsuario = new InformacionUsuario();
                    informacionUsuario.setVisible(true);

                }

            }

        });

    }

    public void ObtenerDatosTablaClientes(DefaultTableModel tablaClientes, JTable jTable_Clientes) {
        jTable_Clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDclienteUpdate = (int) tablaClientes.getValueAt(fila_point, columna_point);
                    InformacionCliente informacionCliente = new InformacionCliente();
                    informacionCliente.setVisible(true);
                }

            }

        });
    }

    public void ObtenerDatosTablaEquipos(DefaultTableModel tablaEquipos, JTable jTable_Equipos) {
        jTable_Equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipoUpdate = (int) tablaEquipos.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico informacionEquipoTecnico = new InformacionEquipoTecnico();
                    informacionEquipoTecnico.setVisible(true);
                }

            }

        });
    }

    public void ObtenerDatosTablaProductos(DefaultTableModel tablaProductos, JTable jTable_Productos) {
        jTable_Productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDproducto = (int) tablaProductos.getValueAt(fila_point, columna_point);
                    Producto producto = new Producto();
                    producto.setVisible(true);
                }
            }
        });
    }

    public void ObtenerDatosTablaServicios(DefaultTableModel tablaServicios, JTable jTable_Servicios) {
        jTable_Servicios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Servicios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDservicio = (int) tablaServicios.getValueAt(fila_point, columna_point);
                    Servicio servicio = new Servicio();
                    servicio.setVisible(true);
                }

            }

        });
    }

    public void ObtenerDatosTablaVentas(DefaultTableModel tablaVentas, JTable jTable_Ventas) {
        jTable_Ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDventa = (int) tablaVentas.getValueAt(fila_point, columna_point);
                    InformacionVenta informacionVenta = new InformacionVenta();
                    informacionVenta.setVisible(true);
                }

            }

        });
    }

}
