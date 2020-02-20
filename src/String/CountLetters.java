package String;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountLetters {

    static final int noOfChar = 122;

    private static void countLetters(String s) {
        int upr = 0, lwr = 0, spl = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            var j = s.charAt(i);
            if (j >= 'A' && j <= 'Z') {
                upr++;
            } else if (j >= 'a' && j <= 'z') {
                lwr++;
            } else if (j >= '0' && j <= '9') {
                num++;
            } else {
                spl++;
            }
        }
        System.out.println("Upper case : " + upr);
        System.out.println("Lower case : " + lwr);
        System.out.println("Special character : " + spl);
        System.out.println("Numbers : " + num);
    }

    private static  String smallestWindow(String s1, String s2){
        var l1 = s1.length();
        var l2 = s2.length();
        int countChar [] = new int[noOfChar];
        String resultStr = "";
        int l = 0 ,  r = 0, count = 0,  minLength = Integer.MAX_VALUE;
        if(l1 < l2 || s1 == null || s2 == null){
            System.out.println("No such window exist");
            return "";
        }
        for(int i = 0; i < l2; i++){
            countChar[s2.charAt(i)]++;
        }
//        for (int j = 0; j < countChar.length; j++) {
//            System.out.println("index :" + j + ", val :" +countChar[j] );
//        }


        for(r = 0; r < l1; r++){
            if(--countChar[s1.charAt(r)] >= 0){
                count++;
            }
            while(count == l2){
                 if(minLength > r - l + 1){
                     minLength = r - l + 1;
                     resultStr = s1.substring(l, r + 1);
                 }
                 if(++countChar[s1.charAt(l)] > 0){
                     count--;
                 }
                 l++;
            }
        }

        if(resultStr == ""){
            System.out.println("not present!");
            return "";

        }

       return resultStr;
    }

    private static  int numSumInStr(String str){
        int len = str.length();
        int result = 0;
        String temp = "";
        if(len <= 0){
            return 0;
        }
        for(int i = 0;  i < len; i++){
            var val = str.charAt(i);
            if(Character.isDigit(val)){
                temp += val;
            }
            else{
                result += Integer.parseInt(temp);
                temp = "0";

            }
        }
        return  result + Integer.parseInt(temp);
    }

    private static  String removeAdjacentDuplicate(String  str){
      char[] arr = new char[str.length()];
      arr[0] = str.charAt(0);
      int i = 1, k = 0;
      char prev = arr[0];
      while(i < str.length()){
          if(prev != str.charAt(i)){
              arr[++k] = str.charAt(i++);
              prev = arr[k];
          }
          else{
              while(i < str.length() && prev == str.charAt(i)){
                  i++;
              }
              prev = arr[--k];
          }
      }

      return  new String(arr).substring(0, k+1);
    }

    private static  void sortString(String arr[]){
        Map<String, Integer> tm = new TreeMap<>();
        for(var s : arr){
            if(!tm.containsKey(s)){
                tm.put(s, 1);
            }
            else{
                tm.put(s, tm.get(s)+1);
            }
        }

        System.out.println(tm);
    }

    public static void main(String[] args) {
        String s = "#Ell!n$p!ron1525";
        String s1 = "this is a test string";
        String s2 = "tist";
        String numStr = "12abc20yz68";
        String s3 = "aacbccbbdb";
        //countLetters(s);
       // System.out.println(numSumInStr(numStr));
        //System.out.println(smallestWindow(s1, s2));
       // System.out.println(removeAdjacentDuplicate(s3));
        String [] str = {"java", "java", "movie", "test", "dog", "cat"};
       // sortString(str);
    }
}
