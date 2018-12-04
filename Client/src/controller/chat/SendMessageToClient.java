package controller.chat;

import controller.ManageControllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessageToClient extends Thread {

    private String content;
    private String ip;
    private final int PORT = 56003;

    public SendMessageToClient(String content, String ip) {
        this.content = content;
        this.ip = ip;
    }

    @Override
    public void run() {

        try {
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
