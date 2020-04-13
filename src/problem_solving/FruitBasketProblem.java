package problem_solving;

import java.util.HashMap;
import java.util.Map;
/*Leetcode 904 Fruit Into Baskets
@author Yashil (14-04-20)
* */
public class FruitBasketProblem {

    private static int maxFruitCollected(int fruits[]){
        int maxFruitCollected = 0, end,  start =0;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(end = 0; end < fruits.length; end++){
            frequencyMap.put(fruits[end], frequencyMap.getOrDefault(fruits[end],0) +1);

            while(frequencyMap.size() >= 3){
                frequencyMap.put(fruits[start], frequencyMap.get(fruits[start])-1);
                if(frequencyMap.get(fruits[start]) == 0){
                    frequencyMap.remove(fruits[end]);
                }
                start++;
            }

            maxFruitCollected = Math.max(maxFruitCollected, end-start+1);
        }

        return maxFruitCollected;
    }
    public static void main(String[] args) {
        int fruits [] = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("total fruits collected in the basket are : "+ maxFruitCollected(fruits));

    }
}
