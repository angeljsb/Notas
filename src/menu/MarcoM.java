package menu;

import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import recursos.ImagesControl;

public class MarcoM extends JFrame {

    private static final long serialVersionUID = 1L;

    public static final MarcoM marco = new MarcoM();

    private MarcoM() {
        Toolkit pantalla;
        
        Image miIcono;
        miIcono = ImagesControl.crearImagen("Recursos/Libro.png").getImage();
		setIconImage(miIcono);

        pantalla = Toolkit.getDefaultToolkit();
		int ancho = pantalla.getScreenSize().width;
		int alto = pantalla.getScreenSize().height;
		setSize(400, 400);
        setLocation((ancho/2)-(400/2),(alto/2)-(400/2));	

		setTitle("Organizador");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        setVisible(true);
    }
    
}