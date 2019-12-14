package DesignPattern.observer;

public class User3 implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("User 3 Subscriber :" +  m.getMessage());
    }
}
