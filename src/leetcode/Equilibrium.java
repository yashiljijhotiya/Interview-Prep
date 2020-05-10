package leetcode;
/* to find equilibrium point in array where at that particular point left sum is equal to right sum
* */

public class Equilibrium {

    private static int findEquilibriumPoint(int arr[]){
        int equilibriumPoint = -1;
        //if length is 2 not possible to find equilibrium point
        if(arr == null || arr.length == 0 || arr.length == 2){
            return  -1;
        }
        // the zeroth index will be equilibrium point
        else if(arr.length == 1){
            return 0;
        }

        int sum [] = new int[arr.length];
        int total = 0;
        for(int i = 0; i < arr.length;i++){
            total += arr[i];
            sum[i] = total;
        }
        int leftSum, rightSum;
        for(int i = 1; i < arr.length-1; i++){
            leftSum = sum[i]-arr[i];
            rightSum = sum[sum.length-1]-sum[i];
            if(leftSum == rightSum){
                equilibriumPoint = i;
                break;
            }
        }
        return equilibriumPoint;
    }
    public static void main(String[] args) {

    }
}
