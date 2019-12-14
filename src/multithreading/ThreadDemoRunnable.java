package multithreading;

public class ThreadDemoRunnable implements Runnable {

    public void run(){
        try{
            System.out.println("Thread is " + Thread.currentThread().getId() + " running ");

        }
        catch (Exception e){
            System.out.println("Exception caught" + e);
        }
    }
    public static void main(String[] args) {
       for(int i = 0; i < 8; i++){
           Thread obj = new Thread(new ThreadDemo());
           obj.start();
       }
    }
}
