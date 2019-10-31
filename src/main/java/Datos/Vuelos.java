
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
    /**
     * Atributos estaticos
     */
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
    
    /**
     * Atributos
     */
    private int puerta;
    private String vuelo;
    private boolean abordo;
    private String Destino;
    private ColaG ColaEspecial = new ColaG();
    private ColaG ColaOro = new ColaG();
    private ColaG ColaPlatino = new ColaG();
    private ColaG ColaEconomico = new ColaG();
    private Heap HeapPersonas = new Heap();
    
    /**
     * constructor
     * @param vuelo
     * @param abordo
     * @param Destino 
     */
    public Vuelos(String vuelo, boolean abordo, String Destino) {
        this.vuelo = vuelo;
        this.abordo = abordo;
        this.Destino = Destino;
    }
/**
 * Constructor de vuelos
 */
    public Vuelos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Metodo para obtener los especiales
 * @return 
 */
    public ColaG getColaEspecial() {
        return ColaEspecial;
    }
/**
 * Metodo para definir la cola de especiales
 * @param ColaEspecial 
 */
    public void setColaEspecial(ColaG ColaEspecial) {
        this.ColaEspecial = ColaEspecial;
    }
/**
 * Metodo para obtener las personas oro
 * @return 
 */
    public ColaG getColaOro() {
        return ColaOro;
    }
/**
 * metodo para definir la cola oro
 * @param ColaOro 
 */
    public void setColaOro(ColaG ColaOro) {
        this.ColaOro = ColaOro;
    }
/**
 * Metodo para Obtener la cola platino
 * @return 
 */
    public ColaG getColaPlatino() {
        return ColaPlatino;
    }
/**
 * Metodo para definir la cola platino
 * @param ColaPlatino 
 */
    public void setColaPlatino(ColaG ColaPlatino) {
        this.ColaPlatino = ColaPlatino;
    }
/***
 * Metodo para obtener la cola economico
 * @return 
 */
    public ColaG getColaEconomico() {
        return ColaEconomico;
    }
/**
 * Metodo para definir la cola de economico
 * @param ColaEconomico 
 */
    public void setColaEconomico(ColaG ColaEconomico) {
        this.ColaEconomico = ColaEconomico;
    }
/**
 * Metodo para obtener el heap de personas
 * @return 
 */
    public Heap getHeapPersonas() {
        return HeapPersonas;
    }
/**
 * Metodo para definir el heap de personas
 * @param HeapPersonas 
 */
    public void setHeapPersonas(Heap HeapPersonas) {
        this.HeapPersonas = HeapPersonas;
    }
  /**
   * Metodo para obtener la puerta 
   * @return 
   */  
    public int getPuerta() {
        return puerta;
    }
/**
 * Metodo para definir la puerta
 * @param puerta 
 */
    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }
/**
 * Metodo para obtener le vuelo
 * @return 
 */
    public String getVuelo() {
        return vuelo;
    }
/**
 * Metodo para definir el vuelo
 * @param vuelo 
 */
    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }
/**
 * Metodo para saber si esta abordo
 * @return 
 */
    public boolean isAbordo() {
        return abordo;
    }
/**
 * metodo para definir si esta abordo 
 * @param abordo 
 */
    public void setAbordo(boolean abordo) {
        this.abordo = abordo;
    }
/**
 * Metodo para obtener el destino
 * @return 
 */
    public String getDestino() {
        return Destino;
    }
/**
 * Metodo para definir el destino
 * @param Destino 
 */
    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
/**
 * Metodo para obtener la prioridad
 * @return 
 */
    public static String getPrioridadSeleccionada() {
        return PrioridadSeleccionada;
    }
/**
 * Metodo para definir la prioridad
 * @param PrioridadSeleccionada 
 */
    public static void setPrioridadSeleccionada(String PrioridadSeleccionada) {
        Vuelos.PrioridadSeleccionada = PrioridadSeleccionada;
    }
/**
 * metodo para obtener la lista de vuelos
 * @return 
 */
    public static listasimple getListaVuelos() {
        return listaVuelos;
    }
/**
 * Metodo para definir la lista de vuelos
 * @param listaVuelos 
 */
    public static void setListaVuelos(listasimple listaVuelos) {
        Vuelos.listaVuelos = listaVuelos;
    }
/**
 * Metodo para obtener la cantidad de puertas
 * @return 
 */
    public static int getCantPuertas() {
        return cantPuertas;
    }
/**
 * Metodo para definir la cantidad de puertas
 * @param cantPuertas 
 */
    public static void setCantPuertas(int cantPuertas) {
        Vuelos.cantPuertas = cantPuertas;
    }
/**
 * metodo para obtener el rango de tiempo
 * @return 
 */
    public static int getRangoTiempo() {
        return rangoTiempo;
    }
/**
 * Metodo para definir el rango de tiempo
 * @param rangoTiempo 
 */
    public static void setRangoTiempo(int rangoTiempo) {
        Vuelos.rangoTiempo = rangoTiempo;
    }
/**
 * Metodo para obtener la disminucion de puertas
 * @return 
 */
    public static int getDisminucionPuertas() {
        return disminucionPuertas;
    }
/**
 * ,Metodo para definir la disminucion de puertas
 * @param disminucionPuertas 
 */
    public static void setDisminucionPuertas(int disminucionPuertas) {
        Vuelos.disminucionPuertas = disminucionPuertas;
    }
/**
 * metodo para obtener los comentarios
 * @return 
 */
    public static Comentarios getComentarios() {
        return comentarios;
    }
/**
 * metodo para definir los comentarios
 * @param comentarios 
 */
    public static void setComentarios(Comentarios comentarios) {
        Vuelos.comentarios = comentarios;
    }
/**
 * Metodo para obtener la puerta seleccionada
 * @return 
 */
    public static int getPuertaSeleccionada() {
        return puertaSeleccionada;
    }
/**
 * Metodo para definir la puerta seleccionada
 * @param puertaSeleccionada 
 */
    public static void setPuertaSeleccionada(int puertaSeleccionada) {
        Vuelos.puertaSeleccionada = puertaSeleccionada;
    }
    
}

