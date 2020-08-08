package menu;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class Contenido extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final Contenido contenido = new Contenido();

    private JLabel titulo;
    private JPanel cuadro;

    private Contenido() {
        setLayout(new BorderLayout());

        titulo = new JLabel("Temas");
        titulo.setOpaque(true);
        titulo.setFont(new Font("Courier", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titulo, BorderLayout.BEFORE_FIRST_LINE);
        cuadro = new CuadroHistorias();
        cuadro.setOpaque(false);
        this.add(cuadro, BorderLayout.CENTER);

        setBackground(Color.WHITE);
        
    }

    public void setContenido(String nombre, JPanel cuadro){
        contenido.remove(contenido.cuadro);
        contenido.titulo.setText(nombre);
        cuadro.setOpaque(false);
        contenido.cuadro=cuadro;
        contenido.add(cuadro);
    }
    
}