package recursion;

import java.util.*;

/*TC: O (K^n)
* */
public class MobileKeypad {

    static Map<String, String> keypadMap;

    private static List<String> findAllCombination(String digits){
        keypadMap = new HashMap<>();
        keypadMap.put("2","abc");
        keypadMap.put("3","def");
        keypadMap.put("4","ghi");
        keypadMap.put("5","jkl");
        keypadMap.put("6","mno");
        keypadMap.put("7","pqrs");
        keypadMap.put("8","tuv");
        keypadMap.put("9","wxyz");
       List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        Deque<String> deque = new ArrayDeque<>();
        deque.add("");
        for (int i = 0; i < digits.length(); i++){
            String d = digits.substring(i, i+1);
            String keypadVal = keypadMap.get(d);
            int size = deque.size();
            for (int j = 0; j < size; j++){
                String dequeElement = deque.pollFirst();
                for(int k = 0; k < keypadVal.length(); k++){
                    String val = dequeElement.concat(keypadVal.charAt(k) + "");
                    deque.add(val);
                }
            }
        }

        while (!deque.isEmpty()){
            result.add(deque.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(findAllCombination(digits).toString());

    }
}
