package Java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortEmployee {

    public static void printMap(Map<String,Employee> map) {
        System.out.println("**************************************");
        for (Entry<String,Employee> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + "  Values : " + "id :" + entry.getValue().id
                            + "Name :" + entry.getValue().name +
                    "salary : " + entry.getValue().salary + "position :"
                    + entry.getValue().position
                    );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        final Map<String, Employee> hm = new HashMap<String, Employee>();
        Employee e1 = new Employee(1, "Yashil", 65000,"FullStack Developer");
        Employee e2 = new Employee(2, "Mitali", 100000,"SDE2");
        Employee e3 = new Employee(7, "Anchal", 300000,"SDE3");

        hm.put("Rarecrew", e1);
        hm.put("Groupon", e2);
        hm.put("Deloitte", e3);
        System.out.println("Unsorted Map");
        printMap(hm);

    }
}
