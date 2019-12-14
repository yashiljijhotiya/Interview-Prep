package DesignPattern.observer;

public class User1 implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("User 1 Subscriber :" +  m.getMessage());
    }
}
