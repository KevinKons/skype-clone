package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;

/**
 *
 * @author kevinkons
 */
public class PrincipalEx10 {
    
    public static void main(String[] args) {
        
//        User user = new User("ip", "kevin", "kevinkons", "so de boa");
//        
//        User c1 = new User("ip", "c1", "kevinkons", "so de boa");
//        User c2 = new User("ip", "c2", "kevinkons", "so de boa");
//        User c3 = new User("ip", "c3", "kevinkons", "so de boa");
//        
//        user.addContacts(c1);
//        user.addContacts(c2);
//        user.addContacts(c3);
//        
//        c1.addContacts(user);
//        c1.addContacts(c2);
//        
//        UserDAO.salvar(user);
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
    
