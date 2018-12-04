package controller.contacts;


import controller.chat.Call;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.sound.sampled.TargetDataLine;


/**
 *
 * @author Kevin
 */
public class RecorderThread extends Thread {
    
    public TargetDataLine audioIn = null;
    public DatagramSocket dout;
    byte byteBuff[] = new byte[512];
    public InetAddress serverIp;
    public int serverPort;
    private Call call;

    public RecorderThread(Call call) {
        this.call = call;
    }
    
    @Override
    public void run() {
        int i = 0;
        while(call.isCalling()) {
            try {
                audioIn.read(byteBuff, 0, byteBuff.length);
                DatagramPacket data = new DatagramPacket(byteBuff, byteBuff.length, serverIp, serverPort);
                System.out.println("send #" + i++);
                dout.send(data);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        audioIn.close();
        audioIn.drain();
        System.out.println("Thread stop");
    }
}
