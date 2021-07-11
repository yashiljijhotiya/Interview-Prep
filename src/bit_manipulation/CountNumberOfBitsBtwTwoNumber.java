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

    private static boolean checkIthBitSet(int num, int i){
        if((num &(1<<(i -1)))>0){
            return true;
        }
        return  false;
    }


    public static void main(String[] args) {
        //countNumOfBitsBwNums(10, 15);
        System.out.println(checkIthBitSet(2,2));
    }
}
