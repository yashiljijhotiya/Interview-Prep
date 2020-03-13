package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/* Semaphore use for this scenario :- Consider there is service which will  only allow or permit 3 threads at a time to use it's service
so to restrict the other thread to use this service it will  block other threads until it's one of it's permit is free for acquire.
NOTE : When even we want to restrict/ manage the use of resource to limited, use semaphore

* */
public class SemaphoreTask {

    static class Task  implements  Runnable{
        Semaphore semaphore;
        public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
        }

        @Override
        public void run() {
            //some processing
            semaphore.acquireUninterruptibly( );
            //IO call
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService pool = Executors.newFixedThreadPool(50);
        IntStream.of(1000).forEach(i -> pool.execute(new Task(semaphore)));
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

    }
}
