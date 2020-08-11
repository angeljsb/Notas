package menu;

import javax.swing.JTextPane;
import javax.swing.JPanel;
import datos.Data;
import java.awt.BorderLayout;
import java.awt.Color;

public class DataPreview extends JPanel implements IEditable {

    private static final long serialVersionUID = 1L;
    private JTextPane descripcion = new JTextPane();

    public DataPreview(Data h){
        
        descripcion.setDisabledTextColor(Color.DARK_GRAY);
        descripcion.setText(h.getDescripcion());
        descripcion.setEnabled(false);
        setLayout(new BorderLayout());
        this.setOpaque(false);
        this.add(descripcion, BorderLayout.SOUTH);
        this.add(new DatosNotas(), BorderLayout.CENTER);
        LaminaMenu.editar = this;
    }

    @Override
    public void editar() {
        Contenido.contenido.setContenido("Editar data", new EditarData());
    }
    
}