package binarySearch;

//
public class MinInRotatedArray {

    private static int findMin(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] >= arr[left] && arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));

    }
}
