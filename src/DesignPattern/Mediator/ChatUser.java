package DesignPattern.Mediator;

public class ChatUser  extends  User{

    public ChatUser(IChatRoom chatRoom,String id, String name){
     super(chatRoom,id,name);
    }

    @Override
    public void send(String msg, String userId) {
        System.out.println(this.getName() + " : sending message : "+ msg);
        getChatRoom().sendMessage(msg,userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.getName() + " : Receiving message :  " + msg);
    }
}
