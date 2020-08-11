package componentes;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public abstract class BotonPanel extends JPanel implements MouseListener {
    
    private static final long serialVersionUID = 1L;

    private final Color base, hover, pressed;
    private boolean exited = false;
    private Color actual;

    public BotonPanel(Color base, Color hover, Color pressed){
        this.base = base;
        this.hover = hover;
        this.pressed = pressed;
        actual = base;
        addMouseListener(this);

        setOpaque(false);
    }

    protected Color getActual(){
        return actual;
    }
    
    protected abstract void accion();

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        actual = pressed;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!exited){
            actual = hover;
            repaint();
            accion();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        actual = hover;
        repaint();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        exited = false;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        actual = base;
        repaint();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        exited = true;
    }
    
}