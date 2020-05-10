package multithreading.producer_consumer;

public class BlockingQueue <T> {

    private T[] arr;
    private int size = 0;
    private int capacity;
    private int head = 0;
    private int tail = 0;
    Object lock = new Object();

    public BlockingQueue(int capacity){
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (lock){

            while (size == capacity){
                lock.wait();
            }

            if(tail == capacity){
                tail = 0;
            }
            arr[tail] = item;
            size++;
            tail++;
            lock.notifyAll();
        }

    }

    public T dequeue() throws InterruptedException {
        T item = null;
        synchronized (lock){

            while (size == 0){
                lock.wait();
            }

            if(head == capacity){
                head = 0;
            }
            item = arr[head];
            arr[head] = null;
            head++;
            size--;

            lock.notifyAll();
        }
        return item;
    }


}
