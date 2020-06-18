package sliding_window;
public class MaxSumOfK {

    private static int maxSumOfKSizeWindow(int arr[], int k){
        int max_sum ;
        int sum = 0;
        int len = arr.length;

        if(len < k)
            return -1;
        //sum of first window
        for(int i = 0; i < k; i++){
          sum += arr[i];
        }
        max_sum = sum;
        for(int i = k; i < len; i++){
            sum += arr[i] - arr[i-k];
            max_sum = Math.max(sum, max_sum);
        }


        return max_sum;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 200, 300, 400 };
        int k =3;
        int val = maxSumOfKSizeWindow(arr,k);
        if (val == -1) {
            System.out.println("No array is found of k size");
        } else {
            System.out.println("max sum of k size window is :" + val);
        }

    }
}
