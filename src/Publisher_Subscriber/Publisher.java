package Publisher_Subscriber;

public class Publisher implements IPublisher {
    @Override
    public void publish(Object message, PubSubService pubSubService) {
     pubSubService.addMessageToQueue(message);
    }
}
