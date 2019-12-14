package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BQImplementation <T> {
    public Queue<T> queue;
    int size;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private  Condition notFull = lock.newCondition();

    public BQImplementation(int size){
        queue = new LinkedList<>();
        this.size = size;
    }

    public void add(T val){
        lock.lock();
        try{
            while(queue.size() == size){
                notFull.wait();
            }
            queue.add(val);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

//    public T remove() {
//        lock.lock();
//        try {
//            while (queue.size() == 0) {
//                notEmpty.await();
//            }
//            return queue.remove();
//            notFull.signalAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//        return T;
//    }
}
