package Java8;

import java.util.function.Predicate;
/**
 * An interface with single abstract method is called functional interface.
 * It can be annotated by @FunctionalInterface. However it is not mandatory to use this annotation.
 * It is also known as Single Abstract Method Interfaces. In short, they are also known as SAM interfaces.
 * lambda expressions can be used to represent the instance of a functional interface.
 * A functional interface can have any number of default or static  methods. Runnable, ActionListener,
 * Comparable are some of the examples of functional interfaces.
 * Note that lambda expressions can only be used to implement functional interfaces.
 *
 * JAVA 8 provides 4 types of functional interfaces
 * - Consumer : The consumer interface of the functional interface is the one that accepts only one argument
 *              or a gentrified argument. The consumer interface has no return value. It returns nothing.
 * - Predicate : a predicate functional interface of java is a type of function which accepts a single value
 *               or argument and does some sort of processing on it, and returns a boolean (True/ False) answer.
 *               It can be used for filtering the result eg while processing stream.
 * - Function   : A function is a type of functional interface in Java that receives only a single argument and returns
 *                a value after the required processing.
 * - Supplier : The Supplier functional interface is also a type of functional interface that does not take any
 *              input or argument and yet returns a single output. This type of functional interface is generally
 *              used in the lazy generation of values. Supplier functional interfaces are also used for defining the logic for the generation of any sequence. For example – The logic behind the Fibonacci Series can be generated with the help of the Stream.generate method, which is implemented by the Supplier functional Interface.
 *
 * */
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

        Square s1 = (x) -> {
            System.out.println(x);
            return x;
        };

        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lessThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lessThanTwenty).test(17);
        System.out.println(result);
        Square s = (x) -> x * x;
        System.out.println(s.calculate(2));

    }

}

