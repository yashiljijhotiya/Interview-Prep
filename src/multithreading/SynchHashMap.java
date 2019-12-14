package multithreading;

import java.util.*;

public class SynchHashMap {


    public static void main(String[] args) {
        Map<Integer, String> hm = Collections.synchronizedMap(new HashMap<>());
        hm.put(2, "Anil");
        hm.put(44, "Ajit");
        hm.put(1, "Brad");
        hm.put(4, "Sachin");
        hm.put(88, "XYZ");
        Set s = hm.entrySet();
        Iterator itr = s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
