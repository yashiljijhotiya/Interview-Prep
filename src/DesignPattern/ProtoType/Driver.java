package DesignPattern.ProtoType;

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
