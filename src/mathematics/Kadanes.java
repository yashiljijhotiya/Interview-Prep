package mathematics;

public class  Kadanes {

    private static int maxSumSubArr(int num[]){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i =0; i < num.length; i++){
            currSum += num[i];
            maxSum = Math.max(currSum,maxSum);
            currSum = Math.max(currSum, 0);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int num[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumSubArr(num));
    }
}
