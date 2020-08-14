package menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import recursos.FileControl;

public class LaminaMenu extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final LaminaMenu lamina = new LaminaMenu();

    public static IGuardable ultimo = null;
    public static IEditable editar = null;

    private LaminaMenu() {

        this.setLayout(new BorderLayout());

        JMenuBar barra = new JMenuBar();
        JMenu archivo = new JMenu("General");
        JMenuItem edit = new JMenuItem("Editar");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem volver = new JMenuItem("Volver");
        JMenuItem inicio = new JMenuItem("Volver al inicio");
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editar!=null){
                    editar.editar();
                }
            }
        });
        guardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ultimo!=null){
                    ultimo.guardar();
                }
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
        inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                volverInicio();
            }
        });
        archivo.add(edit);
        archivo.add(guardar);
        archivo.addSeparator();
        archivo.add(volver);
        archivo.add(inicio);
        barra.add(archivo);
        this.add(barra, BorderLayout.NORTH);

        this.add(Contenido.contenido);
    }

    public void volver(){
        if(HistoriaPreview.historiaActual!=null)
        Contenido.contenido.setContenido(HistoriaPreview.historiaActual.getNombre(),
        new HistoriaPreview(HistoriaPreview.historiaActual));
    }

    public void volverInicio(){
        FileControl.setActual("Historias");
        Contenido.contenido.setContenido("Temas",new CuadroHistorias());
        updateUI();
    }
    
}