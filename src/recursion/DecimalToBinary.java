package recursion;

public class DecimalToBinary {

    private static int decimalToBinary(int num){
        if(num == 0){
            return 0;
        }
        else {
            return (num % 2 + 10 * decimalToBinary(num/2));
        }
    }

    private static int binaryToDecimal(int binNum){
        int decVal = 0, base = 1;
        while (binNum > 0){
            int lastDigit = binNum%10;
            binNum = binNum/10;
            decVal += lastDigit * base;
            base = base * 2;
        }
        return decVal;
    }

    public static void main(String[] args) {
        int num = 9;
        System.out.println("The binary of no. is :" + num + " is "+decimalToBinary(num));
        System.out.println(binaryToDecimal(1111111));
    }
}
