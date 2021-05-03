package clases;

import java.io.IOException;
import java.util.Calendar;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class TicketCorte {

    //Atributos que almacenan los datos de la empresa y de la compra
    private String empresa = "SANKARASEL REFACIONES";
    private String propietario = "SERGIO ALEJANDRO CHAVIRA MORENO";
    private String rfc = "CAMS9711039P7";
    private String direccion = "    AV TECNOLOGICO No 11308-B\n"
                    + "      COL. REVOLUCION CP 31135\n"
                    + "     CHIHUAHUA,CHIHUAHUA, MEXICO";
    private String telefono = "6146191507";
    private String articulos;
    private String total;
    private String fecha;

    /**
     * Atributo que almacena la estructura del contenido del ticket Los campos
     * que tengan la siguiente estructura {{nombreAtributo}}, ejemplo:
     * {{telefono}} serán reemplazados por los datos correspondientes.
     */
    private String formatoTicket
            = "\n" + (char) 27 + (char) 112 + (char) 0 + (char) 10 + (char) 100 + "      {{empresa}}\n"
            + " {{propietario}}\n"
            + "     R.F.C. {{rfc}}\n"
            + "{{direccion}}\n"
            + "     TElS: {{telefono}}\n"
            + "\n"
            + "FECHA: {{fecha}}\n"
            + "\n"
            + "CANT.   DESCIP.     TOTAL U.  \n"
            + "================================\n"
            + "{{articulos}}\n"
            + "================================\n"
            + "TOTAL:   $ {{total}}\n"
            + "\n"
            + "\n\n";

    /**
     * @param articulos datos del producto vendido
     */
    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    /**
     * @param total total de la compra
     */
    public void setTotal(String total) {
        this.total = total;
    }

    public void setFecha() {
        String dia, mes, annio;

        Calendar calendario = Calendar.getInstance();
        dia = Integer.toString(calendario.get(Calendar.DATE));
        mes = Integer.toString(calendario.get(Calendar.MONTH));
        annio = Integer.toString(calendario.get(Calendar.YEAR));

        fecha = dia + "/" + mes + "/" + annio;
        
        
    }

    /**
     * PARA ESTE EJEMPLO USAMOS UNA IMPRESORA TERMICA CON EL NOMBRE DE SUBARASI
     * EL CUAL LE ASIGNAMOS DESDE LA VENTANA DE IMPRESORA Y DISPOSITIVOS
     * (WINDOWS) Configuración del documento de impresión y reemplazo de los
     * campos con el valor de las propiedades
     *
     * @param flagServicio Controla el metodo de impresión
     * @throws java.io.IOException
     */
    public void print(boolean flagServicio) throws IOException {
        //Datos de impresion.
        //Datos de la Empresa y/o negocio
        this.formatoTicket = formatoTicket.replace("{{empresa}}", empresa);
        this.formatoTicket = formatoTicket.replace("{{propietario}}", propietario);
        this.formatoTicket = formatoTicket.replace("{{rfc}}", rfc);
        this.formatoTicket = formatoTicket.replace("{{direccion}}", direccion);
        this.formatoTicket = formatoTicket.replace("{{telefono}}", telefono);
        this.formatoTicket = formatoTicket.replace("{{fecha}}", fecha);
        this.formatoTicket = formatoTicket.replace("{{articulos}}", articulos);
        this.formatoTicket = formatoTicket.replace("{{total}}", total);

        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes -- Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        //Creamos un arreglo de tipo byte y le agregamos el string convertido (cuerpo del ticket)
        //a bytes tal como lo maneja la impresora.
        byte[] bytes = this.formatoTicket.getBytes();
        //Creamos un documento a imprimir pasandole el arreglo de byte
        Doc doc = new SimpleDoc(bytes, flavor, null);

        //Creamos un trabajo de impresión
        DocPrintJob job = null;
        //Creamos una bandera para determinar si se encontro la impresora
        //que especificamos en este caso "subarasi" O si usamos la impresora predeterminada del S.O.
        boolean flagJob = false;

        //Opcion 1 ->nos da el array de los servicios de impresion
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        //Opcion 2-> servicios de impresion por default
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //Opcion 3-> mostramos dialogo para seleccionar impresoras que soporten arreglos de bits
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

        if (flagServicio == true) {
            if (services.length > 0) {//usamos la opcion 1 y comprobamos si hay impresoras disponibles
                //Recorremos el arreglo de impresoras
                for (PrintService service1 : services) {
                    //Aqui definimos el nombre de la impresora (para este ejemplo: subarasi)
                    // y comparamos si esta dentro del arreglo de impresoras
                    if (service1.getName().equals("58 Printer")) {
                        job = service1.createPrintJob(); // creamos el trabajo de impresion
                        flagJob = true; //si la impresora existe ponemos en TRUE la bandera
                    }
                }
            }
            //En caso de que la opcion 1 no encuentre la impresora que buscamos
            // el flagJob es false y job es null, entonces empleamos la opcion 2
            if (job == null && flagJob == false) {
                //creamos el trabajo de impresion con el servicio de impresion por default
                //(la impresora establecida como predeterminada en el sistema operativo)
                job = defaultService.createPrintJob();
            }
            flagJob = false;
        } else {
            //si flagServicio es false, usamos la opcion 3 para crear el trabajo de impresion
            //seleccionando la impresora desde el cuadro de dialogo de impresion
            PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
            job = service.createPrintJob();
        }

        //por ultimo Imprimimos dentro de un try obligatoriamente para el contro de excepciones
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(null, "IMPRIMIR TICKET (Compruebe impresion) " + ex.getMessage());
        }
    }
}
