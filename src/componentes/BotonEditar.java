package componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import menu.IEditable;

public class BotonEditar extends BotonIcono{

    private static final long serialVersionUID = 1L;
    private final IEditable padre;

    public BotonEditar(IEditable parent){
        super();
        padre=parent;
    }

    @Override
    protected void accion() {
        padre.editar();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        int width = this.getWidth()/4;
        int height = this.getHeight()/4;

        RoundRectangle2D borra = new RoundRectangle2D.Double((this.getWidth()/2)-(width/2),
        height/2, width, height, width/5, height/5);
        g2.fill(borra);
        Rectangle2D cuerpo = new Rectangle2D.Double((this.getWidth()/2)-(width/2),
        height, width, height*2);
        g2.fill(cuerpo);
        Path2D punta = new Path2D.Double();
        punta.moveTo((this.getWidth()/2)-(width/2), (height*3)+2);
        punta.lineTo((this.getWidth()/2)+(width/2), (height*3)+2);
        punta.lineTo(this.getWidth()/2, this.getHeight()*9/10);
        g2.fill(punta);

    }
    
}