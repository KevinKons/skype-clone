package controller.contacts;

import controller.ManageControllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import model.Config;
import model.User;


/**
 *
 * @author Kevin
 */
public class AddContact implements Strategy {

    @Override
    public void execute(String nickname) throws Exception {
        Config conf = Config.getInstance();
        
        try {
            Socket conn = new Socket(conf.getAddress(), conf.getPort());
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            out.println(3);
            out.print(nickname);
            
            String response = in.readLine();
            if(Integer.parseInt(response) == 0) {
                throw new Exception("User not found");
            } else {
                //nickname ; name ; status ; ip
                String[] info = response.split(";");
                User contact = new User(info[0], info[1], info[2]);
                contact.setIp(info[3]);
                
                ManageControllers.getInstance().getUser().addContact(contact);
                System.out.println("Adicionou o usuario: " + contact.getName());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
