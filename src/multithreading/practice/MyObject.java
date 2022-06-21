package multithreading.practice;

public class MyObject  implements  Runnable{

    String obj = null;

    MyObject(String obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("Thread : " +Thread.currentThread().getName() + " : "+i);
        }

    }


    public static void main(String[] args) {
        String str = new String("How you doing?");
        Runnable runnable1 = new MyObject(str);
        Runnable runnable2 = new MyObject(str);
        Thread thread1 = new Thread(runnable1, "thread1");
        Thread thread2 = new Thread(runnable2, "thread2");
        thread1.start();
        try {
            thread1.join();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        thread2.start();

    }


}
