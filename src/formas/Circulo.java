package formas;

public class Circulo extends Forma {

    private double r,centerX,centerY;

    public Circulo(int x, int y, int squareSize) {
        super(x, y, squareSize, squareSize);
        r = ((double)squareSize)/2;
        centerX = r;
        centerY = r;

        double[][] interseccionesX = new double[squareSize+1][2];
        double[][] interseccionesY = new double[squareSize+1][2];

        for(int yI=0; yI<=squareSize; yI++){
            double raiz = Math.sqrt((r*r)-Math.pow((double)yI-centerY,2));
            if(raiz != Double.NaN){
                interseccionesX[yI][0] = raiz + centerX;
                interseccionesX[yI][1] = centerX - raiz;
            }
        }
        for(int xI=0; xI<=squareSize; xI++){
            double raiz = Math.sqrt((r*r)-Math.pow((double)xI-centerX,2));
            if(raiz != Double.NaN){
                interseccionesY[xI][0] = raiz + centerY;
                interseccionesY[xI][1] = centerY - raiz;
            }
        }

        for(int i=0; i<=squareSize/2; i++){
            double entra = interseccionesX[i][0];
            double sale = 0;
            boolean entro = false;

            if(entra<squareSize && (int)interseccionesY[(int)entra+1][1] == i){
                sale = interseccionesY[(int)entra+1][1];
                if((entra - (double)(int)entra)==0)
                pixeles[(int)entra][i] = (1+((((double)(int)sale)+1)-sale))/2;
                else
                pixeles[(int)entra][i] = ((entra - (double)(int)entra)+((((double)(int)sale)+1)-sale))/2;
                for(int j = (int)entra+1;(int)interseccionesY[j+1][1] == i;j++){
                    entra = sale;
                    sale = interseccionesY[j+1][1];
                    pixeles[j][i] = (((((double)(int)entra)+1)-entra)+((((double)(int)sale)+1)-sale))/2;
                }
                entro=true;
                entra = sale-(int)sale!=0 ? sale : sale-1;
            }
            sale=interseccionesX[i+1][0];

            if(entro)
            pixeles[sale-(int)sale!=0?(int)sale:(int)sale-1][i] = (((((double)(int)entra)+1)-entra)+(sale-(double)(int)sale))/2;
            else if((int)entra<squareSize)
            pixeles[(int)entra][i] = ((entra - (double)(int)entra)+(sale-(double)(int)sale))/2;
            
        }

        for(int i=0;i<squareSize/2;i++){
            for(int j=squareSize/2;j<squareSize;j++){
                if(pixeles[j][i]!=0){
                    pixeles[squareSize-1-j][i] = pixeles[j][i];
                    pixeles[j][squareSize-1-i] = pixeles[j][i];
                    pixeles[squareSize-1-j][squareSize-1-i] = pixeles[j][i];
                }
            }
        }
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}