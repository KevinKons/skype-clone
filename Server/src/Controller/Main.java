package Controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author kevinkons
 */
public class Main {
    
    public static void main(String[] args) throws UnknownHostException {
        
        try {
        String ip = InetAddress.getLocalHost().getHostAddress();
        int port = 56000;
        System.out.println("Iniciando server em " + ip + ":" + port);
        Server server;
        try {
            server = new Server(port);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
    
