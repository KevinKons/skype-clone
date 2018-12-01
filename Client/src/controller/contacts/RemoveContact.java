/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.contacts;

import controller.ManageControllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import model.Config;
import model.User;

/**
 *
 * @author Kevin
 */
public class RemoveContact implements Strategy {
    
    @Override
    public void execute(String nickname) throws Exception {
        Config conf = Config.getInstance();
        
        try {
            Socket conn = new Socket(conf.getAddress(), conf.getPort());
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            out.println(4);
            out.print(nickname);
            
            String response = in.readLine();
            if(Integer.parseInt(response) == 0) {
                throw new Exception("User not found");
            } else {
                List<User> contacts = ManageControllers.getInstance().getUser().getContacts();
                for(int i = 0; i < contacts.size(); i++) {
                    User contact = contacts.get(i);
                    if(contact.getNickname().equalsIgnoreCase(nickname)) {
                        contacts.remove(contact);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
