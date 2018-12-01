package controller.chat;

import controller.Call;
import model.User;

public class ChatController {

    private SendMessageToClient sendMessageToClient;
    private Call call;
    private User contact;

    public ChatController(User user){
        this.contact = user;
    }

    public void openChat(String nickname){

        //Localizar contato na lista de contatos

        //

    }

    public void sendMessage(Object content, String ip){
        sendMessageToClient = new SendMessageToClient(content, ip);
        sendMessageToClient.start();
    }

}
