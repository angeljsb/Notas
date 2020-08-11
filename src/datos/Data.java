package datos;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable{

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String descripcion;
    public ArrayList<Data> datos = new ArrayList<Data>();
    public ArrayList<Nota> notas = new ArrayList<Nota>();

    public Data(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }

    @Override
    public String toString(){
        return "Data: (Título = " + nombre + ", Descripcion = " + descripcion + ")";
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Data[] getDatos(){
        Data[] data = new Data[datos.size()];
        for(int i=0;i<datos.size();i++)
        data[i] = datos.get(i);
        return data;
    }

    public Nota[] getNotas(){
        Nota[] nota = new Nota[notas.size()];
        for(int i=0;i<notas.size();i++)
        nota[i] = notas.get(i);
        return nota;
    }

    public void addNota(Nota n){
        notas.add(n);
    }

    public void replaceNota(Nota n, int posicion){
        if(posicion<notas.size()){
            notas.remove(posicion);
            notas.add(posicion,n);
        } else{
            notas.add(n);
        }
    }
}