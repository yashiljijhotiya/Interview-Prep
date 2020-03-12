package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class PartitionSumProblem {
//recursive approach T(n) = 2^n
    private static boolean isPartitonEqualSum(int arr[]){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        if(sum%2 != 0)
            return false;

        return canPartition(arr,0,0,sum);

    }

    private static boolean canPartition(int arr[], int index, int sum, int total){
        if(sum*2 == total)
            return true;
        if(sum > total/2 || index >= arr.length )
            return false;

        return canPartition(arr,index+1,sum,total) || canPartition(arr,index+1,sum+arr[index],total);
    }

// dp approach
    private  static  boolean canPartitionDp(int arr[], int index, int sum, int total, HashMap<String, Boolean> state){
        String curr = index + " " + sum;
        if(state.containsKey(curr))
            return state.get(curr);

        if(sum*2 == total)
            return true;
        if(sum > total/2 || index >= arr.length )
            return false;

        boolean foundPartition =  canPartitionDp(arr,index+1,sum,total,state) || canPartitionDp(arr,index+1,sum + arr[index], total,state);
        state.put(curr,foundPartition);
        return foundPartition;
    }

    private static void test(){
        String a = "yashil";
        String b = "nancy";
        String c = new String("hola");
        String d = new String("bhola");

        Map map = new WeakHashMap<>();

        map.put(a, new Object());
        map.put(b, new Object());
        map.put(c, new Object());
        map.put(d, new Object());

        a = null;
        b = null;
        c = null;
        d = null;

        while (true) {
            System.out.println("Size: " + map.size());
            System.gc();
//            System.out.println("Size: " + map.size());
        }
    }

    public static void main(String[] args) {
        test();
//      int arr[] = {1,5,11,5};
//        if (isPartitonEqualSum(arr)) {
//            System.out.println("Partition is Possible !!");
//        } else {
//            System.out.println("Partition is Not Possible !!");
//        }
    }
}
