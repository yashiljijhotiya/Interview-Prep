package Java8;

public interface IWork {
    void work();

    default void test(){
    System.out.println("test...");
    }

    static void test1(){
    System.out.println("test1...");
    }
}
