package chat;


import java.time.LocalDateTime;
import java.util.List;

import data.User;

public class Controller_chat implements Chat_interface{

    private List<User> _users;

    public String get_date_time(String name_user) {
        
        return name_user+" send as: "+ LocalDateTime.now();
    }

    public String join_chat(String name_user, User u) {

        _users.add(u);
        return name_user+" joined as: "+ LocalDateTime.now();
    }

    public List<User> list_users_joined() {
        
        return _users;
    }

    public String send_message(String message,String name_user) {
        
        return name_user+" "+LocalDateTime.now()+message;
    }

    
}
