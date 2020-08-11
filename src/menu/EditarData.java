package menu;

import ResourcesControl.FileControl;

public class EditarData extends AgregarHistoria {

    private static final long serialVersionUID = 1L;

    public EditarData(){
        super();
        setTitulo(HistoriaPreview.dataActual.getNombre());
        setDescripcion(HistoriaPreview.dataActual.getDescripcion());
    }

    @Override
    public void guardar() {
        HistoriaPreview.dataActual.setNombre(this.getTitulo());
        HistoriaPreview.dataActual.setDescripcion(this.getDescripcion());
        FileControl.guardarObjeto(HistoriaPreview.historiaActual);
        Contenido.contenido.setContenido(getTitulo(), new DataPreview(HistoriaPreview.dataActual));
    }
    
}