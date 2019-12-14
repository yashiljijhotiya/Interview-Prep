package Java;

public class Driver {
    public static void main(String[] args) {
        Anonymous a = new Anonymous() {
            @Override
            public void show() {
                System.out.printf("running Annonymous");
            }
        };
        a.show();
    }
}
