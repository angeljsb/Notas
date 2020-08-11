package menu;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.SpringLayout;
import ResourcesControl.FileControl;
import componentes.BotonGuardar;
import datos.Data;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AgregarHistoria extends JPanel implements IGuardable{

    private static final long serialVersionUID = 1L;
    private JTextArea titulo;
    private JTextPane descripcion;

    public AgregarHistoria(){
        SpringLayout layoutTotal = new SpringLayout();
        setLayout(layoutTotal);
        JPanel panelTitulo = new JPanel();
        SpringLayout layout = new SpringLayout();
        panelTitulo.setLayout(layout);
        JLabel labelTit = new JLabel("Tema: ");
        titulo = new JTextArea();
        panelTitulo.add(labelTit);
        panelTitulo.add(titulo);

        layout.putConstraint(SpringLayout.WEST,labelTit,5,SpringLayout.WEST,panelTitulo);
        layout.putConstraint(SpringLayout.WEST, titulo, 5, SpringLayout.EAST, labelTit);
        layout.putConstraint(SpringLayout.EAST, panelTitulo, 10, SpringLayout.EAST, titulo);
        layout.putConstraint(SpringLayout.SOUTH, panelTitulo, 10, SpringLayout.SOUTH, titulo);

        JPanel panelDescripcion = new JPanel();
        panelDescripcion.setLayout(new BorderLayout());
        panelDescripcion.add(new JLabel("Descripción: "), BorderLayout.NORTH);
        descripcion = new JTextPane();
        panelDescripcion.add(descripcion, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new BorderLayout(){
            private static final long serialVersionUID = 1L;

            @Override
            public void layoutContainer(Container target) {
                super.layoutContainer(target);
                target.getComponent(0).setBounds(target.getWidth()-55, target.getHeight()-55,
                    50, 50);
            }
        });
        panelBoton.setBackground(Color.WHITE);
        BotonGuardar boton = new BotonGuardar(this);
        boton.setBackground(Color.WHITE);
        panelBoton.add(boton,BorderLayout.EAST);

        this.add(panelTitulo,SpringLayout.WIDTH);
        this.add(panelDescripcion);
        this.add(panelBoton);

        layoutTotal.putConstraint(SpringLayout.NORTH,panelTitulo,0,SpringLayout.NORTH,this);
        layoutTotal.putConstraint(SpringLayout.SOUTH,panelTitulo,20,SpringLayout.NORTH,this);
        layoutTotal.putConstraint(SpringLayout.NORTH,panelDescripcion,0,SpringLayout.SOUTH,panelTitulo);
        layoutTotal.putConstraint(SpringLayout.SOUTH,this,55,SpringLayout.SOUTH,panelDescripcion);
        layoutTotal.putConstraint(SpringLayout.NORTH,panelBoton,0,SpringLayout.SOUTH,panelDescripcion);
        layoutTotal.putConstraint(SpringLayout.SOUTH,panelBoton,0,SpringLayout.SOUTH,this);

        layoutTotal.putConstraint(SpringLayout.EAST,panelTitulo,0,SpringLayout.EAST,this);
        layoutTotal.putConstraint(SpringLayout.EAST,panelDescripcion,0,SpringLayout.EAST,this);
        layoutTotal.putConstraint(SpringLayout.EAST,panelBoton,0,SpringLayout.EAST,this);
        layoutTotal.putConstraint(SpringLayout.WEST,panelTitulo,0,SpringLayout.WEST,this);
        layoutTotal.putConstraint(SpringLayout.WEST,panelDescripcion,0,SpringLayout.WEST,this);
        layoutTotal.putConstraint(SpringLayout.WEST,panelBoton,0,SpringLayout.WEST,this);
        
        LaminaMenu.ultimo = this;

    }

    @Override
    public void guardar() {
        String nombre = titulo.getText();
        FileControl.hijo(nombre + ".pln");
        Data historia = new Data(nombre,descripcion.getText());
        FileControl.guardarObjeto(historia);
        Contenido.contenido.setContenido(nombre, new HistoriaPreview(historia));
    }

    protected String getTitulo(){
        return titulo.getText();
    }

    protected String getDescripcion(){
        return descripcion.getText();
    }

    protected void setTitulo(String titulo){
        this.titulo.setText(titulo);
    }

    protected void setDescripcion(String descripcion){
        this.descripcion.setText(descripcion);
    }
    
}