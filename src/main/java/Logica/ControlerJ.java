/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Interfaz.*;
import Datos.*;
import Datos.listasimple;
import java.awt.*;
/**
 *
 * @author Usuario
 */
public class ControlerJ {
    
    public static void setConfInicial(String prioridad,int puertas, int tiempo){
        Vuelos.setPrioridadSeleccionada(prioridad);
        Vuelos.setCantPuertas(puertas);
        Vuelos.setRangoTiempo(tiempo);
        Vuelos.setDisminucionPuertas(puertas);
    }
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}

}
    

    
    public static void cargarVuelos(java.awt.List AsignacionVuelos){
        Vuelos vuelo1 = new Vuelos("vuelo1", false, "Uruguay");
    
        Vuelos vuelo2 = new Vuelos("vuelo1", false, "Inglaterra");
        
        Vuelos vuelo3 = new Vuelos("vuelo1", false, "Japon");
        
        Vuelos vuelo4 = new Vuelos("vuelo1", false, "Mexico");
        
        Vuelos.listaVuelos.insert(vuelo4);
        Vuelos.listaVuelos.insert(vuelo3);
        Vuelos.listaVuelos.insert(vuelo2);
        Vuelos.listaVuelos.insert(vuelo1);

        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {

            //Vuelos vueloMostrar = (Vuelos) vueloTemp.getElement();
            String vueloNombreDestino = vueloTemp.getElement().getDestino();
            AsignacionVuelos.add("Destino: "+vueloNombreDestino);
            vueloTemp = vueloTemp.getNext();
        }
    }
    
    public static String asignar(String Destination) {
        int cantidad = Vuelos.disminucionPuertas;
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
            if (cantidad > 0) {
                if (vueloTemp.getElement().getDestino().equals(Destination)) {
                    vueloTemp.getElement().setPuerta(cantidad);
                    String dato = "La puerta asignada es: " + cantidad;
                    Vuelos.setCantPuertas(cantidad-1);
                    return dato;
                } else {
                    vueloTemp = vueloTemp.getNext();
                }
            } else {
                return "No hay puertas disponibles";
            }
        }
        return "Imposible realizar la accion solicitada";
    }
    }
