package String;
/*Approach : Using expand from center to both side i.e.(left, right) of string
* */
public class LongestPalindromicSubstring {

    private static String findLongestPalindromicSubstring(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for(int i =0; i < s.length(); i++){
            // for handling baab case
            int length1 = expandFromCenter(s, i, i+1);
            // for handling bab case
            int length2 = expandFromCenter(s, i, i);
            int length = Math.max(length1, length2);
            if(end - start < length){
                start = i -(length -1)/2;
                end = i + length/2;
            }
        }
        return s.substring(start, end+1);
    }

    private static  int expandFromCenter(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }



    public static void main(String[] args) {
        String s = "pabbawa";
        System.out.println(findLongestPalindromicSubstring(s));
    }
}
