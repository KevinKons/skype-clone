package controller.chat;

import model.User;

public class ChatController {

    private SendMessage sendMessageToClient;
    private Call call;
    private User contact;

    public ChatController(User user){
        this.contact = user;
    }

    public void openChat(String nickname){

        //Localizar contato na lista de contatos

        //

    }

    public void sendMessage(String content, String ip){
//        sendMessageToClient = new SendMessageToClient(content, ip);
//        sendMessageToClient.start();
    }

}
