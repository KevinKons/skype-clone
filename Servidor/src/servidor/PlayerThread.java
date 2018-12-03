package servidor;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;


/**
 *
 * @author Kevin
 */
public class PlayerThread extends Thread {
    public DatagramSocket din;
    public SourceDataLine audioOut;
    byte[] buffer = new byte[512];

    @Override
    public void run() {
        int i = 0;
        DatagramPacket incomming = new DatagramPacket(buffer, buffer.length);
        while(Servidor.calling) {
            try {
                din.receive(incomming);
                buffer = incomming.getData();
                audioOut.write(buffer, 0, buffer.length);
                System.out.println("#" + i++);
            } catch (IOException ex) {
                Logger.getLogger(PlayerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        audioOut.close();
        audioOut.drain();
        System.out.println("stop");
    }
}
