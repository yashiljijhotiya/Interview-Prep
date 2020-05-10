package multithreading.problems;

public class FizzBuzzCockpit extends Thread{

    FizzBuzz obj;
    String method;

    public FizzBuzzCockpit(FizzBuzz obj, String method){
        this.obj = obj;
        this.method = method;
    }

    public void run(){
        if("Fizz".equals(method)){
            try {
                obj.fizz();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
        else if("Buzz".equals(method)){
            try {
                obj.buzz();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
        else if("FizzBuzz".equals(method)){
            try{
                obj.fizzBuzz();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
        else if("Number".equals(method)){
            try{
                obj.number();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }

    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread thread1 = new FizzBuzzCockpit(fizzBuzz, "Fizz");
        Thread thread2 = new FizzBuzzCockpit(fizzBuzz, "Buzz");
        Thread thread3 = new FizzBuzzCockpit(fizzBuzz, "FizzBuzz");
        Thread thread4 = new FizzBuzzCockpit(fizzBuzz, "Number");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
