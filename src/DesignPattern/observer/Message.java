package DesignPattern.observer;

public class Message {
    public String getMessage() {
        return message;
    }

    final String message;

    public Message(String m) {
        this.message = m;
    }
}
