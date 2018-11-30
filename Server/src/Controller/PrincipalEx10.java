package Controller;

import DAO.UserDAO;
import model.User;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author kevinkons
 */
public class PrincipalEx10 {
    
    public static void main(String[] args) throws UnknownHostException {
        
//        User user = new User("kevin", "senha", "kevin", "opaa");
//        
//        User c1 = new User("ip1", "c1", "kevinkons", "so de boa");
//        User c2 = new User("ip2", "c2", "kevinkons", "so de boa");
//        User c3 = new User("ip3", "c3", "kevinkons", "so de boa");
//        
//        user.addContacts(c1);
//        user.addContacts(c2);
//        user.addContacts(c3);
//        
//        c1.addContacts(user);
//        c1.addContacts(c2);
//        
//        UserDAO.salvar(user);

//          User user = UserDAO.findByNickname("kevin");
//          System.out.println(user.getPassword());
//            System.out.println(user.getNickname() + ";" + user.getName() + ";" + user.getStatus() + ";" + user.getIp());

        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ip);
        int port = 56000;
        Server server;
        try {
            server = new Server(port);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
