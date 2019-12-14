package interview_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SearchQueryResult {

    public static <String, Integer extends Comparable<Integer>> Map<String, Integer> sortByValues(final Map<String, Integer> map) {
        Comparator<String> valComparator =
                new Comparator<String>() {
                    public int compare(String k1, String k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<String, Integer> sortedByValues =
                new TreeMap<String, Integer>(valComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


    private static  void pritResult(Map<String, Integer> map, int topValue){
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(count < topValue){
                System.out.print(entry.getKey() + " ");
                count++;
            }

        }
    }

    private static void addElementInMap(String str[]){
        Map<String, Integer> map = new TreeMap<>();
        for (int i =0; i < str.length; i++){
            if(str[i].contains("top")){
                String top = str[i];
                int topValue =  Integer.parseInt(top.replaceAll("[^0-9]", ""));
                if(!map.isEmpty()){
                     Map<String, Integer> topSortedVal =  sortByValues(map);
                     pritResult(topSortedVal, topValue);
                    System.out.println();
                }
            }
            else if(!map.containsKey(str[i])){
                map.put(str[i], 1);
            }
            else {
                map.put(str[i], map.get(str[i])+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter no. of query:");
        String line = br.readLine();
        int noOfQuery = Integer.parseInt(line);

        for(int j = 0; j < noOfQuery; j++){
            System.out.println("enter length of string");
            String val = br.readLine();
            int lenOfString = Integer.parseInt(val);
            String [] str = new String[lenOfString];

            for(int i = 0; i < lenOfString; i++){
                str[i] = br.readLine();
            }
            addElementInMap(str);
        }
    }
}
