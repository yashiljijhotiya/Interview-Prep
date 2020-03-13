package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    private Lock lockA = new ReentrantLock();
    private Lock lockB = new ReentrantLock();

    private void execute(){
        new Thread(this::processThis).start();
        new Thread(this::processThat).start();
    }

    private void processThis(){
        lockA.lock();
        System.out.println("Process resource A");
        lockB.lock();
        System.out.println("Process resource B");

        lockA.unlock();
        lockB.unlock();
    }

    private void processThat(){
        lockB.lock();
        System.out.println("Process resource B");
        lockA.lock();
        System.out.println("Process resource A");
        lockB.unlock();
        lockA.unlock();
    }




    public static void main(String[] args) {
        DeadLockExample de = new DeadLockExample();
        de.execute();

    }
}
