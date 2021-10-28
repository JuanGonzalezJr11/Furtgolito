package modelo;

public class TarjetaRoja {
    private int idTarjetaRoja;
    private Jugador jugador;
    private int minuto;
    private Partido partido;
    private String motivo;

    public TarjetaRoja() {
    }

    public TarjetaRoja(int idTarjetaRoja, Jugador jugador, int minuto, Partido partido, String motivo) {
        this.idTarjetaRoja = idTarjetaRoja;
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
        this.motivo = motivo;
    }

    public TarjetaRoja(int idTarjetaRoja, Jugador jugador, int minuto, String motivo) {
        this.idTarjetaRoja = idTarjetaRoja;
        this.jugador = jugador;
        this.minuto = minuto;
        this.motivo = motivo;
    }

    public TarjetaRoja(Jugador jugador, int minuto, Partido partido, String motivo) {
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
        this.motivo = motivo;
    }
    
    public int getIdTarjetaRoja() {
        return this.idTarjetaRoja;
    }

    public void setIdTarjetaRoja(int idTarjetaRoja) {
        this.idTarjetaRoja = idTarjetaRoja;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    @Override
    public String toString() {
        return "TarjetaRoja{" + "idTarjetaRoja=" + idTarjetaRoja + ", jugador=" + jugador + ", minuto=" + minuto + ", partido=" + partido + ", motivo=" + motivo + '}';
    }
}
