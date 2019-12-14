package Java;

public class TestStatic {

   protected static class A {

       public static void testA() {
            System.out.println("static class test");
        }
    }

    class B{
        private void testB(){
            System.out.println("non static class test");
        }
    }


    public static void main(String[] args) {
        A a = new A();
        TestStatic t = new TestStatic();

        B b = t.new B();
        b.testB();
        a.testA();
        A.testA();
    }
}
