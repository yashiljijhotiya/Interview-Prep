package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/***
 *  Leetcode: 1488
 * */
public class AvoidFlood {

    private static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> rainMap = new HashMap<>();
        TreeSet<Integer> drySet = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            int val = rains[i];
            if (val == 0) {
                drySet.add(i);
            } else {
                Integer alreadyRain = rainMap.get(val);
                if (alreadyRain == null) {
                    rainMap.put(val, i);
                } else {
                    Integer dryThisDay = drySet.higher(alreadyRain);
                    if(dryThisDay == null){
                        // lakes flooded
                        return new int[0];
                    }
                    result[dryThisDay] = val;
                    drySet.remove(dryThisDay);
                    rainMap.put(val, i);
                }
                result[i] = -1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int [] rains = {};

    }
}
