package controller;

import controller.authentication.Observer;

/**
 *
 * @author Kevin
 */
public interface ObserverHome extends Observer {

    public void notifiesUserLogout(String nickname);
    public void notifiesUserAdded(String nickname, String name, String status,
            String ip);
    public void notifiesUserLogin(String nickname, String ip);
    public void showMessages(String messages);
    public void notifiesUserRemove(String nickname);
    public void addMessage(String message);

}
