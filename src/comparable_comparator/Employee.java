package comparable_comparator;

import java.util.*;

public class Employee implements  Comparable<Employee> {

    int ID;
    String Name;
    double Salary;
    String DOB;

    public Employee(int ID, String name, double salary, String DOB) {
        this.ID = ID;
        Name = name;
        Salary = salary;
        this.DOB = DOB;
    }

    @Override
    public int compareTo(Employee o) {
        return this.Name.compareTo(o.Name);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public double getSalary() {
        return Salary;
    }

    public String getDOB() {
        return DOB;
    }

    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee(62, "Yashil", 86000, "1993-06-05"));
        emp.add(new Employee(17, "Biswajeet", 56000, "1993-09-21"));
        emp.add(new Employee(22, "Ashish", 49000, "1992-07-10"));
        System.out.println(emp);
        Collections.sort(emp);
         // using comparator
        Comparator<Employee> comparator = (e1, e2) ->{
            return e1.ID -e2.ID;
        };
        emp.forEach(e -> {
            System.out.println("ID :" + e.ID  + " NAME :" + e.Name + " SALARY : " + e.Salary + " DOB :" +e.DOB);
        });

    }
}
