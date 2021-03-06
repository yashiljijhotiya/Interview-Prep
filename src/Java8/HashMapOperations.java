package Java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class HashMapOperations {

    public static void main(String[] args) {
        Employee ey = new Employee(17, "Yashil", 170000, "Fullstack developer");
        Employee ea = new Employee(21, "Abinash", 63000, "Tester");
        Employee eb = new Employee(13, "Biswajeet", 61000, "Web developer");
        Employee es = new Employee(7, "Shahi", 60000, "Backend developer");

        HashMap<Integer, Employee> map = new HashMap<>();
        map.put(ey.id, ey);
        map.put(es.id, es);
        map.put(ea.id, ea);
        map.put(eb.id, eb);
        Map<Integer, Employee> sortedmap = map.entrySet().stream().
                   collect(Collectors.toMap(k -> k.getKey(), e -> e.getValue())).entrySet().stream().sorted(Map.Entry.comparingByKey()).
                   collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
        sortedmap.forEach((k,v) -> System.out.println(k + " : " + v));

        /*steps to sort map :- 1-> convert it to list.
        //2 -> sort list.
        3. -> Again put back list to new map. */

        List<Map.Entry<Integer,Employee>> mapList = new LinkedList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<Integer, Employee>>() {
            @Override
            public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
       //java 8
        mapList.stream().sorted((o1 , o2) -> o1.getValue().getName().compareTo(o2.getValue().getName()));

        //Comparing on multiple field
//        Collections.sort(mapList, Comparator.comparing(Map.Entry<Integer, Employee> ::)
//                     .thenComparing(Employee::getName)
//                      .thenComparing(Employee::getSalary));

        HashMap<Integer,Employee>sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,Employee> entry : mapList){
            sortedMap.put(entry.getKey(),entry.getValue());
        }

        System.out.println("sorted map : " +sortedMap);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(ey);
        list.add(ea);
        list.add(es);
        list.add(eb);

        // for sorting list on various Comparator
        Comparator<Employee> nameComparator = (e1, e2) -> {
            return e1.getName().compareTo(e2.getName());
        };

        Comparator<Employee> salaryComparator = (e1, e2) -> {
            return e1.salary - e2.getSalary();
        };

        Comparator<Employee> positionComparator = (e1, e2) -> {
            return e1.getPosition().compareTo(e2.getPosition());
        };

        Collections.sort(list, nameComparator);
        Collections.sort(list, positionComparator);
        Collections.sort(list, salaryComparator);

        list.forEach(val -> {
            System.out.println("Id: " + val.getId() + "name: " + val.getName() + "salary :" + val.getSalary() + "posistion : " + val.getPosition());
        });

        TreeMap<Employee, Integer> treeMap = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        treeMap.put(ey, ey.id);
        treeMap.put(es, es.id);
        treeMap.put(eb, eb.id);
        treeMap.put(ea, ea.id);


        System.out.println("treemap : " + treeMap);

        //pq sorted by name
        PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
        pq.add(ey);
        pq.add(eb);
        pq.add(es);
        pq.add(ea);
        //System.out.println("priority queue : " +pq);


    }
}
