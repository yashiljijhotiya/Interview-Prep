package Java8;

import java.util.HashMap;
import java.util.function.Predicate;

public class LambdaExpressions {

    @FunctionalInterface
    interface Square {
        int calculate(int x);
    }

    public static void main(String[] args) {
        //
//      IWork work = ()-> System.out.println("testing lambda expression...");
//      work.work();
//      work.test();
//      IWork.test1();

        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lessThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lessThanTwenty).test(17);
        System.out.println(result);
        Square s = (x) -> x * x;
        System.out.println(s.calculate(2));

    }

}

