package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task  implements  Runnable{
    public void run(){
        System.out.println("Thread is " + Thread.currentThread().getId() + " running ");
    }

    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            eService.execute(new Task());
        }
    }
}
