package DesignPattern.Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements IChatRoom {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void sendMessage(String msg, String userId) {
        User u = userMap.get(userId);
        u.receive(msg);

    }

    @Override
    public void addUser(User user) {
        this.userMap.put(user.getId(),user);
    }


}
