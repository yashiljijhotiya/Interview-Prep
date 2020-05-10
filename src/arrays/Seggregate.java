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
        if(arr == null || arr.length == 1)
            return;
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                ArrayUtils.swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                ArrayUtils.swap(arr, i, high);
                high--;
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
