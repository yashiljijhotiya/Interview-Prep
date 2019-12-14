package sliding_window;

public class SumOfAllKElement {

    private  static void printSumOfAllKWindow(int arr[], int k){
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i <= n-k+1; i++){
            if(i < k){
                sum += arr[i];
                if(i == k-1)
                    System.out.println(sum);
            }

            else {
                sum += arr[i] - arr[i-k];
                System.out.println(sum);
            }
        }



    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        printSumOfAllKWindow(arr,2);

    }
}
