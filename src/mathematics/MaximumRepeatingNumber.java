package mathematics;

public class MaximumRepeatingNumber {

    private static int maxRepeating(int arr[], int n, int k){
        for (int i = 0; i< n; i++)
            arr[(arr[i]%k)] += k;

        int result = 0, max = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,3};
        int n = arr.length;
        int k=3;
        System.out.println("Maximum repeating element is: " +
                maxRepeating(arr,n,k));
    }
}
