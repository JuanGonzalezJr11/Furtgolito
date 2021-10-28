package modelo;

public class PosicionJugador {
    private int idPosicionJugador;
    private String posicionJugador;

    public PosicionJugador() {
    }

    public PosicionJugador(int idPosicionJugador, String posicionJugador) {
        this.idPosicionJugador = idPosicionJugador;
        this.posicionJugador = posicionJugador;
    }

    public int getIdPosicionJugador() {
        return this.idPosicionJugador;
    }

    public void setIdPosicionJugador(int idPosicionJugador) {
        this.idPosicionJugador = idPosicionJugador;
    }

    public String getPosicionJugador() {
        return this.posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    @Override
    public String toString() {
        return posicionJugador;
    }
}
