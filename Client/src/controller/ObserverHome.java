package controller;

import controller.authentication.Observer;

/**
 *
 * @author Kevin
 */
public interface ObserverHome extends Observer {

    public void notifiesUserLogout(String ip);
    public void notifiesUserAdded(String nickname, String name, String status,
            String ip);
    void setNameNavBar(String name);
    
}
