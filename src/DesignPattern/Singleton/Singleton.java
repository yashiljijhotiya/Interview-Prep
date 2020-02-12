package DesignPattern.Singleton;

public class Singleton {
    private static  volatile Singleton singleton = null;

    private Singleton(){}

    public static  Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                //double check lock
                //Lazy initialization
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return  singleton;
    }

    public static void main(String[] args) {
        System.out.println("s1 :" + getInstance().hashCode() + "  s2 :" + getInstance().hashCode());
        if(getInstance().equals(getInstance()))
            System.out.println("Singleton succeeded");

    }

}
