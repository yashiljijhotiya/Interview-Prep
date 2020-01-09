package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(5);
        eService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task are running");
            }
        });
        eService.shutdown();
    }
}
