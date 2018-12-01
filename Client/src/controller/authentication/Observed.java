/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import model.User;

/**
 *
 * @author dougl
 */
public interface Observed {

    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void signUp(String name, String nickname, String password, String RepeatPassword);
    
}
