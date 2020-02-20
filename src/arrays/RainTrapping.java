package arrays;

public class RainTrapping {

    private static  void trapWater(int arr[]){
        int totalWater = 0;
        int len = arr.length;
        int [] leftHeight = new int[len];
        int [] rightHeight = new int [len];
        leftHeight[0]  = arr[0];
        for(int i = 1; i < len; i++){
            leftHeight[i] = Math.max(leftHeight[i-1], arr[i]);
        }
        rightHeight[len-1] = arr[len-1];
         for(int i = len-2; i >= 0; i--){
             rightHeight[i] = Math.max(rightHeight[i+1], arr[i]);
         }
        System.out.println("left height");
         for(int i = 0; i < len; i++){
             totalWater += Math.min(leftHeight[i], rightHeight[i])-arr[i];
             System.out.println(rightHeight[i]);
         }

        System.out.println("total water collected is : " + totalWater);

    }
    public static void main(String[] args) {
      int arr[] = {3,0,0,2,0,4};

      trapWater(arr);
    }
}
