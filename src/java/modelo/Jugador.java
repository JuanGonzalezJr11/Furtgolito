package modelo;

public class Jugador {

    private int idJugador;
    private String nombre;
    private String apellido;
    private int edad;
    private PosicionJugador posicionJugador;
    private int dorsal;
    private Equipo equipo;
    private boolean suspension;
    private boolean capitan;
    private String telefono;
    private String email;

    public Jugador() {
    }

    public Jugador(int idJugador, String nombre, String apellido, int edad, PosicionJugador posicionJugador, int dorsal, Equipo equipo, boolean suspension, boolean capitan, String telefono, String email) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicionJugador = posicionJugador;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.suspension = suspension;
        this.capitan = capitan;
        this.telefono = telefono;
        this.email = email;
    }

    // Método: altaJugador
    public Jugador(String nombre, String apellido, int edad, PosicionJugador posicionJugador, int dorsal, Equipo equipo, boolean capitan, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicionJugador = posicionJugador;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.capitan = capitan;
        this.telefono = telefono;
        this.email = email;
    }

    // Método: modificarJugador
    public Jugador(int idJugador, String nombre, String apellido, int edad, PosicionJugador posicionJugador, int dorsal, Equipo equipo, boolean capitan, String telefono, String email) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicionJugador = posicionJugador;
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.capitan = capitan;
        this.telefono = telefono;
        this.email = email;
    }

    // Método: ListaJugadoresPorEquipo
    public Jugador(int idJugador, String nombre, String apellido, int edad, PosicionJugador posicionJugador, int dorsal, boolean suspension, boolean capitan, String telefono, String email) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicionJugador = posicionJugador;
        this.dorsal = dorsal;
        this.suspension = suspension;
        this.capitan = capitan;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    
    public int getIdJugador() {
        return this.idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public PosicionJugador getPosicionJugador() {
        return this.posicionJugador;
    }

    public void setPosicionJugador(PosicionJugador posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public int getDorsal() {
        return this.dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public boolean isSuspension() {
        return this.suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public boolean isCapitan() {
        return this.capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String esCapitan() {
        if (this.capitan == false) {
            return "No";
        } else {
            return "Si";
        }
    }
    
    public String estaSuspendido() {
        if (this.suspension == false) {
            return "No";
        } else {
            return "Si";
        }
    }

    @Override
    public String toString() {
        return this.dorsal + ". " + this.nombre + " " + this.apellido + " - " + this.equipo;
    }
}
