package arrays;

public class Seggregate {

    private static void segregateZeroOne(int arr[]){
        if(arr == null || arr.length == 1){
            return;
        }

        int left = 0, right = arr.length-1;
        System.out.println("array before segregation");
        ArrayUtils.print(arr);

        while (left < right){
            while (arr[left] == 0 && left < right){
                left++;
            }
            while (arr[right] == 1 && left < right){
                right--;
            }
            if(left < right){
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        System.out.println("array after segregation ");
        ArrayUtils.print(arr);
    }

    private static void segregateZeroOneTwo(int arr[]){
        if(arr == null || arr.length <= 1)
            return;
        int left = 0, mid = 0, right = arr.length - 1;
         while (mid <= right) {
            if (arr[mid] == 0) {
                ArrayUtils.swap(arr, mid, left);
                mid++;
                left++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                ArrayUtils.swap(arr,mid, right);
                right--;
            }
        }
        ArrayUtils.print(arr);

    }


    public static void main(String[] args) {
        int zeroOne[] = {1,0,0,0,1,0,0,1,0,1,1,0,1,0};
        int zOT[] = {1, 0, 2, 1, 0 };
        segregateZeroOne(zeroOne);
        segregateZeroOneTwo(zOT);
    }
}
