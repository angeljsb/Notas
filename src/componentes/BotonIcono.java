package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public abstract class BotonIcono extends BotonPanel {
    
    private static final long serialVersionUID = 1L;

    public BotonIcono(){
        super(Color.BLUE,new Color(0,0,200),new Color(0,0,150));
    }

    public void paint(Graphics g){

        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getActual());
        g2.fill(new Ellipse2D.Float(0,0,this.getWidth(),this.getHeight()));
    }

}