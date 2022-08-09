package problem_solving;
//leetcode
public class HouseOfRobber {

    private static int maxMoneyRobbed(int money []){
        int len = money.length;
        if(money == null || len == 0){
            return 0;
        }
        if(len == 1){
            return money[0];
        }
        if(len == 2){
            return Math.max(money[0],money[1]);
        }
        int dp[] = new int[len];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for(int i = 2; i < len; i++){
            dp[i] = Math.max(money[i]+dp[i-2], dp[i-1]);
        }

        return dp[len-1];
    }

    private static int maxMoneyRob(int nums[]){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int inc = nums[0];
        int exc = 0;
        for(int i = 1; i < n; i++){
            int newInc = nums[i] + exc;
            int newExc = Math.max(inc, exc);
            inc = newInc;
            exc = newExc;
        }

        return Math.max(inc, exc);
    }

    public static void main(String[] args) {
     int money [] = {5, 5, 10, 100, 10, 5};
        System.out.println("Max money robbed is :" + maxMoneyRob(money));
    }
}
