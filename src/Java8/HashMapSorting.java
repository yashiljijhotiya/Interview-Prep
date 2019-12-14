package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSorting {

    public void sortByValue(HashMap<String,Integer> h){
        System.out.println(h);
        Map<String, Integer> result = h.entrySet().stream()
                                      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                      .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue,
                                              (oldValue, newValue)-> oldValue, LinkedHashMap:: new));

        System.out.println(result);
    }


    public static void main(String[] args) {
     //   HashMap<String, Integer> h = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(1);
        arr.add(14);
        arr.add(13);
        arr.add(91);
        arr.add(22);
        System.out.println("ArrayList without sorting :" + arr);

        var result = arr.stream().sorted().collect(Collectors.toList());

        System.out.println("ArrayList after sorting : " +result);

//        HashMapSorting hm = new HashMapSorting();
//        h.put("Yashil", 77);
//        h.put("Anchal", 80);
//        h.put("Nancy", 22);
//        h.put("Shubhi", 19);
//        System.out.println();
//        hm.sortByValue(h);

    }
}
