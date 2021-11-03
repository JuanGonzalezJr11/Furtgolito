/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class GoleadorDTO {
    private String nombre;
    private String apellido;
    private String nombreEquipo;
    private int cantidadGoles;

    public GoleadorDTO(String nombre, String apellido, String nombreEquipo, int cantidadGoles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreEquipo = nombreEquipo;
        this.cantidadGoles = cantidadGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    @Override
    public String toString() {
        return "GoleadorDTO{" + "nombre=" + nombre + ", apellido=" + apellido + ", nombreEquipo=" + nombreEquipo + ", cantidadGoles=" + cantidadGoles + '}';
    }
}
