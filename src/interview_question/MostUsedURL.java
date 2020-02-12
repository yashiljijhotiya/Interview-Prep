package interview_question;

import java.util.*;

public class MostUsedURL {

    private static void printMostVisitedURL(String url[]){
        if(url == null || url.length == 0)
            return;
        int len = url.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(url[i])){
                map.put(url[i], 1);
            }
            else {
                map.put(url[i], map.get(url[i]) +1);
            }
        }

        List<Map.Entry<String, Integer>> mapList = new LinkedList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return  o2.getValue() - o1.getValue();
            }
        });

        // java 8 sorting
        //mapList.stream().sorted((obj1 , obj2) -> obj1.getValue().compareTo(obj2.getValue()));
        //System.out.println(mapList);
        System.out.println(mapList.size());
        for(Map.Entry<String, Integer> val : mapList){
            System.out.println(val.getKey());
        }
    }


    public static void main(String[] args) {
        String url [] = {"https://www.hackerearth.com", "https://www.hackerearth.com",  "https://www.wikipedia.org", "https://www.google.com", "https://www.hackerearth.com", "https://www.amazon.com"
                         ,"https://www.flipkart.com", "https://www.rarecrew.com"};
        printMostVisitedURL(url);
    }
}
