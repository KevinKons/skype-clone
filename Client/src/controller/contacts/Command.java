/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.contacts;


/**
 *
 * @author Kevin
 */
public interface Command {
    
    public void execute(String nickname);
    public Command clonar();
}
