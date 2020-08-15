package menu;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import componentes.BotonSeleccionable;
import datos.Data;
import recursos.FileControl;

import java.awt.BorderLayout;

public class BorrarData extends JPanel {

    private static final long serialVersionUID = 1L;

    public BorrarData() {
        setLayout(new LayoutManager() {

            @Override
            public void addLayoutComponent(String name, Component comp) {}
            @Override
            public void removeLayoutComponent(Component comp) {}
            @Override
            public Dimension preferredLayoutSize(Container parent) {
                return null;
            }
            @Override
            public Dimension minimumLayoutSize(Container parent) {
                return null;
            }
            @Override
            public void layoutContainer(Container parent) {
                parent.getComponent(0).setBounds((parent.getWidth()/2)-150,
                (parent.getHeight()/2)-100, 300, 100);
            }

        });

        JPanel dialog = new JPanel();
        dialog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        dialog.setLayout(new BorderLayout());

        JPanel panelText = new JPanel();

        JLabel label = new JLabel("\u00bfDesea borrar el tema " + 
            HistoriaPreview.dataActual.getNombre() + "?");
        panelText.add(label);
        dialog.add(panelText, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new LayoutBotones());

        BotonSeleccionable aceptar = new BotonSeleccionable("S\u00ed"){
            private static final long serialVersionUID = 1L;
            @Override
            protected void accion() {                
                borrar();
            }
        };
        BotonSeleccionable negar = new BotonSeleccionable("No"){
            private static final long serialVersionUID = 1L;
            @Override
            protected void accion() {
                LaminaMenu.volver();
            }
        };
        panelBotones.add(negar);
        panelBotones.add(aceptar);
        dialog.add(panelBotones, BorderLayout.CENTER);

        add(dialog);
    }

    private void borrar(){
        if(HistoriaPreview.dataActual == HistoriaPreview.historiaActual){
            FileControl.borrar();
            LaminaMenu.volverInicio();
        }else{
            remover(HistoriaPreview.historiaActual,HistoriaPreview.dataActual);
            FileControl.guardarObjeto(HistoriaPreview.historiaActual);
            LaminaMenu.volver();
        }
    }

    private void remover(Data padre, Data nieto){
        System.out.println("Entro a remover");
        if(padre.datos.size()==0) return;
        if(!padre.datos.remove(nieto)){
            for (Data dato : padre.datos) {
                remover(dato,nieto);
            }
        }
    }
    
}