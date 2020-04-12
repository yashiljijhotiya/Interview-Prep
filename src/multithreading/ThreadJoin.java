package multithreading;
/*@author : Yashil (12-04-20)
* java.lang.Thread.join() : This method allows one thread to wait until another thread completes it's execution.
* Like wait()/notify()/notifyAll() mechanism, join() is another mechanism for inter-thread communication. There are
* 3 overloaded join method.
* see in the thread class.
*
* why do we require join() when we have wait(), notify() and notifyAll() methods?
*
* Main Purpose: to wait for other thread to complete execution.
* But it can be achieved by wait(), notify() and notifyAll(), it's not recommended that application uses these methods.
* So, coz internally, JVM relies on wait(), notify(), notifyAll() methods to changed the state of the thread(Blocked, waiting..)
*  so calling them on thread instances will corrupt the behaviour of the JVM.
*
*
*
* */
public class ThreadJoin{
    public static void main(String[] args) {
        Thread thread1  = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread-1 begins !!");
                for(int i = 0;  i < 10; i++){
                    System.out.println(i);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"Thread -1");
        thread1.start();
        try {
            thread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("test printed by main thread !!"); // It is run by main thread after completion of thread-1
    }
}
