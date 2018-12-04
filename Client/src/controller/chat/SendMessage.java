package controller.chat;

import controller.ManageControllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import model.User;

public class SendMessage extends Thread {

    private String content;
    private String nickname;
    private final int PORT = 56003;

    public SendMessage(String content, String nickname) {
        this.content = content;
        this.nickname = nickname;
    }

    @Override
    public void run() {

        try {
            User user = ManageControllers.getInstance().getUser();
            String ip = "";
            for(User contact : user.getContacts()) {
                if(contact.getNickname().equals(nickname)) {
                    ip = contact.getIp();
                }
            }
            
            System.out.println("Abrindo Socket SendMessage");
            System.out.println("IP: " + ip);
            Socket conn = new Socket(ip, PORT);
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            out.println(ManageControllers.getInstance().getUser().getNickname() + ";" + content);
            System.out.println("Enviou mensagem");

        } catch (IOException e) {
            System.out.println("Caiu na excessão");
            e.printStackTrace();
        }

    }

}
