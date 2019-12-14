package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue <E> {
    private Queue<E> bq;
    private int max_size = 10;
    ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BlockingQueue(int size) {
        bq = new LinkedList<>();
        max_size = size;
    }

    public void put(E e) {
        lock.lock();
        try {
            while(bq.size() == max_size) {
                notFull.await();
            }
            bq.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public E take() {
        lock.lock();
        try {
            while (bq.size() == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            E item = bq.remove();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) throws InterruptedException {
       BlockingQueue<Integer> bq = new BlockingQueue<>(10);
        final Runnable producer = () -> {
            int i = 0;
            while(i < 10){
                System.out.println("producer produce value : " + i);
             bq.put(i++);
           }
        };
        new Thread(producer).start();
       // new Thread(producer).start();

        final Runnable consumer = () -> {
          while(true){
              var val = bq.take();
              System.out.println("consumer consume value: " + val);
          }
        };
        new Thread(consumer).start();
      //  new Thread(consumer).start();
        Thread.sleep(1000);

    }
}
