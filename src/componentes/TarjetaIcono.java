package componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import recursos.ImagesControl;
import java.awt.geom.RoundRectangle2D;

public abstract class TarjetaIcono extends BotonPanel {

    private static final long serialVersionUID = 1L;
    private final ImagesControl icono;
    private final String titulo;

    public TarjetaIcono(String titulo,String imagen){
        super(Color.WHITE, new Color(200,200,200), Color.GRAY);
        icono = ImagesControl.crearImagen(imagen);
        this.titulo = titulo;
    }

    protected String getTitulo() {
        return titulo;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int ancho = this.getWidth();
        int alto = this.getHeight();

        Graphics2D g2 = (Graphics2D) g;
        RoundRectangle2D card = new RoundRectangle2D.Float(0,0,(float)ancho-1
            ,(float)alto-1, 20f, 20f);

        g2.setColor(getActual());
        g2.fill(card);
        g2.setColor(Color.BLACK);
        g2.draw(card);

        g2.drawImage(icono.getImage(), ancho/5,alto/5, ancho*3/5, alto/2, this);
        g2.drawChars(titulo.toCharArray(), 0, titulo.length(),
         ((int)card.getCenterX())-(titulo.length()*3), alto*4/5);

    }    
}