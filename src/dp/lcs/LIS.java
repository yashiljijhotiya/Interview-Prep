package dp.lcs;

public class LIS {

    private static int LIS(int [] arr, int size){
        if(size <= 1){
            return size;
        }
        int maxLen = 1;
        for(int i = 1; i < size; i++){
            int tempLen = LIS(arr, i);
            int start = i-1, end = size-1;
            if(arr[start] < arr[end] && tempLen + 1 > maxLen){
                maxLen = tempLen+1;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {

    }
}
