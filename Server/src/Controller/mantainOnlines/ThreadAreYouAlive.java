/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.mantainOnlines;

import DAO.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Map;
import model.User;
import util.CloseConnection;

/**
 *
 * @author Kevin
 */
public class ThreadAreYouAlive extends Thread {

    private final String ip;
    private final String nickname;

    public ThreadAreYouAlive(String ip, String nickname) {
        this.ip = ip;
        this.nickname = nickname;
    }

    @Override
    public void run() {
        Socket conn = null;
        PrintWriter out = null;
        BufferedReader in = null;

        boolean isNotAlive = checkIsAlive(conn, out, in);
        CloseConnection.getInstance().close(in, out, conn);
        if (isNotAlive) {
            try {
                handleUserLogout();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean checkIsAlive(Socket conn, PrintWriter out, BufferedReader in) {
        try {
            conn = new Socket(ip, 56001);
            conn.setSoTimeout(3000);

            out = new PrintWriter(conn.getOutputStream(), true);
            out.println("Are you alive?");

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            in.readLine();
            System.out.println(nickname + " está online");
            return false;
        } catch (SocketTimeoutException ex) {
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            CloseConnection.getInstance().close(in, out, conn);
        }
        return true;
    }

    private void handleUserLogout() throws IOException {
        System.out.println(nickname + " ficou offline");
        
        MaintainOnlines maintainOnlines = MaintainOnlines.getInstance();

        maintainOnlines.removeOnline(nickname);

        User OfflineUser = UserDAO.findByNickname(nickname);
        OfflineUser.setIp(null);

        //percorrendo todos que estão online
        for (Map.Entry<String, String> pair : maintainOnlines.getOnlines().entrySet()) {
            User online = UserDAO.findByNickname(pair.getKey());
            //verificando se usuário online possui como contado usuário que ficou offline
            for (User contact : online.getContacts()) {
                if (contact.getNickname().equalsIgnoreCase(OfflineUser.getNickname())) {
                    //comunicando ao usuário que um de seus contatos agora está offline
                    Socket conn = new Socket(online.getIp(), 56001);
                    conn.setSoTimeout(3000);

                    PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
                    out.println(1);
                    out.println(nickname);
                    
                    CloseConnection.getInstance().closeOutAndConn(out, conn);
                }
            }
        }
    }

}
