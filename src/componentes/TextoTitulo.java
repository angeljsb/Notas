package componentes;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextoTitulo extends JTextPane {

    private static final long serialVersionUID = 1L;

    public TextoTitulo(String label) {
        setForeground(Color.GRAY);
        setText(label);
        addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if(getForeground()==Color.GRAY){
                    setForeground(Color.BLACK);
                    setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().length()<1){
                    setText(label);
                    setForeground(Color.GRAY);
                }

            }
            
        });
    }
    
}