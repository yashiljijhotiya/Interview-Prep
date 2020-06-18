package amazon;

public class MedianTwoSortedArr {

    private static double findMedian(int arr1[], int arr2[]){
     if(arr1.length > arr2.length){
         return findMedian(arr2, arr1);
     }
     int x = arr1.length;
     int y = arr2.length;
     int l = 0, r = x;

     while (l <= r){
         int partitionX = (l + r)/2;
         int partitionY = (x + y + 1)/2 - partitionX;

         int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : arr1[partitionX - 1];
         int minRightX = (partitionX == x)? Integer.MAX_VALUE : arr1[partitionX];

         int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : arr2[partitionY - 1];
         int minRightY = (partitionY == y)? Integer.MAX_VALUE : arr2[partitionY];

         if(maxLeftX <= minRightY && maxLeftY <= minRightX){
             if((x+y) % 2 == 0 ){
                 return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY));
             }
             else {
                 return ((double) Math.max(maxLeftX, maxLeftY));
             }
         }
         else if(maxLeftX > minRightY){
             r = partitionX - 1;
         }
         else {
             l = partitionX + 1;
         }
     }
   throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int arr1[] = {1,3,8,9,15};
        int arr2[] = {7,11,18,19,21,25};
        System.out.println(findMedian(arr1,arr2));
    }
}
