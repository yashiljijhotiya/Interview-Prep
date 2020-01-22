package arrays;

public class Seggregate {

    private static void segregateZeroOne(int arr[]){
        if(arr == null || arr.length == 1){
            return;
        }

        int left = 0, right = arr.length-1;
        System.out.println("array before segregation");
        print(arr);

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
        print(arr);
    }

    private static void segregateZeroOneTwo(int arr[]){
        if(arr == null || arr.length == 1)
            return;
        int low = 0, mid = 0, high = arr.length-1;
        System.out.println("array before segregation");
        print(arr);
        while (mid < high){
            switch (arr[mid]){
                case 0:
                    if(arr[low] != arr[mid]){
                        int temp = arr[low];
                        arr[low] = arr[mid];
                        arr[mid] = temp;
                    }
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    if(arr[mid] != arr[high]){
                        int temp = arr[mid];
                        arr[mid] = arr[high];
                        arr[high] = temp;
                    }
                    high--;
            }
        }
        System.out.println("array after segregation");
        print(arr);

    }

    private static void print(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int zeroOne[] = {1,0,0,0,1,0,0,1,0,1,1,0,1,0};
        int zOT[] = {1,2,2,1,0,2,0,0,1,2,0,1,1};
        segregateZeroOne(zeroOne);
        segregateZeroOneTwo(zOT);


    }
}
