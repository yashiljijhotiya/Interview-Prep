package concurrency;

public class ThreadEx{

  //private static   Object lock = new Object();

    private void test() throws InterruptedException{
        synchronized (this){
            System.out.println("1");
            System.out.println("2");
            System.out.println(Thread.currentThread().getName());
            this.wait();
            System.out.println("3");
        }
        System.out.println("Test" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadEx threadEx = new ThreadEx();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadEx.test();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadEx.test();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadEx.test();

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
        thread1.start();
        thread2.start();
//        try {
//            thread1.join();
//        }catch (Exception e){
//            System.out.println("In catch");
//        }

        thread3.start();
        Integer x = 1;

    }
}
