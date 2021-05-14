package clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Crear {

    /*
     * Constructores especializado en colocar fondos en JLabel y JButton al iniciar programa.
     */
    public Crear(JLabel Wallpaper) {
        ImageIcon fondoUsuarios = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon ico = new ImageIcon(fondoUsuarios.getImage().getScaledInstance(Wallpaper.getWidth(), Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        Wallpaper.setIcon(ico);
    }

    public Crear(JButton boton, String ruta) {
        ImageIcon ImageBoton = new ImageIcon(ruta);
        Icon iconoBoton = new ImageIcon(ImageBoton.getImage());
        boton.setIcon(iconoBoton);
    }
    
    
}
