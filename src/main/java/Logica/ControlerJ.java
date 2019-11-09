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
    /**
     * Metodo pata configuarcion inicial
     * @param prioridad
     * @param puertas
     * @param tiempo 
     */
    public static void setConfInicial(String prioridad,int puertas, int tiempo){
        Vuelos.setPrioridadSeleccionada(prioridad);
        Vuelos.setCantPuertas(puertas);
        Vuelos.setRangoTiempo(tiempo);
        Vuelos.setDisminucionPuertas(puertas);
    }
    /**
     * metodo para identificar un int
     * @param cadena
     * @return 
     */
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}

}
    

    /**
     * Metodo para cargar vuelos
     * @param AsignacionVuelos 
     */
    public static void cargarVuelos(java.awt.List AsignacionVuelos){
        AsignacionVuelos.clear();
        
        listasimple.Nodo vueloTemp = Vuelos.listaVuelos.getHead().getNext();

        for (int i = 0; i < Vuelos.listaVuelos.getSize() ; i++) {

            String vueloNombreDestino = vueloTemp.getElement().getDestino();
            AsignacionVuelos.add("Destino: "+vueloNombreDestino);
            vueloTemp = vueloTemp.getNext();
        }
    }
    /**
     * Metodo para asignar vuelos
     * @param Destination
     * @return 
     */
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
    /**
     * metodo para cargar puertas
     * @param listPuertas 
     */
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
    /**
     * metodo para mostrar la info de una persona
     * @param puertaSeleccion
     * @return 
     */
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
                    
                    if (!"No encontrado".equals(per.Bpersonas(1).getNombre())) {
                        
                        Personas dato = per.Bpersonas(1);
                        String elemento = "Nombre: " + dato.getNombre() + " Pasaporte: " + dato.getNúmeroDePasaporte() + " Clase: Especial";
                        per.delete(1);
                        return elemento;
                    }
                    else if (!"No encontrado".equals(per.Bpersonas(2).getNombre())) {
                        
                        Personas dato2 = per.Bpersonas(2);
                        String elemento2 = "Nombre: " + dato2.getNombre() + " Pasaporte: " + dato2.getNúmeroDePasaporte() + " Clase: Oro";
                        per.delete(2);
                        return elemento2;
                    }
                    else if (!"No encontrado".equals(per.Bpersonas(3).getNombre())) {
                        
                        Personas dato3 = per.Bpersonas(3);
                        String elemento3 = "Nombre: " + dato3.getNombre() + " Pasaporte: " + dato3.getNúmeroDePasaporte() + " Clase: Platino";
                        per.delete(3);
                        return elemento3;
                    }
                    else if (!"No encontrado".equals(per.Bpersonas(4).getNombre())) {
                        
                        Personas dato4 = per.Bpersonas(4);
                        String elemento4 = "Nombre: " + dato4.getNombre() + " Pasaporte: " + dato4.getNúmeroDePasaporte() + " Clase: Economico";
                        per.delete(4);
                        return elemento4;
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
    /**
     * Metodo del api de lenguaje natural
     * @param dato
     * @return
     * @throws Exception 
     */
    public static float NaturalLanguage(String dato)throws Exception{
        try (LanguageServiceClient language = LanguageServiceClient.create()) {

            String text = dato;
            Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();

            Sentiment sentiments = language.analyzeSentiment(doc).getDocumentSentiment();
            return sentiments.getMagnitude();
        }
    }

    public static final String ACCOUNT_SID ="AC2b07416a047d04a7174effc085377692";
    public static final String AUTH_TOKEN ="7b619dd56fc3eddcd828867326189d07";
    /**
     * Metodo del api de SMS
     * @param asiento
     * @param numeroTelefonico 
     */
    public static void smsSender(String asiento, String numeroTelefonico) {
        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(numeroTelefonico),new PhoneNumber("+12563339206"),asiento).create();

        System.out.println(message.getSid());
    }
    /**
     * Metodo para cerrar una puerta
     * @param puerta
     * @return 
     */
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
    /**
     * Metodo para insertar una persona aleatoria
     * @param puerta
     * @param elemento 
     */
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
    /**
     * Metodo para estadistica
     * @return 
     */
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

                especial = especial + headL.getElement().getHeapPersonas().getNespecial();

                oro = oro + headL.getElement().getHeapPersonas().getNoro();

                platino = platino + headL.getElement().getHeapPersonas().getNplatino();

                economico = economico + headL.getElement().getHeapPersonas().getNeconomico();
                
                headL = headL.getNext();
            }
        
    }
        return "La cantidad de especial: "+especial+"\n"+"La cantidad de oro: "+oro+"\n"+"La cantidad de platino: "+platino+"\n"+"La cantidad de económico: "+economico;
    }
    /**
     * Metodo para estadistica
     * @return 
     */
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
                    especial = especial + headL.getElement().getHeapPersonas().getNespecial();

                    oro = oro + headL.getElement().getHeapPersonas().getNoro();

                    platino = platino + headL.getElement().getHeapPersonas().getNplatino();

                    economico = economico + headL.getElement().getHeapPersonas().getNeconomico();
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
    /**
     * Metodo para estadistica
     * @return 
     */
    public static float promedioComentarios(){
        Comentarios.Nodo headC = Vuelos.comentarios.getHead().getNext();
        float sumatoria=0;
        for (int i=0; i<Vuelos.comentarios.getSize(); i++){
            sumatoria = sumatoria + headC.getElement();
            headC = headC.getNext();
        }
        return sumatoria/Vuelos.comentarios.getSize();
    }
    /**
     * Metodo de estadistica
     * @return 
     */
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
                    especial = especial + headL.getElement().getHeapPersonas().getNespecial()*Vuelos.rangoTiempo;

                    oro = oro + headL.getElement().getHeapPersonas().getNoro()*Vuelos.rangoTiempo;

                    platino = platino + headL.getElement().getHeapPersonas().getNplatino()*Vuelos.rangoTiempo;

                    economico = economico + headL.getElement().getHeapPersonas().getNeconomico()*Vuelos.rangoTiempo;
                    
                }

                headL = headL.getNext();

            }
        
        
    }
   return "Tiempo de especiales "+especial+" segundos."+"\n"
                +"Tiempo de oro "+oro+" segundos."+"\n"
                +"Tiempo de platino "+platino+" segundos."+"\n"
                +"Tiempo de económico "+economico+" segundos."; 
}
    /**
     * Metodo de estadistica
     * @return 
     */
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
                    especial = especial + headL.getElement().getHeapPersonas().getNespecial()*Vuelos.rangoTiempo;

                    oro = oro + headL.getElement().getHeapPersonas().getNoro()*Vuelos.rangoTiempo;

                    platino = platino + headL.getElement().getHeapPersonas().getNplatino()*Vuelos.rangoTiempo;

                    economico = economico + headL.getElement().getHeapPersonas().getNeconomico()*Vuelos.rangoTiempo;
                    
                }

                headL = headL.getNext();

            }
        
        
    }
   int total = especial+oro+platino+economico;
   return "El tiempo promedio total de espera de salida es de "+ total + " segundos."; 
}
}