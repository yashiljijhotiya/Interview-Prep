package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.*;

public class ThreadEx implements Runnable{
    public void run(){
        System.out.println("Thread name: "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("no. of core : " + coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        for(int i = 0; i < 10; i++ ){
            service.execute(new ThreadEx());
        }
    }
}
