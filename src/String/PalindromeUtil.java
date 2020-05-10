package String;

public class PalindromeUtil {

    private static boolean isConvertToPalindrome(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        int left = 0, right = str.length()-1, count = 0;

        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                count++;
                if(count > 1){
                    return false;
                }
                if(str.charAt(left++) == str.charAt(right)){
                    right--;
                    left++;
                }
                else if(str.charAt(left) == str.charAt(right--)){
                     left++;
                     right--;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "aacbaa";
        System.out.println(isConvertToPalindrome(str));

    }
}
