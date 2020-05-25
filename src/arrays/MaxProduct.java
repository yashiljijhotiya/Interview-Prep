package arrays;

public class MaxProduct {

    private static int findMaxProduct(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int maxProduct = arr[0], minVal = arr[0], maxVal = arr[0];

        for(int i = 0; i < arr.length; i++){
          if(arr[i] < 0) {
              int temp = maxVal;
              maxVal = minVal;
              minVal = temp;
          }

          minVal = Math.min(arr[i],minVal * arr[i]);
          maxVal = Math.max(arr[i], maxVal * arr[i]);

          maxProduct = Math.max(maxProduct, maxVal);
        }

        return maxProduct;

    }

    public static void main(String[] args) {
        int arr[] = {-1,-3,-10, 0,10, 6};
        System.out.println("max product of arr is :" + findMaxProduct(arr));
    }
}
