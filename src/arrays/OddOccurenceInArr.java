package arrays;

public class OddOccurenceInArr {

    private static int findOddOccurence(int arr[]){
        if(arr.length == 0 && arr == null){
            return -99999;
        }
        int res = 0;
        for(int i =0; i < arr.length; i++){
            res = res^arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,2,7,5,3,1,2};
        System.out.println(findOddOccurence(arr));
    }
}
