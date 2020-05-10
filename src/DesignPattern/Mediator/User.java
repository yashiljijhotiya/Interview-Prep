package DesignPattern.Mediator;

public abstract class User {

    private IChatRoom chatRoom;
    private String id;
    private String name;

    public User(IChatRoom chatRoom, String id, String name){
        this.chatRoom = chatRoom;
        this.id = id;
        this.name = name;
    }

    public abstract  void send(String msg, String userId);
    public  abstract  void receive(String msg);

    public IChatRoom getChatRoom(){
        return chatRoom;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
