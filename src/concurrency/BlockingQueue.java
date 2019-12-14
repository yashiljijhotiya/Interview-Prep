package concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue <T> {

    private Queue<T> q;
    private int size;

    public  BlockingQueue(int size){
        q = new LinkedList<>();
        this.size = size;
    }

    public synchronized void put( T item){
        while (q.size() == this.size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      q.add(item);
      notifyAll();
    }

    public synchronized T take(){
        while(q.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T item = q.remove();
        if(q.size() == this.size) {
            notifyAll();
        }
        return  item;
    }
}
