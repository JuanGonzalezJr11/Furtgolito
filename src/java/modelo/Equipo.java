package modelo;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private int puntos;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, int puntos) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Equipo(int idEquipo, String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }
    
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
