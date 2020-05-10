package sliding_window;

import java.util.HashMap;
import java.util.Map;

/*@author: Yashil
Date: 25-04-20
leetcode : Fruit Basket problem
constraint 2 basket and each basket contains only same type of fruit
* */
public class FruitBasket {

    private static int maxFruitsCollected(String fruits){
        if(fruits == null || fruits.length() == 0){
            return 0;
        }
        int start = 0,end = 0, maxFruits = Integer.MIN_VALUE;
        Map<Character, Integer> fruitMap = new HashMap<>();
        for(end = 0; end < fruits.length(); end++){
           fruitMap.put(fruits.charAt(end),fruitMap.getOrDefault(fruitMap,0)+1);

           while(fruitMap.size() > 2){
            fruitMap.put(fruits.charAt(start),fruitMap.get(fruits.charAt(start)-1));
            if(fruitMap.get(fruits.charAt(start)) == 0){
                fruitMap.remove(fruits.charAt(start));
            }
            start++;
            }
           maxFruits = Math.max(maxFruits,end-start +1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        String fruits = "ABCAC";
        System.out.println("max fruits collected in the basket are: " +maxFruitsCollected(fruits));

    }
}
