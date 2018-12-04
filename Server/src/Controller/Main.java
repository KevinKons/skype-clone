package Controller;

import DAO.UserDAO;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import model.User;

/**
 *
 * @author kevinkons
 */
public class Main {
    
    public static void main(String[] args) throws UnknownHostException {
        
        try {
            cleanOnlines();
            
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = 56000;
            System.out.println("Iniciando server em " + ip + ":" + port);
            Server server;
            server = new Server(port);
            server.startServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void cleanOnlines() {
        List<User> users = UserDAO.lerTodos();
        for(User user : users) {
            user.setIp(null);
            UserDAO.editar(user);
        }
    }
}
    
