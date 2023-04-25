package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import data.User;

public interface Chat_interface extends Remote{

    String get_date_time(String name_user)throws RemoteException;

    String send_message(String message, String name_user) throws RemoteException;

    String join_chat(String name_use, User u) throws RemoteException;

    List<User> list_users_joined() throws RemoteException;
}
