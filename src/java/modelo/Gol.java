package modelo;

public class Gol {
    private int idGol;
    private Jugador jugador;
    private int minuto;
    private Partido partido;
    private boolean contra;

    public Gol() {
    }

    public Gol(int idGol, Jugador jugador, int minuto, Partido partido, boolean contra) {
        this.idGol = idGol;
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
        this.contra = contra;
    }

    public Gol(int idGol, Jugador jugador, int minuto) {
        this.idGol = idGol;
        this.jugador = jugador;
        this.minuto = minuto;
    }

    // AltaGolServlet
    public Gol(Jugador jugador, int minuto, Partido partido, boolean contra) {
        this.jugador = jugador;
        this.minuto = minuto;
        this.partido = partido;
        this.contra = contra;
    }

    public int getIdGol() {
        return this.idGol;
    }

    public void setIdGol(int idGol) {
        this.idGol = idGol;
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

    public boolean isContra() {
        return contra;
    }

    public void setContra(boolean contra) {
        this.contra = contra;
    }
    
    public String golEnContra() {
        if (this.contra == false) {
            return "-";
        } else {
            return "contra";
        }
    }
    
    @Override
    public String toString() {
        return "Gol{" + "idGol=" + idGol + ", jugador=" + jugador + ", minuto=" + minuto + ", partido=" + partido + '}';
    }
}
