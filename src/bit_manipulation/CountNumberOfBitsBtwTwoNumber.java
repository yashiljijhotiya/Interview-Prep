package bit_manipulation;

public class CountNumberOfBitsBtwTwoNumber {

    private static void countNumOfBitsBwNums(int a, int b){
        int count = 0;
        for(int i =a; i <= b; i++){
            count += countNoOfSetBits(i);
        }

        System.out.println("Number of bits between two numbers are :" + count);
    }

    private static int countNoOfSetBits(int num){
        int count = 0;
        while(num > 0){
            count += num&1;
            num = num>>1;
        }
        return count;
    }

    public static void main(String[] args) {
     countNumOfBitsBwNums(10, 15);
    }
}
