package ResourcesControl;

import java.io.File;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class FileControl {

    private static File actual = new File("Historias");

    public static String[] lista() {
        if (!actual.exists()) {
            actual.mkdir();
        }
        return actual.list();
    }

    public static void setActual(String ruta) {
        actual = new File(ruta);
    }

    public static void hijo(String nombreHijo) {
        actual = new File(actual, nombreHijo);
    }

    public static void guardarObjeto(Serializable objeto) {
        try {
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(actual));
            guardar.writeObject(objeto);
            guardar.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return;
    }

    public static Object cargarObjeto() {
        Object cargado;
        try {
            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream(actual));
            try {
                cargado = cargar.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                cargado = null;
            }
            cargar.close();
        } catch (IOException e) {
            System.out.println(e);
            cargado = null;
        }
        return cargado;
    }
    
}