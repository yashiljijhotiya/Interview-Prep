package multithreading;

import java.util.ArrayList;
import java.util.List;
/*@author : Yashil(12-04-20)
* */

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        List<Integer> sharedBuffer = new ArrayList<>();
        Thread thread1 = new Thread(new Producer(sharedBuffer));
        Thread thread2 = new Thread(new Consumer(sharedBuffer));
        thread1.start();
        thread2.start();
    }
}

//producer
class Producer implements Runnable{

    List<Integer> sharedBuffer = null;
    final int MAX_SIZE = 6;
    private int i = 0;

    public Producer(List<Integer> sharedBuffer){
        super();
        this.sharedBuffer = sharedBuffer;
    }
    @Override
    public void run() {

        while(true){
            try {
             produce(i++);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void produce(int data ) throws InterruptedException {
        synchronized (sharedBuffer){
        while (sharedBuffer.size() == MAX_SIZE){
            System.out.println(" SharedBuffer is full --- waiting for consumer to consume ");
            sharedBuffer.wait();
           }
        }
        synchronized (sharedBuffer){
            System.out.println("Producing the element : "+ data);
            sharedBuffer.add(data);
            Thread.sleep(1000);
            sharedBuffer.notify();
        }
    }
}

//consumer
class Consumer implements Runnable{

    List<Integer> sharedBuffer = null;

    public Consumer(List<Integer> sharedBuffer){
        super();
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {

        while (true){
            try{
              consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void consume() throws InterruptedException {
       synchronized (sharedBuffer){
           while (sharedBuffer.isEmpty()){
               System.out.println("Shared Buffer is empty --- waiting for producer t produce data");
               sharedBuffer.wait();
           }
       }

       synchronized (sharedBuffer){
           Thread.sleep(1000);
           System.out.println("consume the data : "+ sharedBuffer.remove(0));
           sharedBuffer.notify();
       }
    }
}
