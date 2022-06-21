package dp.leetcode;

/**
 * Leetcode : 983
 */
public class TicketMinCost {

    private static int finMinCostRec(int currentDay, int[] days, int[] costs) {
        int result = Integer.MAX_VALUE;
        if (currentDay > days[days.length - 1]) {
            return 0;
        }
        if (willTravelToday(currentDay, days)) {
            result = finMinCostRec(currentDay + 1, days, costs) + costs[0]; // 1 day pass cost
            result = Math.min(result, finMinCostRec(currentDay + 7, days, costs) + costs[1]); // 7 day pass cost
            result = Math.min(result, finMinCostRec(currentDay + 30, days, costs) + costs[2]); // 30 day pass cost
        } else {
            return finMinCostRec(currentDay + 1, days, costs);
        }
        return result;
    }


    private static int findMinCost(int[] days, int[] cost) {
        int[] dp = new int[400];// last day in days array will represent max day + 30 +1
        for (int cDay = days[days.length-1]; cDay >= 1; cDay--) {
            int min = Integer.MAX_VALUE;
            if (willTravelToday(cDay,days)) {
                min = dp[cDay + 1] + cost[0];
                min = Math.min(min, dp[cDay + 7] + cost[1]);
                min = Math.min(min, dp[cDay + 30] + cost[2]);
                dp[cDay] = min;
            } else {
                dp[cDay] = dp[cDay + 1];
            }
        }
        return dp[1];
    }


    private static boolean willTravelToday(int currentDay, int[] days) {
        for (int i = 0; i < days.length; i++) {
            if (currentDay == days[i]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int cost[] = {2,7,15};
        int days[] = {1,4,6,7,8,20};
        System.out.println(findMinCost(days,cost));
    }
}
