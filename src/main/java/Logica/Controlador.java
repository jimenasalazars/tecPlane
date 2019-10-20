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
    
    public static String ingresarPersona(String nombre, String fechaDeNacimiento, int númeroDePasaporte, String nacionalidad, String lugarDeOrige, String lugarDeDestino, int clase) {
        /*Vuelos vue3 = new Vuelos("jeje", true, "Guatemala");
        vue3.setPuerta(3);
        Vuelos.listaVuelos.insert(vue3);
        Vuelos vue4 = new Vuelos("jeje", true, "Guatemala");
        vue4.setPuerta(4);
        Vuelos.listaVuelos.insert(vue4);
        Vuelos vue5 = new Vuelos("jeje", true, "Guatemala");
        vue5.setPuerta(5);
        Vuelos.listaVuelos.insert(vue5);
        Vuelos vue6 = new Vuelos("jeje", true, "Guatemala");
        vue6.setPuerta(6);
        Vuelos.listaVuelos.insert(vue6);*/
        
        String[] seat = {"P", "C", "V"};
        Random r = new Random();
        int randomNumber = r.nextInt(seat.length);

        Personas per = new Personas(nombre, fechaDeNacimiento, númeroDePasaporte, nacionalidad, lugarDeOrige, lugarDeDestino, clase);

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
    
    public static void cargarAdminEstadoPuertas (java.awt.List listbox){
        /*Vuelos vue1 = new Vuelos("jeje", true, "Guatemala");
        vue1.setPuerta(2);
        Personas per1 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per2 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per7 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per8 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per3 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per4 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per5 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        Personas per6 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        vue1.getColaEspecial().enqueue(per5);
        vue1.getColaEspecial().enqueue(per6);
        vue1.getColaOro().enqueue(per3);
        vue1.getColaOro().enqueue(per4);
        vue1.getColaPlatino().enqueue(per7);
        vue1.getColaPlatino().enqueue(per8);
        vue1.getColaEconomico().enqueue(per1);
        vue1.getColaEconomico().enqueue(per2);
        vue1.getHeapPersonas().addNodo(per1);
        vue1.getHeapPersonas().addNodo(per2);
        Vuelos.listaVuelos.insert(vue1);
        
        Vuelos vue2 = new Vuelos("jeje2", false, "USA");
        vue2.setPuerta(3);
        Personas per9 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per10 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per11 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per12 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per13 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per14 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per15 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        Personas per16 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        vue2.getColaEspecial().enqueue(per15);
        vue2.getColaEspecial().enqueue(per16);
        vue2.getColaOro().enqueue(per13);
        vue2.getColaOro().enqueue(per14);
        vue2.getColaPlatino().enqueue(per11);
        vue2.getColaPlatino().enqueue(per12);
        vue2.getColaEconomico().enqueue(per9);
        vue2.getColaEconomico().enqueue(per10);
        vue2.getHeapPersonas().addNodo(per9);
        vue2.getHeapPersonas().addNodo(per10);
        Vuelos.listaVuelos.insert(vue2);
        
        Vuelos vue3 = new Vuelos("jeje3", true, "Argentina");
        vue3.setPuerta(5);
        Personas per17 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per18 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per19 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per20 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per21 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per22 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per23 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        Personas per24 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        vue3.getColaEspecial().enqueue(per23);
        vue3.getColaEspecial().enqueue(per24);
        vue3.getColaOro().enqueue(per21);
        vue3.getColaOro().enqueue(per22);
        vue3.getColaPlatino().enqueue(per19);
        vue3.getColaPlatino().enqueue(per20);
        vue3.getColaEconomico().enqueue(per17);
        vue3.getColaEconomico().enqueue(per18);
        vue3.getHeapPersonas().addNodo(per17);
        vue3.getHeapPersonas().addNodo(per18);
        Vuelos.listaVuelos.insert(vue3);
        
        Vuelos vue4 = new Vuelos("jeje4", false, "Panama");
        vue4.setPuerta(8);
        Personas per25 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per26 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 4);
        Personas per27 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per28 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 3);
        Personas per29 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per30 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 2);
        Personas per31 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        Personas per32 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Guatemala", 1);
        vue4.getColaEspecial().enqueue(per31);
        vue4.getColaEspecial().enqueue(per32);
        vue4.getColaOro().enqueue(per29);
        vue4.getColaOro().enqueue(per30);
        vue4.getColaPlatino().enqueue(per27);
        vue4.getColaPlatino().enqueue(per28);
        vue4.getColaEconomico().enqueue(per25);
        vue4.getColaEconomico().enqueue(per26);
        vue4.getHeapPersonas().addNodo(per25);
        vue4.getHeapPersonas().addNodo(per26);
        Vuelos.listaVuelos.insert(vue4);*/

        
        

        for (int i=1; i<= Vuelos.cantPuertas;i++){
            listbox.add("Puerta " + i);
        }
        
    }
    public static String consultarAdminEstadoPuertas(int numPuerta) {
        
        listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
        if (Vuelos.PrioridadSeleccionada == "cola") {
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() == numPuerta) {
                    return "La prioridad utilizada en todas las colas es Cola de prioridad" + "\n"
                            + "La cantidsad de personas en especial es " + Lhead.getElement().getColaEspecial().getSize() + "\n"
                            + "La siguiente persona en especial por antender es " + Lhead.getElement().getColaEspecial().first().getNombre() + "\n"
                            + "Los asientos asignads en especial van del 0 al " + Lhead.getElement().getColaEspecial().getSize() + "\n"
                            + "La cantidad de personas en oro es" + Lhead.getElement().getColaOro().getSize() + "\n"
                            + "La siguiente persona en oro por antender es " + Lhead.getElement().getColaOro().first().getNombre() + "\n"
                            + "Los asientos asignads en oro van del 0 al " + Lhead.getElement().getColaOro().getSize() + "\n"
                            + "La cantidad de personas en platino es" + Lhead.getElement().getColaPlatino().getSize() + "\n"
                            + "La siguiente persona en platino por antender es " + Lhead.getElement().getColaPlatino().first().getNombre() + "\n"
                            + "Los asientos asignads en platino van del 0 al " + Lhead.getElement().getColaPlatino().getSize() + "\n"
                            + "La cantidad de personas en economico es" + Lhead.getElement().getColaEconomico().getSize() + "\n"
                            + "La siguiente persona en economico por antender es " + Lhead.getElement().getColaEconomico().first().getNombre()+ "\n"
                            + "Los asientos asignads en economico van del 0 al " + Lhead.getElement().getColaEconomico().getSize();
                } else {
                    Lhead = Lhead.getNext();
                }
            }
            return "Puerta no asignada a vuelo";
        }
        else if (Vuelos.PrioridadSeleccionada == "heap") {
           for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() == numPuerta) {
                    return "La prioridad utilizada MaxHeap" + "\n"
                            + "La cantidad de personas es " + Lhead.getElement().getHeapPersonas().getSize() + "\n"
                            + "La siguiente persona por antender es " + Lhead.getElement().getHeapPersonas().getRaiz().getValor().getNombre() + "\n"
                            + "Los asientos asignads van del 0 al " + Lhead.getElement().getHeapPersonas().getSize();
                }else{
                   Lhead = Lhead.getNext(); 
                }
                
            }
           return "Puerta no asignada a vuelo";
        }
        return "Imposible realizar la consulta solicitada";

    }
    
}
