package componentes;

import menu.IGuardable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class BotonGuardar extends BotonIcono {

    private static final long serialVersionUID = 1L;
    private IGuardable padre;

    public BotonGuardar(IGuardable parent) {
        super();
        padre=parent;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        Path2D triangulo = new Path2D.Float();
        float ancho = (float)this.getWidth();
        float alto = (float)this.getHeight();
        triangulo.moveTo(ancho/5,alto/2);
        triangulo.lineTo(ancho*4/5, alto/2);
        triangulo.lineTo(ancho/2, alto*4/5);
        g2.fill(triangulo);
        g2.fill(new Rectangle2D.Float(ancho/3, alto/5, ancho/3, (alto/2)-(alto/5)));
    }

    @Override
    protected void accion() {
        padre.guardar();
    }
    
}