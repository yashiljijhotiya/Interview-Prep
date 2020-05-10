package dp;

public class Fibonacci {

    private static int findNthFibonacci(int n){
        if(n == 0){
            return 0;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //space optimize
    private static int findNthFib(int n){
        if(n == 0){
            return 0;
        }
        int n1 = 0, n2 =1;
        for(int i = 2; i <= n; i++){
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }

        return n2;
    }

    public static void main(String[] args) {
        System.out.println("5th fibonacci no. is : " +findNthFibonacci(5));
        System.out.println("7th fibonacci no. is : " +findNthFibonacci(7));
        System.out.println("10th fibonacci no. is : " +findNthFibonacci(10));
        System.out.println("11th fibonacci no. is : " +findNthFibonacci(11));
    }
}
