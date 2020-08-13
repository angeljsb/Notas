package menu;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JPanel;
import recursos.FileControl;
import componentes.BotonAniadir;
import componentes.TarjetaData;
import componentes.TarjetaHistoria;
import datos.Data;

public class CuadroHistorias extends JPanel implements IMostrador {

    private static final long serialVersionUID = 1L;
    private final boolean archivo;

    public CuadroHistorias(){
        CardsLayout layout = new CardsLayout();
        addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                layout.setScrollY(e.getWheelRotation());
                updateUI();
            }
            
        });
        this.setLayout(layout);

        for (String nombre : FileControl.lista()) {
            this.add(new TarjetaHistoria(nombre));
        }
        archivo=true;

        add(new BotonAniadir(this));
    }

    public CuadroHistorias(Data datos){
        CardsLayout layout = new CardsLayout();
        addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                layout.setScrollY(e.getWheelRotation());
                updateUI();
            }
            
        });
        this.setLayout(layout);

        for (Data dato : datos.getDatos()) {
            this.add(new TarjetaData(dato));
        }
        archivo=false;

        add(new BotonAniadir(this));
    }

    @Override
    public void aniadirItem() {
        if(archivo)
        Contenido.contenido.setContenido("Nuevo Tema", new AgregarHistoria());
        else
        Contenido.contenido.setContenido("Nuevo Tema", new AgregarData());
    }
    
}