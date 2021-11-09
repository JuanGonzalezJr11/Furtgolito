package modelo;

public class EquipoDTO {
    private int idEquipo;
    private String nombre;
    private int puntos;
    private int posicion;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;
    private int golesContra;
    private int diferenciaGoles;

    public EquipoDTO(int idEquipo, String nombre, int puntos, int posicion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.puntos = puntos;
        this.posicion = posicion;
    }

    public EquipoDTO(String nombre, int puntos, int posicion) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.posicion = posicion;
    }
    
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "EquipoDTO{" + "idEquipo=" + idEquipo + ", nombre=" + nombre + ", puntos=" + puntos + ", posicion=" + posicion + '}';
    }
}
