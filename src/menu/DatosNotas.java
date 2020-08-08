package menu;

import javax.swing.JPanel;
import componentes.BotonSeleccionable;
import java.awt.LayoutManager;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class DatosNotas extends JPanel {

    private static final long serialVersionUID = -314411242669316561L;
    private final CuadroTarjetas tarjetas;
    private final CuadroHistorias muestraD;
    BotonSeleccionable datos,notas;

    public DatosNotas() {
        JPanel botones = new JPanel();
        botones.setLayout(new LayoutBotones());
        datos = new BotonSeleccionable("Datos") {
            private static final long serialVersionUID = 1L;

            @Override
            protected void accion() {
                super.accion();

                if (isSelected()) {
                    setComponente("Datos");
                }
            }
        };
        notas = new BotonSeleccionable("Notas") {
            private static final long serialVersionUID = 1L;

            @Override
            protected void accion() {
                super.accion();

                if (isSelected()) {
                    setComponente("Notas");
                }
            }
        };
        botones.add(datos);
        botones.add(notas);
        setOpaque(false);

        setLayout(new LayoutManager() {
            @Override
            public void addLayoutComponent(String name, Component comp) {
            }
            @Override
            public void removeLayoutComponent(Component comp) {
            }
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
                parent.getComponent(0).setBounds(0, 0, parent.getWidth(), 30);
                parent.getComponent(1).setBounds(0, 30, parent.getWidth(), parent.getHeight()-30);

            }            
        });

        tarjetas = new CuadroTarjetas(HistoriaPreview.dataActual.getNotas());
        muestraD = new CuadroHistorias(HistoriaPreview.dataActual);
        tarjetas.setOpaque(false);
        muestraD.setOpaque(false);

        this.add(botones);
        this.add(tarjetas);
        notas.setSelected(true);
    }

    private void setComponente(String boton){
        if(boton=="Notas" && datos.isSelected()){
            datos.setSelected(false);
            datos.repaint();
            this.remove(muestraD);
            this.add(tarjetas);
        }else if(boton=="Datos" && notas.isSelected()){
            notas.setSelected(false);
            notas.repaint();
            this.remove(this.getComponentCount()-1);
            this.add(muestraD);
        }
        updateUI();
    }
    
}