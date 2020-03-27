package arrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArrays {

    private static void findIntersection(int arr1[], int arr2[]){
        if((arr1 == null || arr1.length == 0) && (arr2 == null || arr2.length == 0)){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int j : arr2){
            if(set.contains(j)){
                System.out.println(j);
            }
        }
    }

    

    public static void main(String[] args) {
        int arr1[] = {1,3,2,4,11,19,21,15,7};
        int arr2[] = {5,19,4,3,11,2,1};
        findIntersection(arr1,arr2);
    }
}
