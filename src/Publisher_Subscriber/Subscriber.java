package Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Subscriber <M> implements ISubscriber {

    private List<M> messages = new ArrayList<>();

    String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void addSubscriber(String topic, PubSubService pubSubService) {
        pubSubService.addSubscriber(topic, this);
    }

    @Override
    public void removeSubscriber(String topic, PubSubService pubSubService) {
      pubSubService.removeSubsCriber(topic,this);
    }

    @Override
    public void getMessageForSubscribeTopic(String topic, PubSubService pubSubService) {
        pubSubService.sendMessageToSubscriber(topic,this);
    }
}
