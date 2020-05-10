package multithreading.problems;

public class FizzBuzz {

    private int n;
    private int num = 1;

    public FizzBuzz(int n){
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (num <= n){
            if(num % 3 == 0 && num % 5 != 0){
                System.out.println("Fizz");
                num++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (num <= n){
            if(num % 3 != 0 && num % 5 == 0){
                System.out.println("Buzz");
                num++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void fizzBuzz() throws InterruptedException {
        while (num <= n){
            if(num % 3 == 0  && num % 5 == 0){
                System.out.println("FizzBuzz");
                num++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (num <= n){
            if (num % 3 != 0 && num % 5 != 0){
                System.out.println(num);
                num++;
                notifyAll();
            }
            else {
                wait();
            }
        }
    }

}
