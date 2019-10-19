/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Usuario
 */
public class Personas {
    private String nombre;
    private String fechaDeNacimiento;
    private int númeroDePasaporte;
    private String nacionalidad;
    private String lugarDeOrige;
    private String lugarDeDestino;
    private int clase;
    private String asiento;
/**
 * 
 * @param nombre
 * @param fechaDeNacimiento
 * @param númeroDePasaporte
 * @param nacionalidad
 * @param lugarDeOrige
 * @param lugarDeDestino
 * @param clase 
 */
    public Personas(String nombre, String fechaDeNacimiento, int númeroDePasaporte, String nacionalidad, String lugarDeOrige, String lugarDeDestino, int clase) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.númeroDePasaporte = númeroDePasaporte;
        this.nacionalidad = nacionalidad;
        this.lugarDeOrige = lugarDeOrige;
        this.lugarDeDestino = lugarDeDestino;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getNúmeroDePasaporte() {
        return númeroDePasaporte;
    }

    public void setNúmeroDePasaporte(int númeroDePasaporte) {
        this.númeroDePasaporte = númeroDePasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getLugarDeOrige() {
        return lugarDeOrige;
    }

    public void setLugarDeOrige(String lugarDeOrige) {
        this.lugarDeOrige = lugarDeOrige;
    }

    public String getLugarDeDestino() {
        return lugarDeDestino;
    }

    public void setLugarDeDestino(String lugarDeDestino) {
        this.lugarDeDestino = lugarDeDestino;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    //Metodos

}
