package arrays;

public class MedianTwoSortedArray {

    //Time complexity : O(n)
    private static int median(int arr1[], int arr2[]){
       int i = 0, j = 0, m1 = -1, m2 = -1;
       int n = arr1.length;
       for(int k = 0; k <= n; k++ ){
           if(i == n){
               m1 = m2;
               m2 = arr2[0];
               break;
           }
           else if(j == n){
               m1 = m2;
               m2 = arr1[0];
               break;
           }
           else if(arr1[i] < arr2[j]){
               m1 = m2;
               m2 = arr2[j];
               i++;
           }
           else {
               m1 = m2;
               m2 = arr2[j];
               j++;
           }
       }

       return (m1+m2)/2;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        System.out.println(median(arr1,arr2));
    }
}
