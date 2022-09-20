package DesignPattern.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

/**
 * All implementations of the Singleton have these two steps in common:
 * <p>
 * Make the default constructor private, to prevent other objects from using the new operator with the Singleton class.
 * Create a static creation method that acts as a constructor. Under the hood, this method calls the private constructor
 * to create an object and saves it in a static field. All following calls to this method return the cached object.
 */
// double check lock can also be broken so to avoid this we use volatile keyword

// creating singleton using enum has thread safety, safety against serialization and deserialization, safety against cloning and even reflection
// Singleton pattern is used to create a configuration file which is used by whole project.
/*Cache: We can use the cache as a singleton object as it can have a
global point of reference and for all future calls to the cache object the client application will use the in-memory object.
*
* */

public class Singleton implements Cloneable, Serializable {

    private static volatile Singleton singleton = null;

    private Singleton() {
        // for reflection
        if (singleton != null) {
            throw new RuntimeException("can not create, Please call getInstance");
        }
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                //double check lock
                //Lazy initialization
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    //for serialization and deserialization
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("... read resolve");
        return singleton;
    }

    // for protection from cloning
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] args) throws Exception {
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        System.out.println("s1 : " +s1.hashCode());
//        System.out.println("s2 : " + s2.hashCode());
//
//        //Reflection Check
//        System.out.println("Reflection Check");
//        Class c = Class.forName("DesignPattern.Singleton");
//        Constructor<Singleton> cts = c.getConstructor();
//        cts.setAccessible(true);
//        Singleton s4 = cts.newInstance();
//        System.out.println("s4 : " + s4.hashCode());
//
//         //Serialization check
//        System.out.println("Serialization and Deserialization");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/s2.ser"));
//        oos.writeObject(s2);
//        oos.close();
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/s2.ser"));
//        Singleton s3 = (Singleton)ois.readObject();
//        System.out.println(" s3 : " + s3);
//
//        //For multithreaded we use synchronized block and double check lock
        ExecutorService eService = Executors.newFixedThreadPool(2);
        eService.submit(Singleton::getInstance);
        eService.submit(Singleton::getInstance);
        eService.shutdown();

        //Using enum creating singleton

        SingleTonEnum singleTonEnum1 = SingleTonEnum.INSTANCE;
        SingleTonEnum singleTonEnum2 = SingleTonEnum.INSTANCE;
        System.out.println("Singleton1 using enum :" + singleTonEnum1.hashCode());
        System.out.println("Singleton2 using enum :" + singleTonEnum2.hashCode());


    }

}
