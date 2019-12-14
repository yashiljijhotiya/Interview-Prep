package interview_question;

import java.util.*;

public class SearchQuery {

    private static void searchTopN(ArrayList<String> list){
        Map<String, Integer> tm = new TreeMap<>();
        Map<String, Integer> stm = new TreeMap<>();
         for(int i = 0; i < list.size(); i++){
             String s = list.get(i);
             int n = s.length();
             var top = s.charAt(n-1);
             System.out.println(s.charAt(n-1));
//             for (int j = 0; j < s.length(); j++ ){
//
//             }
//             int n = s.length();
//             var top = s.charAt(n-1);
//             int topValue =  Integer.parseInt(top.replaceAll("[^0-9]", ""));
//             if(!tm.containsKey(s.charAt(i))){
//                 tm.put(s.charAt(i),1);
//             }
//             else {
//                 tm.put(str[i], tm.get(str[i])+1);
//             }
         }
//        int n = str.length;
//        var top = str[n-1];
//        int topValue =  Integer.parseInt(top.replaceAll("[^0-9]", ""));
//        System.out.println(topValue);
//        for(int i = 0; i < str.length-1; i++){
//            if(!tm.containsKey(str[i])){
//                tm.put(str[i],1);
//            }
//            else {
//               tm.put(str[i], tm.get(str[i])+1);
//            }
//        }
        System.out.println(tm);
       // stm.putAll(tm);
//        var sortedMap = sortByValues(tm);
//        System.out.println(sortedMap);

    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String s1 = "java test test cat dog cat movie cat top3";
        list.add(s1);
     String [] str = {"java", "test", "test", "cat", "dog", "cat", "movie", "cat", "top10"};
     searchTopN(list);
    }
}
