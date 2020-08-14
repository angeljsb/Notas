package componentes;

import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import menu.IMostrador;

public class BotonAniadir extends BotonIcono {

    private static final long serialVersionUID = 1L;
    private final IMostrador padre;

    public BotonAniadir(IMostrador parent) {
        super();
        padre=parent;
    }

    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        int angosto = this.getWidth()/5;
        int largo = (this.getWidth()/5)*4;        
        g2.fill(new Rectangle2D.Float((this.getWidth()/2)-(angosto/2),
            (this.getWidth()/2)-(largo/2), angosto, largo));
            angosto = this.getHeight()/5;
            largo = (this.getHeight()/5)*4; 
        g2.fill(new Rectangle2D.Float((this.getWidth()/2)-(largo/2),
            (this.getWidth()/2)-(angosto/2), largo, angosto));
    }

    protected void accion(){
        padre.aniadirItem();
    }
}