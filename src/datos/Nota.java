package datos;

import java.io.Serializable;

public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String descripcion;

    public Nota(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}