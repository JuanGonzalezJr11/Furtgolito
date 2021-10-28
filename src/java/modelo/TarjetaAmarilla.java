package modelo;

public class TarjetaAmarilla {
    private int idTarjetaAmarilla;
    private Jugador jugador;
    private int minuto;
    private Partido partido;

    public TarjetaAmarilla() {
    }

    public TarjetaAmarilla(int idTarjetaAmarilla, Jugador jugador, int minuto, Partido partido) {
        this.idTarjetaAmarilla = idTarjetaAmarilla;
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
    }

    public TarjetaAmarilla(Jugador jugador, int minuto, Partido partido) {
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
    }

    public TarjetaAmarilla(int idTarjetaAmarilla, Jugador jugador, int minuto) {
        this.idTarjetaAmarilla = idTarjetaAmarilla;
        this.jugador = jugador;
        this.minuto = minuto;
    }
    
    public int getIdTarjetaAmarilla() {
        return this.idTarjetaAmarilla;
    }

    public void setIdTarjetaAmarilla(int idTarjetaAmarilla) {
        this.idTarjetaAmarilla = idTarjetaAmarilla;
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "TarjetaAmarilla{" + "idTarjetaAmarilla=" + idTarjetaAmarilla + ", jugador=" + jugador + ", minuto=" + minuto + ", partido=" + partido + '}';
    }
}
