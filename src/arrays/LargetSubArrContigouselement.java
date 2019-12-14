package arrays;

public class LargetSubArrContigouselement {

    private static  int findLength(int arr[]){
        int max_len = 0;
      for(int i = 0; i < arr.length; i++){
          int max = arr[i], min = arr[i];
          for(int j = i+1; j < arr.length; j++){
              min = Math.min(min, arr[j]);
              max = Math.max(max, arr[j]);
              if(max - min == j-i){
                  max_len = Math.max(max_len, max - min +1);
              }
          }
      }
      return max_len;
    }
    public static void main(String[] args) {

        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        System.out.println("max len of contiguous subarray is : " +  findLength(arr));
    }
}
