package componentes;

import javax.swing.JPanel;

import menu.IEditable;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import menu.CardsLayout;

public class Tarjeta extends JPanel implements IEditable{

    private static final long serialVersionUID = 1L;
    private TextoTitulo titulo;
    private TextoTitulo contenido;

    public Tarjeta(){
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(0), 1, true));
        setLayout(new BorderLayout());
        titulo = new TextoTitulo("Nombre");
        contenido = new TextoTitulo("Descripci\u00f3n");
        titulo.setDisabledTextColor(Color.DARK_GRAY);
        contenido.setDisabledTextColor(Color.DARK_GRAY);
        contenido.setLayout(new CardsLayout());
        this.add(titulo, BorderLayout.NORTH);
        this.add(contenido, BorderLayout.CENTER);
    }

    public void setTitulo(String titulo) {
        this.titulo.setText(titulo);
        this.titulo.setForeground(Color.BLACK);
    }

    public void setContenido(String contenido){
        this.contenido.setText(contenido);
        this.contenido.setForeground(Color.BLACK);
    }

    public String getTitulo() {
        return titulo.getText();
    }

    public String getContenido() {
        return contenido.getText();
    }

    public void setEnabled(boolean enabled){
        this.titulo.setEnabled(enabled);
        this.contenido.setEnabled(enabled);
        if(!enabled){
            contenido.add(new BotonEditar(this));
            contenido.getLayout().removeLayoutComponent(contenido.getComponent(0));
            updateUI();
        }
    }

    public boolean isEnabled(){
        return this.titulo.isEnabled() && this.contenido.isEnabled();
    }

    public boolean haEscrito(){
        return this.titulo.getForeground()==Color.BLACK && this.titulo.getText().length()>0
        || this.contenido.getForeground() == Color.BLACK && this.contenido.getText().length()>0;
    }

    public void borrarTexto(){
        titulo.setText("Nombre");
        contenido.setText("Descripci\u00f3n");
        titulo.setForeground(Color.GRAY);
        contenido.setForeground(Color.GRAY);
    }

    @Override
    public void editar() {
        this.setEnabled(true);
        contenido.remove(0);
        updateUI();
    }
    
}