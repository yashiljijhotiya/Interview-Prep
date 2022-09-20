package mathematics;

import java.util.Arrays;

/**
 * Leetcode: 31
 * Approach:-{1,1,5,4,1}
 * Find the position of no. from end which will be the first decreasing sequence from end. 1st index in the above eg
 * Find the next greater no. for substitution of this no. from end. is 4
 * After substitution reverse the array after that substitution point. reverse from 2nd index
 */
public class NextPermutation {

    private static void findNextPermutation(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void main(String[] args) {
        int num[] = {1, 1, 5, 4, 1};
        findNextPermutation(num);
    }
}
