package menu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class CardsLayout implements LayoutManager {

    private final int MAX_HEIGHT = 200;
    private final int MIN_HEIGHT = 100;
    private final int MAX_WIDTH = 200;

    private int scrollY = 0;
    private boolean scrollable = false;
    private Component removido = null;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {
        this.removido = comp;
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int columnas = (parent.getWidth()/MAX_WIDTH) + 1;
        int width = parent.getWidth()/columnas;
        int height = parent.getHeight();

        int cantidad = parent.getComponentCount();
        int cantidadTarjetas = (removido!=null) ? cantidad-1 : cantidad;
        if(columnas >= cantidadTarjetas ){
            if(columnas>cantidadTarjetas)
            width=MAX_WIDTH;
            height = parent.getHeight()<MAX_HEIGHT ? parent.getHeight() : MAX_HEIGHT;
            scrollY = 0;
            scrollable = false;
        }else{
            float filas=((float)cantidadTarjetas/(float)columnas);
            filas = (filas-(float)(int)filas != 0) ? filas+1 : filas;
            height = parent.getHeight()/(int)filas;
            if(height<MIN_HEIGHT){
                height=MIN_HEIGHT;
                scrollable = true;
            }
            if((scrollY*5)-MIN_HEIGHT<-MIN_HEIGHT*(int)filas){
                scrollY = ((-MIN_HEIGHT*(int)filas)/5)+(MIN_HEIGHT/5);
            }else if(scrollY>0)
                scrollY = 0;
        }
        if(height>MAX_HEIGHT){
            height = MAX_HEIGHT;
        }
        int control = 0;

        for(int i=0;i<cantidad;i++){
            Component c = parent.getComponent(i);
            if(c==removido){
                c.setBounds(parent.getWidth()-35,parent.getHeight()-35,30,30);
                continue;
            }
            int x = (width*(control%columnas))+3;
            int y = (height*(control/columnas))+3;
            y += scrollY*5;

            if(i==cantidad-1){                
                c.setBounds(x,y,40,40);
            }else{
                c.setBounds(x, y, width-6, height-6);
            }
            control++;
        }

    }

    public void setScrollY(int cambio){
        if(scrollable)
        scrollY-=cambio;
    }
    
}