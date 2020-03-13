package streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperation {

    static class  Employee{
        private int id;
        private String name;
        private double salary;
        private String dept;
        private boolean isActive;

        public  Employee(int id, String name, double salary, String dept, boolean isActive) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.dept = dept;
            this.isActive = isActive;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

    }

    public static void main(String[] args) {

        //These all operations performed on int arr
        int arr[] = {3,1,2,5,11,19,44,6,33,99,8,104,4,23};
        Arrays.stream(arr).filter(n -> n%2 == 0).forEach(i -> System.out.println(i));


        //min of numbers
        // throw an error if array is empty
        int min = IntStream.of(arr).min().getAsInt();
        System.out.println("min of numbers is :" +min);

        // for handling empty case use ifPresent()
        IntStream.of(arr).min().ifPresent(val -> System.out.println(val));

        /* similar to min() there are other functions as well like
        -> max()
        -> average()
        -> count()
        -> sum()
        * */

        // this summaryStatistics provide all the above mention functions like min(), average() etc in single object, so if we want all calculation in
        //single operation we can use summaryStatistics()
        IntSummaryStatistics summaryStatistics = IntStream.of(arr).summaryStatistics();
        System.out.println("avg of numbers are : " +summaryStatistics.getAverage());

        // to find k distinct smallest element in an array
        // eg for 3 smallest distinct
        IntStream.of(arr)  //create the stream
                .distinct() /* process the stream*/
                .sorted()
                .limit(3).forEach(System.out :: println); // consume the stream

        IntStream.of(arr).anyMatch(num -> num == 1); // written boolean
        IntStream.of(arr).allMatch(num -> num == 1);


        // operation on objects
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "yashil", 96442, "IT", true));
        employeeList.add(new Employee(2, "peter", 57899, "HR", true));
        employeeList.add(new Employee(3, "Alice", 89665, "IT", false));


        // Top 2 highest salary
        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // we can use custom comparator to sort and collect in any format
                .limit(2)
                .map(Employee::getName)
                .forEach(System.out::println);

        List<String> emp =  employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .filter(e -> e.isActive)
                .limit(2)
                .map(Employee::getName)
                .collect(Collectors.toList());

        // joining names separated by comma
        String names = employeeList.stream()
                     .limit(2)
                     .map(Employee::getName)
                      .collect(Collectors.joining(", " ));

        // group by dept
        Map<String, List<Employee>> empByDept = employeeList.stream().collect(Collectors.groupingBy(e -> e.dept));

        // count emp in each dept
        Map<String, Long> deptCounts = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

        // use this parallel function when we have more records greater than 1000 say, so it will  divide the task among the thread
        Map<String, List<Employee>> empByDep = employeeList.stream().parallel().collect(Collectors.groupingBy(e -> e.dept));

        // ***** Don't concurrently modify the source of stream
    }
}
