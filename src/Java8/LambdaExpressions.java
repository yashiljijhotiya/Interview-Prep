package Java8;

public class LambdaExpressions {

  public static void main(String[] args) {
    //
      IWork work = ()-> System.out.println("testing lambda expression...");
      work.work();
      work.test();
      IWork.test1();
  }
}
