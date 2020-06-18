package mathematics;

import java.util.Arrays;
/* TC : O(n^2)*/
public class CountTriangles {

    private static int countTriangles(int arr[]){
        int n = arr.length;
        if(n < 3 || arr == null){
            return 0;
        }
        int count = 0;
        Arrays.sort(arr);
        for(int i = n-1; i >= 1; i--){
            int l = 0, r = i-1;
            while (l < r){
                if(arr[l] + arr[r] > arr[i]){
                    count += r - l;
                    r--;
                }
                else {
                    l++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println("total no. of triangles formed are :" + countTriangles(arr));
    }
}
