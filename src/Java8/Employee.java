package Java8;

public class Employee {

    public int id;
    public String name;
    public int salary;
    //public enum department {HR, ENGINEERING, Manager};
    public String position;

    public int getId() {
        return id;
    }

    public Employee(int id, String name, int salary, String position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    public String getPosition() {
        return position;
    }


    @Override
    public  String toString(){
        return ""+id+""+name+""+salary+""+ position+"";
    }
}
