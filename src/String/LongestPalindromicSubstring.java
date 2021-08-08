package String;

public class LongestPalindromicSubstring {

    private static String longestPalindromicSubstring(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
         int len1 = expandFromMid(s,i ,i);
         int len2 = expandFromMid(s, i, i+1);
         int len = Math.max(len1, len2);
         if(len > right - left){
             left = i - (len-1)/2;
             right = i + len/2;
         }
         return s.substring(left,right);
        }

        return s.substring(left,right+1);

    }

    private static int expandFromMid(String s, int l, int r){
        if(s == null || l >  r){
            return 0;
        }
        while(l >= 0 &&  r <= s.length()  && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
      String s  = "abbcb";
        System.out.println(longestPalindromicSubstring(s));
    }
}
