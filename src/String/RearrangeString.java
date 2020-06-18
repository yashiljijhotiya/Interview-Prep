package String;

import java.util.*;

//No adjascent char are same
public class RearrangeString {

    private static String rearrangeStr(String str){
        if(str == null || str.isEmpty()){
            return "";
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < str.length(); i++){
            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i),0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue();
            }
        });

        queue.addAll(freqMap.entrySet());

        if(queue.peek().getValue() > (str.length() + 1)/2 ){
            return " ";
        }
        StringBuilder result = new StringBuilder();

        while (queue.size() >= 2){
            Map.Entry<Character, Integer> val1 = queue.poll();
            Map.Entry<Character, Integer> val2 = queue.poll();
            result.append(val1.getKey()).append(val2.getKey());

            if(val1.getValue() > 1){
                val1.setValue(val1.getValue() - 1);
                queue.add(val1);
            }
            if(val2.getValue() > 1){
                val2.setValue(val2.getValue() - 1);
                queue.add(val2);
            }
        }

        if(queue.size() > 0){
            result.append(queue.peek().getKey());
        }

        return result.toString();

    }
    public static void main(String[] args) {
     String str = "aabb";
        System.out.println(rearrangeStr(str));

    }
}
