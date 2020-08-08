package componentes;

import datos.Data;
import menu.Contenido;
import menu.HistoriaPreview;
import menu.DataPreview;

public class TarjetaData extends TarjetaIcono {

    private static final long serialVersionUID = 1L;
    private final Data datos;

    public TarjetaData(Data datos) {
        super(datos.getNombre(), "Recursos/Nota.png");
        this.datos = datos;
    }

    @Override
    protected void accion() {
        HistoriaPreview.dataActual = HistoriaPreview.dataActual.datos
        .get(HistoriaPreview.dataActual.datos.indexOf(datos));
        Contenido.contenido.setContenido(getTitulo(), new DataPreview(HistoriaPreview.dataActual));
    }
    
}