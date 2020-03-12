package Publisher_Subscriber;

public interface ISubscriber {
    public void addSubscriber(String topic, PubSubService pubSubService);
    public void removeSubscriber(String topic, PubSubService pubSubService);
    public void getMessageForSubscribeTopic(String topic, PubSubService pubSubService);
}
