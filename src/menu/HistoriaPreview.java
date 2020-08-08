package menu;

import javax.swing.JPanel;
import datos.Data;
import java.awt.BorderLayout;

public class HistoriaPreview extends JPanel {

    private static final long serialVersionUID = 1L;

    public static Data historiaActual;
    public static Data dataActual;

    public HistoriaPreview(Data h){
        HistoriaPreview.historiaActual = h;
        HistoriaPreview.dataActual = historiaActual;
        this.setLayout(new BorderLayout());
        this.add(new DataPreview(h),BorderLayout.CENTER);
    }
    
}