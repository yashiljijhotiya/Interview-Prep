package binarySearch;

/**
 * If while doing partition ie cut1 and cut2 if we are not taking any elements from any
 * array than we have to assign Min or max val to l1, l2 -> Integer_MIN or r1, r2 ->  Integer_Max
 **/
public class MedianInTwoSortedArrOfDiffLength {

    private static double findMedian(int arr1[], int arr2[]) {
        if (arr1.length < arr2.length) {
            return findMedian(arr2, arr1);
        }
        double result = 0.0;
        int len1 = arr1.length, len2 = arr2.length;
        int low = 0, high = len1;

        while (low <= high) {
            int partition1 = (low + high) >> 1;
            int partition2 = (len1 + len2) / 2 - partition1;

            int left1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int left2 = partition2 == 0 ? Integer.MAX_VALUE : arr2[partition2 - 1];

            int right1 = partition1 == len1 ? Integer.MAX_VALUE : arr1[partition1];
            int right2 = partition2 == len2 ? Integer.MAX_VALUE : arr2[partition2];


            if (left1 <= right2 && left2 <= right1) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;

                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {};
        int arr2[] = {};

    }
}
