package clases;


import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class TicketRecepcion {

    private String empresa;
    private String propietario;
    private String rfc;
    private String direccion;
    private String telefono;
    private String folio;
    private String nombreCliente;
    private String contactoCliente;
    private String observaciones;
    private String condiciones;
    private String numeroSerie;
    private String tipoEquipo;
    private String marca;
    private String modelo;
    private String vendedor;
    private String fechaHora;

    public TicketRecepcion() {
    }

    public void setEmpresa() {
        this.empresa = "SANKARASEL REFACIONES";
    }

    public void setPropietario() {
        this.propietario = "SERGIO ALEJANDRO CHAVIRA MORENO";
    }

    public void setRfc() {
        this.rfc = "CAMS9711039P7";
    }

    public void setDireccion() {
        this.direccion = "AV. TECNOLOGICO No. 11308-B\n"
                       + "COL. REVOLUCION C.P. 31135\n"
                       + "CHIHUAHUA, CHIHUAHUA, MEXICO";
    }

    public void setTelefono() {
        this.telefono = "6146191507";
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public void setContactoCliente(String contactoCliente){
        this.contactoCliente = contactoCliente;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setObservaciones(String observaciones) {
        int count = 0;
        int nLineas = observaciones.length();

        for (int i = 0; i < nLineas; i++) {
            char caracter = observaciones.charAt(i);
            if (caracter == '\n') {
                count++;
            }
        }
        if (count != 6) {
            int tLineas = 6 - count;
            for (int i = 0; i < tLineas; i++) {
                observaciones = observaciones + "\n";
            }
            this.observaciones = observaciones;
        } else {
            this.observaciones = observaciones;
        }
    }

    public void setCondiciones() {
        this.condiciones = "* TODA REVISIÓN CAUSA HONORARIOS.\n"
                         + "* NO NOS HACEMOS RESPONSABLES EN CASO\n"
                         + "  DE ROBO O INCENDIO NI DE EQUIPOS\n"
                         + "  MOJADOS.\n"
                         + "* DESPUES DE 10 DIAS NO NOS HACEMOS\n"
                         + "  RESPONSABLES DE SU EQUIPO.\n"
                         + "* TODA REPARACIÓN CON COSTO MENOR A\n"
                         + "  $500.00 PESOS SE REALIZARA SIN PREVIO\n"
                         + "  AVISO Y/O AUTORIZACIÓN.\n"
                         + "* NO NOS HACEMOS RESPONSABLES POR\n"
                         + "  CHIPS, MEMORIAS Y/O ACCESORIOS PROPIOS\n"
                         + "  DEL EQUIPO.\n"
                         + "* EN EQUIPOS MOJADOS NO HAY NINGUN TIPO\n"
                         + "  DE GARANTIA.\n";
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    public void LlenarOrden() throws JRException{
        setEmpresa();
        setPropietario();
        setRfc();
        setDireccion();
        setTelefono();
        setCondiciones();
        
        String master = System.getProperty("user.dir") + "/reports/OrdenServicio.jasper";
        HashMap parametros = new HashMap();
        
        /*
         * Cabecera "Datos generales del negocio"
         */
        parametros.put("empresa", empresa);
        parametros.put("propietario", propietario);
        parametros.put("rfc", rfc);
        parametros.put("direccion", direccion);
        parametros.put("telefono", telefono);
        
        /*
         * Datos generales de la orden
         */
        parametros.put("folio", folio);
        parametros.put("fechaHora", fechaHora);
        parametros.put("nombreCliente", nombreCliente);
        parametros.put("contactoCliente", contactoCliente);
        
        /*
         * Datos especificos del equipo
         */
        parametros.put("numeroSerie", numeroSerie);
        parametros.put("tipoEquipo", tipoEquipo);
        parametros.put("marca", marca);
        parametros.put("modelo", modelo);
        parametros.put("observaciones", observaciones);
        
        // Condiciones de servicio
        parametros.put("condiciones", condiciones);
        
        parametros.put("vendedor", vendedor);
        parametros.put("conformidad", nombreCliente);
        
        
        JasperPrint jp = JasperFillManager.fillReport(master, parametros, new JREmptyDataSource());
        JasperViewer.viewReport(jp, false);
    }
}
