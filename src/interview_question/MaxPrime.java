package interview_question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxPrime {

    private static int findMaxPrime(String s){
        if(s.length() == 0){
            return -1;
        }
        String subsequence [] = findAllSubSequence(s);
        List<Integer> decimalList = convertBinaryToDecimal(subsequence);
        Collections.sort(decimalList);
        return decimalList.get(decimalList.size() -2);
    }

    private static String[] findAllSubSequence(String s){
        if(s.length() == 0){
            String ans [] = {" "};
            return ans;
        }
        String smallSubsequence[] = findAllSubSequence(s.substring(1));
        String result[] = new String[smallSubsequence.length*2];
        int k = 0;
        for(int i = 0; i < smallSubsequence.length; i++){
            result[k] = smallSubsequence[i];
            k++;
        }
        for(int i = 0; i < smallSubsequence.length; i++){
            result[k] = s.charAt(0)+smallSubsequence[i];
            k++;
        }

        return result;
    }

    private static List<Integer> convertBinaryToDecimal(String [] binaryArr){
        List<Integer> result = new ArrayList<>();
        for(String i : binaryArr){
            int num = Integer.parseInt(i);
            int base = 1;
            int temp = num;
            int dec = 0;
            while(num > 0){
                int lastDigit = num%10;
                temp = temp/10;
                dec += lastDigit*base;
                base = base*2;
            }
            result.add(dec);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findMaxPrime("1011"));

    }
}
