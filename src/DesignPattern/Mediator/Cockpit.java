package DesignPattern.Mediator;

public class Cockpit {

    public static void main(String[] args) {
        IChatRoom chatRoom = new ChatRoom();
        User user1 = new ChatUser(chatRoom, "1", "Yashil");
        User user2 = new ChatUser(chatRoom, "2", "Shubhi");
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.sendMessage("Hi Shubhi", user2.getId());
        chatRoom.sendMessage("Hi", user1.getId());
        chatRoom.sendMessage("Long time no see!, How have you been?", user2.getId());
    }

}
