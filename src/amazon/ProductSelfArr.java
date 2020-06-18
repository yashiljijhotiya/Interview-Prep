package amazon;
import java.util.Arrays;

public class ProductSelfArr {

    private static int [] findProductExceptSelf(int arr[]){
        if(arr.length == 0 || arr == null){
            return arr;
        }
        int result[] = new int[arr.length];
        int product = 1;
        for(int i = 0; i < arr.length; i++){
            product *= arr[i];
            result[i] = product;
        }

        product = 1;
        for(int i = arr.length -1; i > 0; i--){
            result[i] = result[i-1] * product;
            product *= arr[i];
        }
        result[0] = product;
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        //1 2 6 24
        System.out.println(Arrays.toString(findProductExceptSelf(arr)));
    }
}
