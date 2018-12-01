package controller.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessageToClient extends Thread {

    private Object content;
    private String ip;
    private final int PORT = 56000;

    public SendMessageToClient(Object content, String ip) {
        this.content = content;
        this.ip = ip;
    }

    @Override
    public void run() {

        try {
            Socket conn = new Socket(ip, PORT);
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
