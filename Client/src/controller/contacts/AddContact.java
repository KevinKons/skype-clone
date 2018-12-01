package controller.contacts;


/**
 *
 * @author Kevin
 */
public class AddContact implements Command {

    @Override
    public void execute(String nickname) {
        
    }
    
    @Override
    public Command clonar() {
        return new AddContact();
    }

    
}
