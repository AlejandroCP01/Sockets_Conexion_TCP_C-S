package sockets_conexion_tcp_c.s;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            final String HOST = "127.0.0.1";
            final int PUERTO = 5000;
            DataInputStream in;
            DataOutputStream out;
            
            //Se intenta crear la conexion Socket para enviar y recibir un mensaje con el servidor UTP
        try {
            Socket sc= new Socket(HOST,PUERTO);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Hola mundo desde cliente");
            int longitudMensaje = in.readInt();
            String mensaje = in.readUTF();
            if(longitudMensaje > 0) {
                System.out.println(mensaje);
            }
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}