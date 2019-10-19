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
public class Vuelos {
    
    public static listasimple<Vuelos> listaVuelos = new listasimple<>();
    
    private int puerta;
    private String vuelo;
    private boolean abordo;
    private String Destino;

    
    
    public Vuelos(String vuelo, boolean abordo, String Destino) {
        this.vuelo = vuelo;
        this.abordo = abordo;
        this.Destino = Destino;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isAbordo() {
        return abordo;
    }

    public void setAbordo(boolean abordo) {
        this.abordo = abordo;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
    
}
