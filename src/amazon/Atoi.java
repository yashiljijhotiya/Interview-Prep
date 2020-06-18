package amazon;
/*Leetcode 8
TC : o(n)
* */
public class Atoi {

    private static int atoi(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }

        // remove leading and trailing spaces
        str = str.trim();

        double result = 0;
        boolean isNegative = false;
        int startIndex = 0;

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                isNegative = true;
            }
            startIndex++;
        }


        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            int digitValue = str.charAt(i) - '0';
            result = result * 10 + digitValue;
        }

        if (isNegative) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {

    }
}
