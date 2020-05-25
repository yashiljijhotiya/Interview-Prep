package leetcode;

public class MinJump {

    private static boolean isJumpToEnd(int arr[]){
        if(arr.length == 0 || arr == null){
            return false;
        }
        int isReachable = 0;
        for(int i = 0; i < arr.length; i++){
            if(isReachable < i){
                return false;
            }
            isReachable = Math.max(isReachable, i+ arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,2,1,0,0,1,3};
        System.out.println(isJumpToEnd(arr));

    }
}
