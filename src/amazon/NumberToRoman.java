package amazon;

import java.util.Collections;

public class NumberToRoman {

    private static String convertToRoman(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                sb.append("X");
                num -= 10;
            } else if (num >= 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else if (num >= 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num--;
            }
        }

            return sb.toString();
    }

    public static String intToRoman(int num) {
        int[] value = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] symbol = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder ans = new StringBuilder();
        for(int i=value.length-1;i>=0;i--){
            int quotient = num/value[i];
            int remainder = num%value[i];
            if(quotient>0){
                String sym = String.join("", Collections.nCopies(quotient,symbol[i]));
                ans.append(sym);
                num = remainder;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
//        int num = 1994;
//        System.out.println(num +"to roman is : " + convertToRoman(num) );
        System.out.println(intToRoman(58));

    }
}

