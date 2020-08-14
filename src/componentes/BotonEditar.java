package componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import menu.IEditable;
import recursos.ImagesControl;

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
        Image lapiz = ImagesControl.crearImagen("Recursos/Editar.png").getImage();
        g2.drawImage(lapiz, 0, 0, this.getWidth(), this.getHeight(), this);

    }
    
}