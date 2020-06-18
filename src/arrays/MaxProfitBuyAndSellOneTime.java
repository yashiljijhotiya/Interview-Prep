package arrays;

public class MaxProfitBuyAndSellOneTime {

    private static  int maxProfitBySelling(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            else{
                max = Math.max(max, arr[i] - min);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println("max profit earn = " + maxProfitBySelling(arr));
    }
}
