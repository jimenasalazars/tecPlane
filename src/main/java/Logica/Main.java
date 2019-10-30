/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Personas;
import Datos.Vuelos;
import Interfaz.SeleccionDeModulos;

/**
 *
 * @author samue
 */
public class Main {
    public static void main(String[] args) {
        /*Vuelos vuelo1 = new Vuelos("vuelo1", false, "Uruguay");
    
        Vuelos vuelo2 = new Vuelos("vuelo1", false, "Inglaterra");
        
        Vuelos vuelo3 = new Vuelos("vuelo1", false, "Japon");
        
        Vuelos vuelo4 = new Vuelos("vuelo1", false, "Mexico");
        
        Vuelos.listaVuelos.insert(vuelo4);
        Vuelos.listaVuelos.insert(vuelo3);
        Vuelos.listaVuelos.insert(vuelo2);
        Vuelos.listaVuelos.insert(vuelo1);*/
        
        Vuelos.especiales = 8;
        Vuelos.oros = 8;
        Vuelos.platinos = 8;
        Vuelos.economicos = 8;
        
        Vuelos vue1 = new Vuelos("jeje", true, "Guatemala");
        //vue1.setPuerta(2);
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
        vue1.getHeapPersonas().addNodo(per3);
        vue1.getHeapPersonas().addNodo(per4);
        vue1.getHeapPersonas().addNodo(per5);
        vue1.getHeapPersonas().addNodo(per6);
        vue1.getHeapPersonas().addNodo(per7);
        vue1.getHeapPersonas().addNodo(per8);
        Vuelos.listaVuelos.insert(vue1);
        
        Vuelos vue2 = new Vuelos("jeje2", false, "USA");
        //vue2.setPuerta(3);
        Personas per9 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "USA", 4);
        Personas per10 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "USA", 4);
        Personas per11 = new Personas("Guada", "dfghjk", 8745, "bhnjm", "CR", "USA", 3);
        Personas per12 = new Personas("Samuel", "dfghjk", 8745, "bhnjm", "CR", "USA", 3);
        Personas per13 = new Personas("Fabrizio", "dfghjk", 8745, "bhnjm", "CR", "USA", 2);
        Personas per14 = new Personas("Jimena", "dfghjk", 8745, "bhnjm", "CR", "USA", 2);
        Personas per15 = new Personas("Josue", "dfghjk", 8745, "bhnjm", "CR", "USA", 1);
        Personas per16 = new Personas("Debora", "dfghjk", 8745, "bhnjm", "CR", "USA", 1);
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
        vue2.getHeapPersonas().addNodo(per11);
        vue2.getHeapPersonas().addNodo(per12);
        vue2.getHeapPersonas().addNodo(per13);
        vue2.getHeapPersonas().addNodo(per14);
        vue2.getHeapPersonas().addNodo(per15);
        vue2.getHeapPersonas().addNodo(per16);
        Vuelos.listaVuelos.insert(vue2);
        
        Vuelos vue3 = new Vuelos("jeje3", true, "Argentina");
        //vue3.setPuerta(5);
        Personas per17 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 4);
        Personas per18 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 4);
        Personas per19 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 3);
        Personas per20 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 3);
        Personas per21 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 2);
        Personas per22 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 2);
        Personas per23 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 1);
        Personas per24 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Argentina", 1);
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
        vue3.getHeapPersonas().addNodo(per19);
        vue3.getHeapPersonas().addNodo(per20);
        vue3.getHeapPersonas().addNodo(per21);
        vue3.getHeapPersonas().addNodo(per22);
        vue3.getHeapPersonas().addNodo(per23);
        vue3.getHeapPersonas().addNodo(per24);
        Vuelos.listaVuelos.insert(vue3);
        
        Vuelos vue4 = new Vuelos("jeje4", false, "Panama");
        //vue4.setPuerta(8);
        Personas per25 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Panama", 4);
        Personas per26 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Panama", 4);
        Personas per27 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Panama", 3);
        Personas per28 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Panama", 3);
        Personas per29 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Panama", 2);
        Personas per30 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Panama", 2);
        Personas per31 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "Panama", 1);
        Personas per32 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "Panama", 1);
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
        vue4.getHeapPersonas().addNodo(per27);
        vue4.getHeapPersonas().addNodo(per28);
        vue4.getHeapPersonas().addNodo(per29);
        vue4.getHeapPersonas().addNodo(per30);
        vue4.getHeapPersonas().addNodo(per31);
        vue4.getHeapPersonas().addNodo(per32);
        Vuelos.listaVuelos.insert(vue4);
        
        SeleccionDeModulos ventana = new SeleccionDeModulos();
        ventana.setTitle("Seleccion de Modulos");
        ventana.dispose();
        ventana.setVisible(true);
        
        /*System.out.println(vue2.getHeapPersonas().Bpersonas(2).getNombre());
        System.out.println(vue2.getHeapPersonas().delete(2));
        //System.out.println(vue2.getHeapPersonas().existe(2));
        System.out.println(vue2.getHeapPersonas().Bpersonas(2).getNombre());
        System.out.println(vue2.getHeapPersonas().delete(2));
        System.out.println(vue2.getHeapPersonas().existe(2));*/
        //System.out.println(vue2.getHeapPersonas().Cantidad(2));
        //System.out.println(vue2.getHeapPersonas().Bpersonas(2).getNombre());

    }
}
