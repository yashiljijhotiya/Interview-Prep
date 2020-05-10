package multithreading;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    private void test(){
        System.out.println("test" );

    }
    public static void main(String[] args) {
        ExecutorServiceExample e = new ExecutorServiceExample();
        ExecutorService eService = Executors.newFixedThreadPool(5);
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n");
        int n =  sc.nextInt();
        int i = 0;
        while(i  < n) {
            eService.execute(new Runnable() {
                @Override
                public void run() {
                    //System.out.println("Asynchronous task are running");
                    e.test();

                }
            });
            i++;
        }
        eService.shutdown();
    }
}
