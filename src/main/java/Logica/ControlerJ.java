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
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        Vuelos.listaVuelos.insert(vue1);
        
        Vuelos vue2 = new Vuelos("jeje2", false, "USA");
        //vue2.setPuerta(3);
        Personas per9 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "USA", 4);
        Personas per10 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "USA", 4);
        Personas per11 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "USA", 3);
        Personas per12 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "USA", 3);
        Personas per13 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "USA", 2);
        Personas per14 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "USA", 2);
        Personas per15 = new Personas("Pedro", "dfghjk", 8745, "bhnjm", "CR", "USA", 1);
        Personas per16 = new Personas("Juan", "dfghjk", 8745, "bhnjm", "CR", "USA", 1);
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
        Vuelos.listaVuelos.insert(vue4);

        AsignacionVuelos.clear();
        
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {

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
                    Vuelos.setDisminucionPuertas(cantidad-1);
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
    
    public static void cargarPuertas (java.awt.List listPuertas){
        listPuertas.clear();
        
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {
            if (vueloTemp.getElement().getPuerta()==0){
                vueloTemp=vueloTemp.getNext();
            }
            else{
                listPuertas.add("Puerta: "+ vueloTemp.getElement().getPuerta());
                vueloTemp = vueloTemp.getNext();
            }
        }
    }
    
    public static String mostrarInfoPersona(int puertaSeleccion){
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {
            if (vueloTemp.getElement().getPuerta()==Vuelos.puertaSeleccionada){
                if("cola".equals(Vuelos.PrioridadSeleccionada)){
                    if(vueloTemp.getElement().getColaEspecial().getSize()>0){
                        Personas name=vueloTemp.getElement().getColaEspecial().dequeue();
                        return "Nombre: "+ name.getNombre()+" Pasaporte: " + name.getNúmeroDePasaporte() + " Clase: Especial";
                    }
                    else if(vueloTemp.getElement().getColaOro().getSize()>0){
                        Personas name=vueloTemp.getElement().getColaOro().dequeue();
                        return "Nombre: "+ name.getNombre()+" Pasaporte: " + name.getNúmeroDePasaporte() + " Clase: Oro";
                    }
                    else if(vueloTemp.getElement().getColaPlatino().getSize()>0){
                        Personas name=vueloTemp.getElement().getColaPlatino().dequeue();
                        return "Nombre: "+ name.getNombre()+" Pasaporte: " + name.getNúmeroDePasaporte() + " Clase: Plantino";
                    }
                    else if(vueloTemp.getElement().getColaEconomico().getSize()>0){
                        Personas name=vueloTemp.getElement().getColaEconomico().dequeue();
                        return "Nombre: "+ name.getNombre()+" Pasaporte: " + name.getNúmeroDePasaporte() + " Clase: Económico";
                    }
                    else{
                        return "Avión vacío";
                    }
                }
                if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
                    Heap per =vueloTemp.getElement().getHeapPersonas();
                    if (per.delete(1)!=false) {
                        Personas dato = per.Bpersonas(1);
                        per.delete(1);
                        return "Nombre: " + dato.getNombre() + " Pasaporte: " + dato.getNúmeroDePasaporte() + " Clase: Especial";
                    }
                    else if (per.delete(2)!=false) {
                        Personas dato = per.Bpersonas(2);
                        per.delete(2);
                        return "Nombre: " + dato.getNombre() + " Pasaporte: " + dato.getNúmeroDePasaporte() + " Clase: Oro";
                    }
                    else if (per.delete(3)!=false) {
                        Personas dato = per.Bpersonas(3);
                        per.delete(3);
                        return "Nombre: " + dato.getNombre() + " Pasaporte: " + dato.getNúmeroDePasaporte() + " Clase: Plantino";
                    }
                    else if (per.delete(4)!=false) {
                        Personas dato = per.Bpersonas(4);
                        per.delete(4);
                        return "Nombre: " + dato.getNombre() + " Pasaporte: " + dato.getNúmeroDePasaporte() + " Clase: Económico";
                    }
                    else{
                        return "Avión vacío";
                    }
                    }
                }
            else{
                vueloTemp = vueloTemp.getNext();
            }
        }
        return "Imposible realizar la acción solicitada";

        
    }
    
    public static float NaturalLanguage(String dato)throws Exception{
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            String text = dato;
            Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();

            Sentiment sentiments = language.analyzeSentiment(doc).getDocumentSentiment();
            return sentiments.getMagnitude();
        }
    }

    public static final String ACCOUNT_SID ="ACa1321939379136cb2b63c38e57f6e7ba";
    public static final String AUTH_TOKEN ="c1bee27a5a5a1a4e22e417c03a0e96b4";
    
    public static void smsSender(String asiento, String numeroTelefonico) {
        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(numeroTelefonico),new PhoneNumber("+12055461781"),asiento).create();

        System.out.println(message.getSid());
    }
    
    public static String cerrarPuerta(int puerta){
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();
        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {
            if (vueloTemp.getElement().getPuerta()==puerta){
                Vuelos.listaVuelos.setCurrent(vueloTemp);
                Vuelos.listaVuelos.remove();
                break;
            }
            else{
                vueloTemp = vueloTemp.getNext();
            }   
        }
        vueloTemp = Vuelos.listaVuelos.getHead().getNext();
        //Vuelos.listaVuelos.setCurrent(vueloTemp);
        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {
            if (vueloTemp.getElement().getPuerta()==0){
                vueloTemp.getElement().setPuerta(puerta);
                return "Al vuelo con destino " + vueloTemp.getElement().getDestino() + " se le asignó la puerta " + puerta;
            }
            else{
                vueloTemp = vueloTemp.getNext();
            }
        }
        return "No hay vuelos por asignar";
    }
    public static void AleatorioEspecial(int puerta, boolean elemento) {
        Personas per = new Personas();
        per.setClase(1);
        per.setNombre("NuevaPersona");
        per.setNúmeroDePasaporte(123456789);
        
        Timer timer = new Timer();
        
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                if (elemento == false) {
                    timer.cancel();
                    timer.purge();
                    return;
                }
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() == puerta) {
                    System.out.println("entro");
                    Lhead.getElement().getColaEspecial().enqueue(per);
                    return;
                } else {
                    Lhead = Lhead.getNext();
                }
            }

        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (headL.getElement().getPuerta() == puerta) {
                    headL.getElement().getHeapPersonas().addNodo(per);
                    return;
                } else {
                    headL = headL.getNext();
                }

            }
        }
            }
        };
        timer.schedule(task, 2000, 30000);
    }
    public static String checinEstadistica(){
        int especial =0;
        int oro =0;
        int platino =0;
        int economico =0;
        
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                especial = especial + Lhead.getElement().getColaEspecial().getSize();
                oro = oro + Lhead.getElement().getColaOro().getSize();
                platino = platino +Lhead.getElement().getColaPlatino().getSize();
                economico = economico + Lhead.getElement().getColaEconomico().getSize();
                Lhead = Lhead.getNext();
            }

        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {

                especial = especial + headL.getElement().getHeapPersonas().Cantidad(1);

                oro = oro + headL.getElement().getHeapPersonas().Cantidad(2);

                platino = platino + headL.getElement().getHeapPersonas().Cantidad(3);

                economico = economico + headL.getElement().getHeapPersonas().Cantidad(4);
                
                headL = headL.getNext();
            }
        
    }
        return "La cantidad de especial: "+especial+"\n"+"La cantidad de oro: "+oro+"\n"+"La cantidad de platino: "+platino+"\n"+"La cantidad de economico: "+economico;
    }
    
    public static String onboardEstadistica() {
        int especial = 0;
        int oro = 0;
        int platino = 0;
        int economico = 0;
        String finalS = "";
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());

            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() != 0) {
                    especial = especial + Lhead.getElement().getColaEspecial().getSize();
                    oro = oro + Lhead.getElement().getColaOro().getSize();
                    platino = platino + Lhead.getElement().getColaPlatino().getSize();
                    economico = economico + Lhead.getElement().getColaEconomico().getSize();
                    int total = especial + oro + platino + economico;
                    finalS = finalS + "\n" + "La puerta " + Lhead.getElement().getPuerta() + " tiene " + total + " personas";
                }
                Lhead = Lhead.getNext();
                especial = 0;
                oro = 0;
                platino = 0;
                economico = 0;
            }

        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (headL.getElement().getPuerta() != 0) {
                    especial = especial + headL.getElement().getHeapPersonas().Cantidad(1);

                    oro = oro + headL.getElement().getHeapPersonas().Cantidad(2);

                    platino = platino + headL.getElement().getHeapPersonas().Cantidad(3);

                    economico = economico + headL.getElement().getHeapPersonas().Cantidad(4);
                    int total = especial + oro + platino + economico;
                    finalS = finalS + "\n" + "La puerta " + headL.getElement().getPuerta() + " tiene " + total + " personas";
                }

                headL = headL.getNext();
                especial = 0;
                oro = 0;
                platino = 0;
                economico = 0;
            }

        }
        return finalS;
    }
    public static float promedioComentarios(){
        Comentarios.Nodo headC = Vuelos.comentarios.getHead().getNext();
        float sumatoria=0;
        for (int i=0; i<Vuelos.comentarios.getSize(); i++){
            sumatoria = sumatoria + headC.getElement();
            headC = headC.getNext();
        }
        return sumatoria/Vuelos.comentarios.getSize();
    }
    
    public static String tiempoporplandelealtad(){
        int especial =0;
        int oro=0;
        int platino=0;
        int economico=0;
        
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());

            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() != 0) {
                    especial = especial + Lhead.getElement().getColaEspecial().getSize()*Vuelos.rangoTiempo;
                    oro = oro + Lhead.getElement().getColaOro().getSize()*Vuelos.rangoTiempo;
                    platino = platino + Lhead.getElement().getColaPlatino().getSize()*Vuelos.rangoTiempo;
                    economico = economico + Lhead.getElement().getColaEconomico().getSize()*Vuelos.rangoTiempo;
                }
                Lhead = Lhead.getNext();
            }

        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (headL.getElement().getPuerta() != 0) {
                    especial = especial + headL.getElement().getHeapPersonas().Cantidad(1)*Vuelos.rangoTiempo;

                    oro = oro + headL.getElement().getHeapPersonas().Cantidad(2)*Vuelos.rangoTiempo;

                    platino = platino + headL.getElement().getHeapPersonas().Cantidad(3)*Vuelos.rangoTiempo;

                    economico = economico + headL.getElement().getHeapPersonas().Cantidad(4)*Vuelos.rangoTiempo;
                    
                }

                headL = headL.getNext();

            }
        
        
    }
   return "Tiempo de especiales "+especial+" segundos"+"\n"
                +"Tiempo de oro "+oro+" segundos"+"\n"
                +"Tiempo de platino "+" segundos"+platino+"\n"
                +"Tiempo de economico "+economico+" segundos"; 
}
    
    public static String tiemposalida(){
        int especial =0;
        int oro=0;
        int platino=0;
        int economico=0;
        
        if ("cola".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo Lhead = Vuelos.listaVuelos.getHead().getNext();
            System.out.println(Vuelos.listaVuelos.getSize());

            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (Lhead.getElement().getPuerta() != 0) {
                    especial = especial + Lhead.getElement().getColaEspecial().getSize()*Vuelos.rangoTiempo;
                    oro = oro + Lhead.getElement().getColaOro().getSize()*Vuelos.rangoTiempo;
                    platino = platino + Lhead.getElement().getColaPlatino().getSize()*Vuelos.rangoTiempo;
                    economico = economico + Lhead.getElement().getColaEconomico().getSize()*Vuelos.rangoTiempo;
                }
                Lhead = Lhead.getNext();
            }

        }
        if ("heap".equals(Vuelos.PrioridadSeleccionada)) {
            listasimple.Nodo headL = Vuelos.listaVuelos.getHead().getNext();
            for (int i = 0; i < Vuelos.listaVuelos.getSize(); i++) {
                if (headL.getElement().getPuerta() != 0) {
                    especial = especial + headL.getElement().getHeapPersonas().Cantidad(1)*Vuelos.rangoTiempo;

                    oro = oro + headL.getElement().getHeapPersonas().Cantidad(2)*Vuelos.rangoTiempo;

                    platino = platino + headL.getElement().getHeapPersonas().Cantidad(3)*Vuelos.rangoTiempo;

                    economico = economico + headL.getElement().getHeapPersonas().Cantidad(4)*Vuelos.rangoTiempo;
                    
                }

                headL = headL.getNext();

            }
        
        
    }
   int total = especial+oro+platino+economico;
   return "El tiempo promedio total de espera de salida es de "+ total + " segundos."; 
}
}