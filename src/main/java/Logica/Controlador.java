/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Datos.*;
import Interfaz.*;
import java.util.Random;
import java.awt.*;
/**
 *
 * @author samue
 */
public class Controlador {
    /**
     * Metodo para ingresar personas a un vuelo
     * @param nombre
     * @param fechaDeNacimiento
     * @param númeroDePasaporte
     * @param nacionalidad
     * @param lugarDeOrige
     * @param lugarDeDestino
     * @param clase
     * @return 
     */
    public static String ingresarPersona(String nombre, String fechaDeNacimiento, int númeroDePasaporte, String nacionalidad, String lugarDeOrige, String lugarDeDestino, int clase) {
        
        String[] seat = {"P", "C", "V"};
        Random r = new Random();
        int randomNumber = r.nextInt(seat.length);

        Personas per = new Personas(nombre, fechaDeNacimiento, númeroDePasaporte, nacionalidad, lugarDeOrige, lugarDeDestino, clase);
        
        if (clase == 1) {
            Vuelos.especiales = Vuelos.especiales + 1;
        }
        if (clase == 2) {
            Vuelos.oros = Vuelos.oros + 1;
        }
        if (clase == 3) {
            Vuelos.platinos = Vuelos.platinos + 1;
        }
        if (clase == 4) {
            Vuelos.economicos = Vuelos.economicos + 1;
        }

        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getDestino().equals(lugarDeDestino)) {
                    System.out.println("entro");
                    if (clase == 1) {
                        Lhead.getElement().getColaEspecial().enqueue(per);
                        return "Su número de asiento es: " + 1 + seat[randomNumber] + Lhead.getElement().getColaEspecial().getSize();
                    }
                    if (clase == 2) {
                        Lhead.getElement().getColaOro().enqueue(per);
                        return "Su número de asiento es: " + 2 + seat[randomNumber] + Lhead.getElement().getColaOro().getSize();
                    }
                    if (clase == 3) {
                        Lhead.getElement().getColaPlatino().enqueue(per);
                        return "Su número de asiento es: " + 3 + seat[randomNumber] + Lhead.getElement().getColaPlatino().getSize();
                    }
                    if (clase == 4) {
                        Lhead.getElement().getColaEconomico().enqueue(per);
                        return "Su número de asiento es: " + 4 + seat[randomNumber] + Lhead.getElement().getColaEconomico().getSize();
                    }
                } else {
                    Lhead = Lhead.getNext();
                }

            }
            Vuelos vue1 = new Vuelos("X", false, lugarDeDestino);
            if (clase == 1) {
                vue1.getColaEspecial().enqueue(per);
            }
            if (clase == 2) {
                vue1.getColaOro().enqueue(per);
            }
            if (clase == 3) {
                vue1.getColaPlatino().enqueue(per);
            }
            if (clase == 4) {
                vue1.getColaEconomico().enqueue(per);
            }
            Vuelos.listaVuelos.insert(vue1);
            return "Vuelo agregado";
        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (headL.getElement().getDestino().equals(lugarDeDestino)) {
                    headL.getElement().getHeapPersonas().addNodo(per);
                    return "Su número de asiento es: " + clase + seat[randomNumber] + headL.getElement().getHeapPersonas().getSize();
                } else {
                    headL = headL.getNext();
                }

            }
            Vuelos vue2 = new Vuelos("X", false, lugarDeDestino);
            vue2.getHeapPersonas().addNodo(per);
            Vuelos.listaVuelos.insert(vue2);
            return "Vuelo agregado";

        }
        return "Imposible asignar asiento";
    }
    /**
     * Metodo para identificar la clase de una persona
     * @param dato
     * @return 
     */
    public static int Tclase (String dato){
        if ("economico".equals(dato)){
            return 4;
        }
        if ("platino".equals(dato)){
            return 3;
        }
        if ("oro".equals(dato)){
            return 2;
        }
        if ("especial".equals(dato)){
            return 1;
        }
        else{
            return 0; 
        }
    }
    /**
     * Metodo para cargar la adiministracion de estado de puertas
     * @param listbox 
     */
    public static void cargarAdminEstadoPuertas (java.awt.List listbox){
        
        listbox.clear();
        for (int i=1; i<= Vuelos.cantPuertas;i++){
            listbox.add("Puerta " + i);
        }
        
    }
    /**
     * Metodo de consulta de estado de puertas
     * @param numPuerta
     * @return 
     */
    public static String consultarAdminEstadoPuertas(int numPuerta) {
        
        listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() == numPuerta) {
                    return "La prioridad utilizada en todas las colas es Cola de prioridad" + "\n"
                            + "La cantidad de personas en especial es " + Lhead.getElement().getColaEspecial().getSize() + "\n"
                            + "La siguiente persona en especial por antender es " + Lhead.getElement().getColaEspecial().first().getNombre() + "\n"
                            + "Los asientos asignados en especial van del 0 al " + Lhead.getElement().getColaEspecial().getSize() + "\n"
                            + "La cantidad de personas en oro es" + Lhead.getElement().getColaOro().getSize() + "\n"
                            + "La siguiente persona en oro por antender es " + Lhead.getElement().getColaOro().first().getNombre() + "\n"
                            + "Los asientos asignados en oro van del 0 al " + Lhead.getElement().getColaOro().getSize() + "\n"
                            + "La cantidad de personas en platino es" + Lhead.getElement().getColaPlatino().getSize() + "\n"
                            + "La siguiente persona en platino por antender es " + Lhead.getElement().getColaPlatino().first().getNombre() + "\n"
                            + "Los asientos asignados en platino van del 0 al " + Lhead.getElement().getColaPlatino().getSize() + "\n"
                            + "La cantidad de personas en económico es" + Lhead.getElement().getColaEconomico().getSize() + "\n"
                            + "La siguiente persona en económico por antender es " + Lhead.getElement().getColaEconomico().first().getNombre()+ "\n"
                            + "Los asientos asignadas en económico van del 0 al " + Lhead.getElement().getColaEconomico().getSize();
                } else {
                    Lhead = Lhead.getNext();
                }
            }
            return "Puerta no asignada a vuelo";
        }
        else if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
           for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() == numPuerta) {
                    return "La prioridad utilizada MaxHeap" + "\n"
                            + "La cantidad de personas es " + Lhead.getElement().getHeapPersonas().getSize() + "\n"
                            + "La siguiente persona por antender es " + Lhead.getElement().getHeapPersonas().getRaiz().getValor().getNombre() + "\n"
                            + "Los asientos asignados van del 0 al " + Lhead.getElement().getHeapPersonas().getSize();
                }else{
                   Lhead = Lhead.getNext(); 
                }
                
            }
           return "Puerta no asignada a vuelo";
        }
        return "Imposible realizar la consulta solicitada";

    }
    
}
