import controller.ControllerAuthentication;

public class Main {

    public static void main(String[] args) {

//        User user = new User();
//        user.setName("Douglas");
//        user.setNickname("dsmartins98");
//        user.setPassword("pass123");
//        user.setStatus("Vivendo a vida adoidado");

        ControllerAuthentication controllerAuthentication = new ControllerAuthentication("192.168.56.1", 56000);
        controllerAuthentication.signUp("Douglas", "dsmartins", "123", "Hey man");
//        controllerAuthentication.signIn("dsmartins98", "pass123");
    }

}
