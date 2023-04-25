package server;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import chat.Chat_interface;
import chat.Controller_chat;

public class Server implements Hello_interface {

    public Server() {}

    public String sayHello() {
        return "Hello";
    }
    public static void main(String[] argv) {
        try {
            // Server obj = new Server();
            // Controller_chat controller_chat = new Controller_chat();


            Chat_interface chat_interface = new Controller_chat();
            Chat_interface stub = (Chat_interface) UnicastRemoteObject.exportObject(chat_interface,1099);
            
             // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("rmi://localhost/SERVER", stub);

            
            System.out.println("Servidor está pronto.");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}