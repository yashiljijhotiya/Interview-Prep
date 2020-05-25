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

    public static void main(String[] args) {
        int num = 9;
        System.out.println("The binary of no. is :" + num + " is "+decimalToBinary(num));
    }
}
