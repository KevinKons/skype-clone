package Controller.mantainOnlines;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class MaintainOnlines extends Thread {

    public static MaintainOnlines getInstance() {
        if (instance == null) {
            instance = new MaintainOnlines();
        }

        return instance;
    }

    private static MaintainOnlines instance;

    //nickname ; ip
    private Map<String, String> onlines = new HashMap<>();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (!onlines.isEmpty()) {
                System.out.println("verificando onlines");
                for (Map.Entry<String, String> pair : onlines.entrySet()) {
                    ThreadAreYouAlive threadAreYouAlive = 
                            new ThreadAreYouAlive(pair.getValue(), pair.getKey());
                    threadAreYouAlive.start();
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public Map<String, String> getOnlines() {
        return onlines;
    }

    public void addOnline(String nickname, String ip) {
        ThreadNotifiesUserLogIn threadNotifiesUserLogIn = 
                new ThreadNotifiesUserLogIn(nickname, ip);
        threadNotifiesUserLogIn.start();
        onlines.put(nickname, ip);
    }

    public synchronized void removeOnline(String nickname) {
        onlines.remove(nickname);
    }

}
