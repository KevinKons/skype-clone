package Controller.command;

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
public class AddContact implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
        // nickname
        try {
            User user = UserDAO.findByIp(conn.getInetAddress().getHostAddress());
            User contact = UserDAO.findByNickname(in.readLine());
            
            user.addContact(contact);
            
            UserDAO.editar(user);
            
            out.println(contact.getNickname() + ";" + contact.getName() + ";" +
                    contact.getStatus() + ";" + contact.getIp());
            
            System.out.println(user.getName() + " adicinou " + contact.getNickname()+ " a sua lista de contatos.");
        } catch(NoResultException ex) {
            out.println("0");
        } finally {
            CloseConnection.getInstance().close(in, out, conn);
        }
    }

    @Override
    public Command clonar() {
        return new AddContact();
    }
    
}
