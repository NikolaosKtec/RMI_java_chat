package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
// import java.time.LocalDate;
import java.util.Scanner;

import chat.Chat_interface;
// import data.User;
// import server.Hello_interface;

public class Client_chat {

    private Client_chat() {}

    public static void main(String[] args) {
         String host = (args.length < 1) ? null : args[0];
         Scanner myObj = new Scanner(System.in);
         String userName = "";
         String message = "";
       
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Chat_interface obj_remote = (Chat_interface) registry.lookup("rmi://localhost/SERVER");

            //user a ser implantado
            // User u = new User("niko", "Af0!wqFas2023", LocalDate.now(), true);
                //todo algum problema de serialização
            // String response = obj_remote.join_chat("nikof1", u);
            
            System.out.println("entrando no chat digite x para sair;");
            System.out.println("escreva seu nome de usuário abaixo:");
            userName = myObj.nextLine(); 
            
           
           
            while(true){
                // input
                System.out.println("envie sua mensagem abaixo:");
                message = myObj.nextLine();
                
                if(message.equals("x")|| message.equals("X")){
                    break;
                }
                String response =  obj_remote.send_message(message,userName);
           
                System.out.println("chat: " + response);

            }

            

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }



}
