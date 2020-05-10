package multithreading;

public class Test implements Runnable{

    private String color = "red";

    private void doSomething(){
        synchronized (color){
            color = "green";
            System.out.println(color + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        doSomething();

    }
    public static void main(String[] args) {

        Test test = new Test();
        Thread thread1 = new Thread(test);
        Thread thread2 = new Thread(test);
        thread1.start();

        thread2.start();

    }


}
