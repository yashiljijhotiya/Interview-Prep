package DesignPattern.observer;

/**
 * It is used by publisher to publish the message
 */
public interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notifyUpdate(Message m);
}
