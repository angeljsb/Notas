package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public class BotonSeleccionable extends BotonPanel{

    private static final long serialVersionUID = 1L;
    private final String texto;
    private boolean selected = false;

    public BotonSeleccionable(String texto) {
        super(Color.WHITE, new Color(200,200,200), Color.GRAY);
        this.setSize(50,20);
        this.texto = texto;
    }

    @Override
    protected void accion(){
        selected = true;
    }

    public void setSelected(boolean valor){
        selected = valor;
    }

    public boolean isSelected(){
        return selected;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        Color color = selected ? Color.BLUE : getActual();

        RoundRectangle2D espacio = new RoundRectangle2D.Float(0, 0, 
        this.getWidth()-1, this.getHeight()-1,20,20);
        g2.setColor(color);
        g2.fill(espacio);
        g2.setColor(Color.BLACK);
        g2.draw(espacio);

        if(selected)
        g2.setColor(Color.WHITE);

        g2.drawChars(texto.toCharArray(), 0, texto.length(), 
        ((int)espacio.getCenterX())-((texto.length()/2)*8), 15);
    }
    
}