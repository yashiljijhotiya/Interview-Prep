package DesignPattern.ProtoType;
/**
 * Prototype is a creational design pattern that allows cloning objects, even complex ones, without coupling to their specific classes.
 *
 * Usage examples: The Prototype pattern is available in Java out of the box with a Cloneable interface.
 *
 * Any class can implement this interface to become cloneable.
 *
 * **/
public class Driver {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Yashil", "yashiljijhotiya@gmail.com");
        employee.showRecord();
        Employee employee1 = (Employee) employee.clone();
        employee1.showRecord();
        System.out.println(employee.hashCode());
        System.out.println(employee1.hashCode());
    }
}
