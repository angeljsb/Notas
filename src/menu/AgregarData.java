package menu;

import ResourcesControl.FileControl;
import datos.Data;

public class AgregarData extends AgregarHistoria{

    private static final long serialVersionUID = 1L;

    @Override
    public void guardar() {
        Data esta = new Data(getTitulo(),getDescripcion());
        HistoriaPreview.dataActual.datos.add(esta);
        HistoriaPreview.dataActual = HistoriaPreview.dataActual.datos
        .get(HistoriaPreview.dataActual.datos.indexOf(esta));
        FileControl.guardarObjeto(HistoriaPreview.historiaActual);
        Contenido.contenido.setContenido(getTitulo(), new DataPreview(HistoriaPreview.dataActual));
    }
    
}