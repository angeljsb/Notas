package menu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class LayoutBotones implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

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

        int anchoTotal = (parent.getComponentCount()*50)+(parent.getComponentCount()-1)*5;
        int xBase = (parent.getWidth()/2)-(anchoTotal/2);

        for(int i=0;i<parent.getComponentCount();i++){
            parent.getComponent(i).setBounds(xBase+(i*55), 5, 50, 20);
        }

    }
    
}