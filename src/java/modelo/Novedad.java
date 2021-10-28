package modelo;

public class Novedad {
    private int idNovedad;
    private String titulo;
    private String descripcion;

    public Novedad() {
    }

    public Novedad(int idNovedad, String titulo, String descripcion) {
        this.idNovedad = idNovedad;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Novedad(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public int getIdNovedad() {
        return this.idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Novedad{" + "idNovedad=" + idNovedad + ", titulo=" + titulo + ", descripcion=" + descripcion + '}';
    }
}
