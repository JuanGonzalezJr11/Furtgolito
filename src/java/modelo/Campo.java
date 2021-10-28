package modelo;

public class Campo {
    private int idCampo;
    private String nombre;

    public Campo() {
    }

    public Campo(int idCampo, String nombre) {
        this.idCampo = idCampo;
        this.nombre = nombre;
    }

    public Campo(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCampo() {
        return this.idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
