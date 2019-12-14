package Java8;

import javafx.print.Collation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMapOperations {

    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"Yashil");
        hm.put(2,"Shubhi");
        hm.put(3,"test");
        System.out.println("entrySet using Java 8");
        hm.forEach((k,v) -> System.out.println(k + " : " +v));
        System.out.println("entrySet using without Java 8");
        for(Map.Entry<Integer,String> entry : hm.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("KeySet eg:");
        Set<Integer> set = hm.keySet();
        System.out.println(set);
        System.out.println("values eg:");
        Collection<String> values  = hm.values();
        System.out.println(values);

    }
}
