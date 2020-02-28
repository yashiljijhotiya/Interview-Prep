package problem_solving;

import java.util.HashMap;
import java.util.PriorityQueue;

//Leetcode
public class TaskScheduler {

    private static int leastInterval(String s, int n){
      int cycles = 0;
      char chArr[] = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : chArr){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.addAll(map.values());



        return cycles;
    }

    public static void main(String[] args) {
        String s = "AAABBB";
        System.out.println(leastInterval(s,2));
    }
}
