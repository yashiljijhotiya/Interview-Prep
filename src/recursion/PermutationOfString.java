package recursion;

import java.util.Arrays;

/* Backtracking problem : ABC = {ABC, ACB, BAC, CAB,BCA,CBA} i.e. 3! = 6
TC : O(n*n!)
* */
public class PermutationOfString {

    private static  void printAllPermutation(String str){
     char arr[] = str.toCharArray();
     char result[] = new char[arr.length];
     int count [] = new int[arr.length];
     Arrays.fill(count,1);
     permutationUtil(arr,result,count,0);
    }

    private static void permutationUtil(char [] input, char [] result, int [] count, int level){
        if(level == input.length){
            for(char c: result){
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        else {
            for(int i = 0; i < input.length; i++){
                if(count[i] == 0){
                    continue;
                }
                else {
                    result[level] = input[i];
                    count[i]--;
                    permutationUtil(input,result,count,level + 1);
                    count[i]++;
                }
            }
        }
    }

    //n*n!
    private static void permutations(char [] arr, int len){
        if(len == 1){
            System.out.println(arr);
            return;
        }
        else {
            for(int i = 0; i < len; i++){
                swap(arr,i, len-1);
                permutations(arr, len-1);
                swap(arr, i, len-1);
            }
        }
    }

    private static void swap(char [] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "AABC";
        //printAllPermutation(str);
        permutations(str.toCharArray(), str.length());
    }
}
