package componentes;

import datos.Data;
import menu.Contenido;
import menu.HistoriaPreview;
import recursos.FileControl;

public class TarjetaHistoria extends TarjetaIcono {

    private static final long serialVersionUID = 5646632522245158272L;

    public TarjetaHistoria(String titulo) {
        super(titulo.substring(0,titulo.length()-4),"Recursos/Libro.png");
    }

    @Override
    protected void accion() {
        FileControl.hijo(getTitulo() + ".pln");
        Data historia = (Data) FileControl.cargarObjeto();
        if(historia!=null)
        Contenido.contenido.setContenido(historia.getNombre(), new HistoriaPreview(historia));
        else System.out.println("No se ha encontrado el archivo");
    }
    
}