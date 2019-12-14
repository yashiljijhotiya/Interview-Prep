package concurrency;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new BlockingQueue<>(5);
        final Runnable producer = () ->{
            while (true){
                bq.put(10);
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () ->{
            while(true){
                int i = bq.take();
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
