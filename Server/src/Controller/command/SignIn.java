package Controller.command;

import Controller.mantainOnlines.MaintainOnlines;
import DAO.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.persistence.NoResultException;
import model.User;
import util.CloseConnection;

/**
 *
 * @author Kevin
 */
public class SignIn implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
                
        // nickname ; password 
        String[] info = in.readLine().split(";");
        try {
            User user = UserDAO.findByNickname(info[0]);
            user.setIp(conn.getInetAddress().getHostAddress());
            if(user.getPassword().equals(info[1])) {
                sendUser(out, user);
                MaintainOnlines.getInstance().addOnline(user.getNickname(), user.getIp());
                UserDAO.editar(user);
                System.out.println(user.getNickname() + " entrou.");
            } else {
                out.println("0");
            }
        } catch(NoResultException ex) {
            out.println("0");
        } finally {
            CloseConnection.getInstance().close(in, out, conn);
        }
        
    }

    @Override
    public Command clonar() {
        return new SignIn();
    }

    private void sendUser(PrintWriter out, User user) {
        out.println(user.getNickname() + ";" + user.getName() + ";" + user.getStatus());
        for(User contact : user.getContacts()) {
            out.println(contact.getNickname() + ";" + contact.getName() + ";" +
                    contact.getStatus() + ";" + contact.getIp());
        }
    }
    
}
