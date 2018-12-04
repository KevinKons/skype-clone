package controller.chat;

import controller.contacts.RecorderThread;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class Call {

    private TargetDataLine audioIn;
    private String ip;
    private boolean isCalling = false;
    private SourceDataLine audioOut;


    public Call(TargetDataLine audioIn, SourceDataLine audioOut, String ip) {
        this.audioIn = audioIn;
        this.ip = ip;
        this.audioOut = audioOut;
    }
    
    public void initRecorder() {
         try {
            RecorderThread recorderThread = new RecorderThread(this);
            InetAddress inet = InetAddress.getByName(ip);
            recorderThread.audioIn = audioIn;
            recorderThread.dout = new DatagramSocket();
            System.out.println("iniciou transmissão");
            
            recorderThread.serverIp = inet;
            recorderThread.serverPort = 56002;
            isCalling = true;
            recorderThread.start();
        } catch (UnknownHostException | SocketException ex) {
            ex.printStackTrace();
        }
    }
    
    public void initPlayer() {
        try {
            PlayerThread thread = new PlayerThread(this);
            thread.din = new DatagramSocket(56002);
            thread.audioOut = audioOut;
            isCalling = true;
            thread.start();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isCalling() {
        return isCalling;
    }
    
}
