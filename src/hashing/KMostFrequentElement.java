package hashing;

import java.util.*;
//Find k numbers with most occurrences in the given array gfg
public class KMostFrequentElement {

    private static  void printKFrequentElem(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        if(len < k){
            System.out.println("not possible to print k frequent element");
            return;
        }
        for(int i = 0; i < len; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else {
                map.put(arr[i], map.get(arr[i]) +1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int n = 0;
        for(Map.Entry<Integer, Integer> entry :list ){
          if(n < k) {
              System.out.println(entry.getKey() +" -> " + entry.getValue());
          }
          n++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        printKFrequentElem(arr,k);
    }
}
