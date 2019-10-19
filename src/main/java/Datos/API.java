/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Usuario
 */
public class API {
        public static void main (String[] args){
        Timer timer = new Timer();
        
        TimerTask task= new TimerTask() {
            @Override
            public void run() {
               System.out.println("Holaaaaaaa");
            }
        };{
        
    }
        timer.schedule(task, 5000, 2000);
    }
}
