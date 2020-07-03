package mathematics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* TC : O(n^2)
* */
public class PythagorasTriplet {

    private static List<int[]> findAllTriplet(int arr[]){
        if(arr == null || arr.length < 3){
            return new ArrayList<>();
        }
        List<int[]> result = new ArrayList<>();
        int len = arr.length;

        for(int i = 0; i < len; i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr);
        for(int i = len-1; i >= 2; i--){
            int l = 0;
            int r = i - 1;
            while (l < r){
                if(arr[l] + arr[r] == arr[i]){
                    result.add(new int []{arr[l], arr[r], arr[i]});
                }
                else if(arr[l] + arr[r]  < arr[i]){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return result;
    }

  public static void main(String[] args) {
    int arr[] = {3,1,4,6,5};
    System.out.println(findAllTriplet(arr));
  }
}
