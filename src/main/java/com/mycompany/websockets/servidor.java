/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.websockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class servidor  extends Observable implements Runnable {
    
    private final int puerto;
    public servidor (int puerto){
    this.puerto = puerto;
    }
    
    
    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        
        ServerSocket servidor =null;
        Socket sc =null;
        DataInputStream in;
        DataOutputStream out;
        
        
        try {
            //creamos servidor socket
            servidor = new ServerSocket(puerto);
            System.out.println("SERVIDOR INICIADO");
             while(true){
             sc= servidor.accept();
                 System.out.println("Cliente ciectado");
                 in = new DataInputStream(sc.getInputStream());
               
             String mensaje = in.readUTF();
                 System.out.println(mensaje);
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                 sc.close();
                 System.out.println("Cliente conetado");
                     }
          
            
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE,null,ex);
            
            
            
        }
    }
    }
    
    
