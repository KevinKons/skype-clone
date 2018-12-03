package controller;

import controller.authentication.Observer;

/**
 *
 * @author Kevin
 */
public interface ObserverHome extends Observer {

    public void notifiesUserLogout(String ip);
    public void notifiesUserAdded(String nickname, String name, String status,
            boolean isOnline);
    public void notifiesUserLogin(String nickname, String ip);
    public void showMessages(String messages);
    public void notifiesUserRemove(String nickname);
    
}
