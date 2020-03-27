package String;
// Leetcode : approach first reverse the whole string than reverse each individual word
public class ReverseWord {

    private static String reverseWord(String str){
        if(str == null || str.length() == 0){
            return " ";
        }
        char arr[] = str.toCharArray();
        reverse(arr,0, arr.length-1);
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' '){
                reverse(arr,start,i-1 );
                start = i+1;
            }
        }
        String s = new String(arr);
        return s;
    }

    private static void  reverse(char arr[], int l, int r){
        while(l < r){
            char temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        String str = "ALL IS WELL";
        System.out.println(reverseWord(str));

    }
}
