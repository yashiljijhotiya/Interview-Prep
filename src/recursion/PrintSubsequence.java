package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {

    private static void printSubsequence(Integer arr[], int n) {
        List<Integer> subSequence = new ArrayList<>();
        subsequenceUtil(arr, n, subSequence, 0);
    }

    private static void subsequenceUtil(Integer arr[], int n, List<Integer> subsequence, int idx) {
        if (idx == n) {
            for (int i : subsequence) {
                System.out.print(i);
            }
            if (subsequence.size() == 0) {
                System.out.println("{}");
            }
            System.out.println();
            return;
        }
        subsequence.add(arr[idx]);
        subsequenceUtil(arr, n, subsequence, idx + 1);
        subsequence.remove(arr[idx]);
        subsequenceUtil(arr, n, subsequence, idx + 1);
    }


    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        printSubsequence(arr, arr.length);
    }
}
