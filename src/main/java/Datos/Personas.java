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
    /**
     * Atributos
     */
    private String nombre;
    private String fechaDeNacimiento;
    private int númeroDePasaporte;
    private String nacionalidad;
    private String lugarDeOrige;
    private String lugarDeDestino;
    private int clase;
    private String asiento;
/**
 * Constructor
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
/**
 * constructor
 */
    public Personas(){
        
    }
    /**
     * Metodo para obtener el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
/**
 * metodo para definir el nombre del objeto
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Metodo para obtener la fecha de nacimiento del objeto
 * @return 
 */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
/**
 * Metodo para definirla fecha de nacimiento
 * @param fechaDeNacimiento 
 */
    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
/**
 * metodo para obtener el numero de pasaporte
 * @return 
 */
    public int getNúmeroDePasaporte() {
        return númeroDePasaporte;
    }
/**
 * metodo para definir el numero de pasaporte
 * @param númeroDePasaporte 
 */
    public void setNúmeroDePasaporte(int númeroDePasaporte) {
        this.númeroDePasaporte = númeroDePasaporte;
    }
/**
 * Metodo para obtener la nacionalidad
 * @return 
 */
    public String getNacionalidad() {
        return nacionalidad;
    }
/**
 * Metodo para definir la nacionalidad
 * @param nacionalidad 
 */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
/**
 * Metodo para obtener el lugar de origen
 * @return 
 */
    public String getLugarDeOrige() {
        return lugarDeOrige;
    }
/**
 * Metodo para definir el lugar de origen
 * @param lugarDeOrige 
 */
    public void setLugarDeOrige(String lugarDeOrige) {
        this.lugarDeOrige = lugarDeOrige;
    }
/**
 * Metodo para obtener lugar de destino
 * @return 
 */
    public String getLugarDeDestino() {
        return lugarDeDestino;
    }
/**
 * Metodo para definir el lugar de destino
 * @param lugarDeDestino 
 */
    public void setLugarDeDestino(String lugarDeDestino) {
        this.lugarDeDestino = lugarDeDestino;
    }
/**
 * Metodo para obtener la clase
 * @return 
 */
    public int getClase() {
        return clase;
    }
/**
 * metodo para definir la clase
 * @param clase 
 */
    public void setClase(int clase) {
        this.clase = clase;
    }
/**
 * Metodo para obtener el asiento
 * @return 
 */
    public String getAsiento() {
        return asiento;
    }
/**
 * Metodo para definir el asientos
 * @param asiento 
 */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

}
