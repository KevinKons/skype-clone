package Controller.mantainOnlines;

import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.CloseConnection;

/**
 *
 * @author Kevin
 */
public class ThreadNotifiesUserLogIn extends Thread {

    private final String ip;
    private final String nickname;

    public ThreadNotifiesUserLogIn(String nickname, String ip) {
        this.ip = ip;
        this.nickname = nickname;
    }
    
    @Override
    public void run() {
        MaintainOnlines maintainOnlines = MaintainOnlines.getInstance();
        //percorrendo todos que estão online
        for (Map.Entry<String, String> pair : maintainOnlines.getOnlines().entrySet()) {
            User online = UserDAO.findByNickname(pair.getKey());
            //verificando se usuário online possui como contato o usuário que ficou online
            for (User contact : online.getContacts()) {
                if (contact.getNickname().equalsIgnoreCase(nickname)) {
                    try {
                        //comunicando ao usuário que um de seus contatos agora está online
                        Socket conn = new Socket(contact.getIp(), 56000);
                        conn.setSoTimeout(3000);
                        
                        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
                        out.println(1);
                        out.println(nickname + ";" + ip);
                        
                        CloseConnection.getInstance().closeOutAndConn(out, conn);
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadNotifiesUserLogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
}
