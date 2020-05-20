package multithreading.producer_consumer;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i = 0; i < 10; i++){
                        queue.enqueue(i);
                        System.out.println("produce : " +i);
                        Thread.sleep(1000);
                    }
                }
                catch (Exception e){
                 e.printStackTrace();
                }

            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
             for(int i = 0; i < 10; i++){
                 try {
                     System.out.println("consume : " + queue.dequeue());
                     Thread.sleep(1000);

                 }
                 catch (Exception e){
                     e.printStackTrace();
                 }
             }
            }
        });
        producer.start();
        consumer.start();
    }
}
