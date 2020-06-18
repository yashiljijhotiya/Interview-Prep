package String;

public class MinCharToPallindrome {

    private static void minCharReplacement(String s){
        int len = s.length();
        if(s == null || len == 0){
            return;
        }
        int count = 0;
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) == s.charAt(len-i-1)){
                continue;
            }
            count++;
            if(s.charAt(i) < s.charAt(len - i - 1)){
                s = s.replace(s.charAt(len - i -1), s.charAt(i));
            }
            else {
                s = s.replace(s.charAt(i), s.charAt(len - i - 1));
            }
        }

        System.out.println("min no. of character replace to make string palindrome are : " + count + s);
    }
    public static void main(String[] args) {
        String s = "tesyut";
        minCharReplacement(s);
    }
}
