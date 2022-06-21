package dp.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Leetcode: 403(Hard)
 *
 * */
public class FrogJump {

    private static boolean canCrossRiver(int stones[]){
        Map<Integer, Set<Integer>> positionMap = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            positionMap.put(stones[i], new HashSet<>());
        }
        positionMap.get(stones[0]).add(1);
        
        for(int i = 0; i < stones.length; i++){
            int currentStone = stones[i];
            Set<Integer> jumps = positionMap.get(currentStone);
            for(int jump : jumps){
                int position = currentStone + jump;
                if(position == stones[stones.length-1]){
                    return true;
                }
                if(positionMap.containsKey(position)){
                    if(jump - 1 > 0){
                        positionMap.get(position).add(jump-1);
                    }
                    positionMap.get(position).add(jump);
                    positionMap.get(position).add(jump+1);
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int [] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCrossRiver(stones));
    }
}
