package multithreading;
/*
@author : Yashil (12-04-20)

*The java.lang.Thread.yield() : this method causes the currently executing thread object to temporarily pause
* and allow other threads to execute which are  having same priority or higher priority. If threads have same
* priority then scheduler will decide which thread will run. If threads have lower priority than the same thread will
* continue to execute. It can only make a thread from Running State to Runnable State, not in wait or blocked state.
*
* public static native void yield() - here native means it's implementation is not provided by java. The implementation
* is system specific.
* */


public class ThreadYield implements Runnable{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("ThreadYield Class is being executed : " + thread.getName());

        for(int i=0; i < 10; i++){
            System.out.println("performing task : "+ i + "by : " + thread.getName());
            if(i == 5){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        ThreadYield threadYield  = new ThreadYield();
        Thread thread1 = new Thread(threadYield, "thread - 1");
        Thread thread2 = new Thread(threadYield, "thread - 2");
        thread1.start();
        thread2.start();
    }
}
