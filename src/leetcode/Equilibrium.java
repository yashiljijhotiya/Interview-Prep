package leetcode;
/* to find equilibrium point in array where at that particular point left sum is equal to right sum
* */

public class Equilibrium {

    private static int findEquilibriumPoint(int arr[]){
        //if length is 2 not possible to find equilibrium point
        if(arr == null || arr.length == 0){
            return  -1;
        }

        int sum = 0, leftsum = 0;
        for (int i = 0; i < arr.length; ++i)
            sum += arr[i];

        for (int i = 0; i < arr.length; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(findEquilibriumPoint(arr));

    }
}
