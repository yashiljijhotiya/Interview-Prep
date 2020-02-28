package leetcode;

import java.util.PriorityQueue;

public class ConnectSticks {

    private static int minCostCombineStick(int sticks[]) {
        int cost = 0;
        int len = sticks.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (len == 0 || sticks == null) {
            return 0;
        }
        for (int stick : sticks) {
          minHeap.add(stick);
        }

        while(minHeap.size() > 1){
            int sum = minHeap.remove() + minHeap.remove();
            cost += sum;
            minHeap.add(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        int sticks[] = {1, 8, 3, 5};
        System.out.println("min cost to connect all  sticks are :" + minCostCombineStick(sticks));
    }
}
