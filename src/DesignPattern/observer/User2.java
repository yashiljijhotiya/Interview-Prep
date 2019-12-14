package DesignPattern.observer;

public class User2 implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("User 2 Subscriber :" +  m.getMessage());
    }
}
