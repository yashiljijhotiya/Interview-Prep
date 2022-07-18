package binarySearch;

public class SearchInRotatedArray {

    private static boolean isPresent(int arr[], int val) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] == val) {
                return true;
            }
            //sorted half
            else if (arr[low] <= arr[mid]) {
                if (val >= arr[low] && val <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (val >= arr[mid] && val <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {};
    }
}
