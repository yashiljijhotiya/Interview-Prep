package interview_question;

import java.util.HashSet;
import java.util.Set;

public class Groupon {

    private static String replaceVowels(String s){
        Set<Character> lookup = new HashSet<>();
        lookup.add('a');
        lookup.add('e');
        lookup.add('i');
        lookup.add('o');
        lookup.add('u');
        if(s.isEmpty() || s == null){
            return s;
        }
        String words[] =  s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            String v = processWord(word,lookup);
            result.append(v);
        }

     return result.toString();
    }

    private static String processWord(String s, Set<Character> lookup){
        int left = -1, right = -1, prev = -1;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(lookup.contains(arr[i])){
                if(left == -1){
                    left = i;
                    prev = i;
                }
                else if(right == -1){
                    right = i;
                }
                if(right != -1 && left != -1){
                    swap(arr,left,right);
                    left = -1;
                    right  = -1;
                }
            }
        }
        if(left != -1 && right == -1){
            arr[left] = arr[prev];
        }
        for(int i = 0; i < arr.length; i++){
           System.out.print(arr[i]);
        }
        System.out.print(" ");
        return arr.toString().trim();
    }

    private static void swap(char arr[], int left , int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }



  public static void main(String[] args) {
    //
      String s = "i love groupon";//" i levo gruopon "
      replaceVowels(s);
  }
}
