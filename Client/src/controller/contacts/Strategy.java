package controller.contacts;

/**
 *
 * @author Kevin
 */
public interface Strategy {
    
    public void execute(String nickname) throws Exception;
}
