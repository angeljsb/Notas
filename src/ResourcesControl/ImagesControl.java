package ResourcesControl;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImagesControl extends ImageIcon {

    private static final long serialVersionUID = 1L;

    private static ArrayList<ImagesControl> imagenes = new ArrayList<ImagesControl>();
    private static ArrayList<String> rutas = new ArrayList<String>();

    private ImagesControl(String ruta) {
        super();
        try {
            Image miIcono;
            miIcono = ImageIO.read(new File(ruta));
            setImage(miIcono);
            imagenes.add(this);
            rutas.add(ruta);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ImagesControl crearImagen(String ruta){
        ImagesControl imagen;
        if(rutas.contains(ruta)){
            imagen = imagenes.get(rutas.indexOf(ruta));
        }else{
            imagen = new ImagesControl(ruta);
        }
        return imagen;
    }
    
}