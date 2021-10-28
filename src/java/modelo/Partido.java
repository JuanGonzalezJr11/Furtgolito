package modelo;

import java.util.Date;

public class Partido {
    private int idPartido;
    private String fecha;
    private String hora;
    private Jugador mvp;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Arbitro arbitro;
    private Campo campo;
    private int jornada;
    private int resultadoEquipoLocal;
    private int resultadoEquipoVisitante;
    private boolean estado;

    public Partido() {
    }

    public Partido(int idPartido, String fecha, String hora, Jugador mvp, Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, Campo campo, int jornada, int resultadoEquipoLocal, int resultadoEquipoVisitante, boolean estado) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.hora = hora;
        this.mvp = mvp;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.arbitro = arbitro;
        this.campo = campo;
        this.jornada = jornada;
        this.resultadoEquipoLocal = resultadoEquipoLocal;
        this.resultadoEquipoVisitante = resultadoEquipoVisitante;
        this.estado = estado;
    }

    public Partido(String fecha, String hora, Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, Campo campo, int jornada) {
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.arbitro = arbitro;
        this.campo = campo;
        this.jornada = jornada;
    }

    public Partido(int idPartido, String fecha, String hora, Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, Campo campo, int jornada) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.arbitro = arbitro;
        this.campo = campo;
        this.jornada = jornada;
    }

    // ResultadoPartidoServlet
    public Partido(int idPartido, Jugador mvp, int resultadoEquipoLocal, int resultadoEquipoVisitante) {
        this.idPartido = idPartido;
        this.mvp = mvp;
        this.resultadoEquipoLocal = resultadoEquipoLocal;
        this.resultadoEquipoVisitante = resultadoEquipoVisitante;
    }
    
    public int getIdPartido() {
        return this.idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Jugador getMvp() {
        return this.mvp;
    }

    public void setMvp(Jugador mvp) {
        this.mvp = mvp;
    }

    public Equipo getEquipoLocal() {
        return this.equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return this.equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Arbitro getArbitro() {
        return this.arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Campo getCampo() {
        return this.campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getResultadoEquipoLocal() {
        return resultadoEquipoLocal;
    }

    public void setResultadoEquipoLocal(int resultadoEquipoLocal) {
        this.resultadoEquipoLocal = resultadoEquipoLocal;
    }

    public int getResultadoEquipoVisitante() {
        return resultadoEquipoVisitante;
    }

    public void setResultadoEquipoVisitante(int resultadoEquipoVisitante) {
        this.resultadoEquipoVisitante = resultadoEquipoVisitante;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", fecha=" + fecha + ", hora=" + hora + ", mvp=" + mvp + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", arbitro=" + arbitro + ", campo=" + campo + ", jornada=" + jornada + ", resultadoEquipoLocal=" + resultadoEquipoLocal + ", resultadoEquipoVisitante=" + resultadoEquipoVisitante + ", estado=" + estado + '}';
    }
}
