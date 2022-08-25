package dp.knapsack;

import java.util.Arrays;

public class Practice {

    private static boolean subsetSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int n = arr.length;
        Boolean dp[][] = new Boolean[n + 1][target + 1];
        return subSetSumMem(arr, target, n, dp);
    }

    private static boolean equalSumPartition(int arr[]) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int sum = Arrays.stream(arr).sum();
        return (sum % 2 == 0) ? subSetSumMem(arr, sum / 2, arr.length, new Boolean[arr.length + 1][sum / 2 + 1]) : false;
    }

    private static boolean subSetSumMem(int[] arr, int target, int size, Boolean[][] dp) {
        if (target <= 0 || size == 0) {
            return target == 0;
        }
        if (dp[size][target] != null) {
            return dp[size][target];
        }
        int index = size - 1;
        if (target < arr[index]) {
            dp[size][target] = subSetSumMem(arr, target, size - 1, dp);
        } else {
            boolean withElem = subSetSumMem(arr, target - arr[index], size - 1, dp);
            boolean withoutElem = subSetSumMem(arr, target, size - 1, dp);
            dp[size][target] = withElem || withoutElem;
        }
        return dp[size][target];
    }

    private static int countSubsetSum(int[] arr, int target, int size, Integer[][] dp) {
        if (size == 0 || target == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[size][target] != null) {
            return dp[size][target];
        }
        int index = size - 1;
        if (target < arr[index]) {
            dp[size][target] = countSubsetSum(arr, target, size - 1, dp);
        } else {
            int withElem = countSubsetSum(arr, target - arr[index - 1], size - 1, dp);
            int withoutElem = countSubsetSum(arr, target, size - 1, dp);
            dp[size][target] = withElem + withoutElem;
        }
        return dp[size][target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 1, 5};
        int target = 10;
        System.out.println(subsetSum(arr, target));
    }
}
