package problem_solving;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {

    private static  int maxBinaryGap(int n){
        String binaryStr = Integer.toBinaryString(n);
        System.out.println(binaryStr);
        int longestGap = Integer.MIN_VALUE;
        List<Integer> onesList = new ArrayList<>();
        for(int i = 0; i < binaryStr.length(); i++){
            if(binaryStr.charAt(i) == '0'){
                continue;
            }
            else{
                onesList.add(i);
            }
        }

        for(int i = 0; i < onesList.size()-1; i++){
            int dif = onesList.get(i+1) - onesList.get(i) -1;
            longestGap = Math.max(longestGap, dif);
        }
        return longestGap;

    }

    public static void main(String[] args) {

        System.out.println(maxBinaryGap(100));

    }
}
