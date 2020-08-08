package menu;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import ResourcesControl.FileControl;
import componentes.BotonAniadir;
import componentes.BotonGuardar;
import componentes.Tarjeta;
import datos.Nota;

public class CuadroTarjetas extends JPanel implements IMostrador, IGuardable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();

    public CuadroTarjetas() {
        CardsLayout layout = new CardsLayout();
        addMouseWheelListener(new MouseWheelListener() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                layout.setScrollY(e.getWheelRotation());
                updateUI();

            }
            
        });
        this.setLayout(layout);

        BotonGuardar BGuardar = new BotonGuardar(this);
        this.add(BGuardar);
        this.add(new BotonAniadir(this));
        layout.removeLayoutComponent(BGuardar);

        LaminaMenu.ultimo = this;
    }

    public CuadroTarjetas(Nota[] notas){
        this();
        for (Nota nota : notas) {
            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setTitulo(nota.getTitulo());
            tarjeta.setContenido(nota.getDescripcion());
            tarjeta.setEnabled(false);
            this.add(tarjeta,this.getComponentCount()-1);
            tarjetas.add(tarjeta);
        }        
    }

    public void aniadirItem() {
        Tarjeta card = new Tarjeta();
        this.add(card,this.getComponentCount()-1);
        tarjetas.add(card);
        updateUI();
    }

    @Override
    public void guardar() {
        int i = 0;
        for(Tarjeta esta : tarjetas){
            if(esta.isEnabled() && esta.haEscrito()){
                HistoriaPreview.dataActual.replaceNota(new Nota(esta.getTitulo(),esta.getContenido()),i);
                if(i<tarjetas.indexOf(esta)){
                    tarjetas.get(i).setTitulo(esta.getTitulo());
                    tarjetas.get(i).setContenido(esta.getContenido());
                    tarjetas.get(i).setEnabled(false);
                    esta.borrarTexto();
                }else{                    
                    esta.setEnabled(false);
                }
            } else if(!esta.haEscrito()){
                if(i<HistoriaPreview.dataActual.notas.size()){
                    HistoriaPreview.dataActual.notas.remove(i);
                }
                i--;
            }
            i++;
        }
        FileControl.guardarObjeto(HistoriaPreview.historiaActual);
    }
    
}