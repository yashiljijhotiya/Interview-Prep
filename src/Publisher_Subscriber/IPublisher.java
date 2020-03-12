package Publisher_Subscriber;

public interface IPublisher <M> {

    public void publish(M message, PubSubService pubSubService);
}
