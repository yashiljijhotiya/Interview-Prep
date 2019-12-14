package multithreading;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue <Integer> queue = new BlockingQueue<>(2);

        Thread producer = new Thread( () -> {
           try {
               int value = 0;
               while (true) {
                   queue.put(value);
                   System.out.println("Produced " + value);
                   value ++;
                   Thread.sleep(1000);
               }

           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int value = queue.take();
                    System.out.println("Consume " + value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
