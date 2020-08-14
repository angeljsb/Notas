package formas;

import java.awt.Color;
import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;

public abstract class Forma implements IFormas {

    protected double[][] pixeles;
    protected int x,y,width,height;

    public Forma(int x, int y, int width, int height){

        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
        pixeles = new double[width][height];

    }

    @Override
    public void llenar(Graphics2D g) {
        Color color = g.getColor();
        for(int i = 0; i<width; i++){
            int primero = -1, ultimo =0;
            for(int j=0; j<height; j++){
                if(pixeles[i][j]!=0){
                    g.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(),(int)(pixeles[i][j]*255)));
                    g.fillRect(i+x,j+y,1,1);
                    if(primero==-1)
                    primero=j;
                    ultimo=j;
                }
            }
            g.setColor(color);
            if(primero!=-1)
            g.drawLine(i+x, primero+1+y, i+x, ultimo-1+y);
            else System.out.println(i);
        }
    }

    @Override
    public void delinear(Graphics2D g) {

        for(int i = 0; i<width; i++){
            for(int j=0; j<height; j++){
                if(pixeles[i][j]!=0){
                    g.fillRect(i+x,j+y,1,1);
                }
            }
        }
        
    }
    
}