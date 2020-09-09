package String;
import java.util.*;

public class Anagram {

    public static  int MAX_SIZE = 128;

    private boolean isAnagram (String s1, String s2){
        int arr[] = new int[MAX_SIZE];
        if(s1 == null && s2 == null || s1.length() != s2.length()){
            return  false;
        }
        for (int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }
       return true;

    }

    private static boolean isAnagramByXOR(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        else{
            int result = 0;
            for(int i = 0; i < str1.length(); i++){
                result = result ^ (int)str1.charAt(i);
                result = result ^ (int) str2.charAt(i);
            }

            //System.out.println(result);

            return result == 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        if(isAnagramByXOR(s1, s2))
            System.out.println("is anagram");
        else
            System.out.println("is not anagram");


    }
}
