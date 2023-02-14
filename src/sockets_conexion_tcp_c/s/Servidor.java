package sockets_conexion_tcp_c.s;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            
            final int PUERTO = 5000;
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("server up...");
            
            while(true){
                sc=servidor.accept();
                in=new DataInputStream(sc.getInputStream());
                out=new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                int longitudMensaje = mensaje.length();
                out.writeInt(longitudMensaje);
                out.writeUTF(mensaje);
                System.out.println("Hola mundo desde el servidor");
                sc.close();
                System.out.println("Cliente desconectado");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}