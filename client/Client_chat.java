package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
// import java.time.LocalDate;

import chat.Chat_interface;
// import data.User;
// import server.Hello_interface;

public class Client_chat {

    private Client_chat() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Chat_interface obj_remote = (Chat_interface) registry.lookup("rmi://localhost/SERVER");

            //user a ser implantado
            // User u = new User("niko", "Af0!wqFas2023", LocalDate.now(), true);
                //todo algum problema de serialização
            // String response = obj_remote.join_chat("nikof1", u);

            String response =  obj_remote.get_date_time("teste");
           
            System.out.println("response: " + response);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }




    // public static void main(String[] args) {
    //     try {
    //         Registry registry = LocateRegistry.getRegistry();
    //         Hello_interface objRemoto = (Hello_interface) registry.lookup("rmi://localhost/SERVIDOR");
    //         String mensagem = "ola mundo";
    //         System.out.println("Nova frase : "+ objRemoto.sayHello(mensagem));
    //     } catch (Exception e) {
    //         System.out.println("Erro no cliente:"+ e);
    //     }
    // }
}