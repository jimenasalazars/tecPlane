
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
// cambios
/**
 *
 * @author Usuario
 */
public class Vuelos {
    public static String PrioridadSeleccionada = "";
    public static int rangoTiempo = 0;
    public static int cantPuertas = 0;
    public static int disminucionPuertas=0;
    public static listasimple listaVuelos = new listasimple();
    public static Comentarios comentarios = new Comentarios();
    public static int especiales = 0;
    public static int oros = 0;
    public static int platinos = 0;
    public static int economicos = 0;
    public static float Npersonas = 0;
    public static Comentarios Nsalida = new Comentarios();
    public static int puertaSeleccionada = 0;
    
    
    private int puerta;
    private String vuelo;
    private boolean abordo;
    private String Destino;
    private ColaG ColaEspecial = new ColaG();
    private ColaG ColaOro = new ColaG();
    private ColaG ColaPlatino = new ColaG();
    private ColaG ColaEconomico = new ColaG();
    private Heap HeapPersonas = new Heap();
    
    
    public Vuelos(String vuelo, boolean abordo, String Destino) {
        this.vuelo = vuelo;
        this.abordo = abordo;
        this.Destino = Destino;
    }

    public Vuelos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ColaG getColaEspecial() {
        return ColaEspecial;
    }

    public void setColaEspecial(ColaG ColaEspecial) {
        this.ColaEspecial = ColaEspecial;
    }

    public ColaG getColaOro() {
        return ColaOro;
    }

    public void setColaOro(ColaG ColaOro) {
        this.ColaOro = ColaOro;
    }

    public ColaG getColaPlatino() {
        return ColaPlatino;
    }

    public void setColaPlatino(ColaG ColaPlatino) {
        this.ColaPlatino = ColaPlatino;
    }

    public ColaG getColaEconomico() {
        return ColaEconomico;
    }

    public void setColaEconomico(ColaG ColaEconomico) {
        this.ColaEconomico = ColaEconomico;
    }

    public Heap getHeapPersonas() {
        return HeapPersonas;
    }

    public void setHeapPersonas(Heap HeapPersonas) {
        this.HeapPersonas = HeapPersonas;
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

    public static String getPrioridadSeleccionada() {
        return PrioridadSeleccionada;
    }

    public static void setPrioridadSeleccionada(String PrioridadSeleccionada) {
        Vuelos.PrioridadSeleccionada = PrioridadSeleccionada;
    }

    public static listasimple getListaVuelos() {
        return listaVuelos;
    }

    public static void setListaVuelos(listasimple listaVuelos) {
        Vuelos.listaVuelos = listaVuelos;
    }

    public static int getCantPuertas() {
        return cantPuertas;
    }

    public static void setCantPuertas(int cantPuertas) {
        Vuelos.cantPuertas = cantPuertas;
    }

    public static int getRangoTiempo() {
        return rangoTiempo;
    }

    public static void setRangoTiempo(int rangoTiempo) {
        Vuelos.rangoTiempo = rangoTiempo;
    }

    public static int getDisminucionPuertas() {
        return disminucionPuertas;
    }

    public static void setDisminucionPuertas(int disminucionPuertas) {
        Vuelos.disminucionPuertas = disminucionPuertas;
    }

    public static Comentarios getComentarios() {
        return comentarios;
    }

    public static void setComentarios(Comentarios comentarios) {
        Vuelos.comentarios = comentarios;
    }

    public static int getPuertaSeleccionada() {
        return puertaSeleccionada;
    }

    public static void setPuertaSeleccionada(int puertaSeleccionada) {
        Vuelos.puertaSeleccionada = puertaSeleccionada;
    }
    
}

