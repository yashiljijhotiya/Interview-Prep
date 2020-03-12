package Publisher_Subscriber;

import java.util.*;

public class PubSubService<M,S> {

    Queue<M> messageQueue = new LinkedList<>();
    Map<String, Set<S>> subscriberToTopic = new HashMap<>();

    public void addMessageToQueue(M message){
        messageQueue.add(message);
    }

    public void addSubscriber(String topic, S subscriber){
      if(subscriberToTopic.containsKey(topic)){
          Set<S> sToTopic = subscriberToTopic.get(topic);
          sToTopic.add(subscriber);
          subscriberToTopic.put(topic,sToTopic);
      }
      else{
          Set<S> subscribers = new HashSet<>();
          subscribers.add(subscriber);
          subscriberToTopic.put(topic,subscribers);
      }
    }

    public void removeSubsCriber(String topic, S subscriber){
       if(subscriberToTopic.containsKey(topic)){
           Set<S> sToTopic = subscriberToTopic.get(topic);
           sToTopic.remove(subscriber);
           subscriberToTopic.put(topic,sToTopic);
       }
    }

    public void sendMessageToSubscriber(String topic, S subscriber){
        if(messageQueue.isEmpty()){
            System.out.println("there is no message to publish!");
        }
        else {
            while (!messageQueue.isEmpty()){
                M message = messageQueue.poll();
                if(message.equals(topic)){
                    Set<S> subscribersOfTopic =  subscriberToTopic.get(topic);
                    for(S _subs : subscribersOfTopic){
                        if(_subs.equals(subscriber)){
                           // List<M> subcriberMessage = subscriber.g
                        }
                    }
                }
            }

        }
    }

}
