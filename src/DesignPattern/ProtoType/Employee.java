package DesignPattern.ProtoType;

public class Employee implements Prototype {
    private int id;
    private String name;
    private String email;

    public Employee() {
    }

    public Employee(int id, String name, String email) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void showRecord() {
        System.out.println(id + "\t" + name + "\t" + "\t" + email + "\t");
    }

    @Override
    public Prototype clone() {
        return new Employee(id, name, email);
    }

}
