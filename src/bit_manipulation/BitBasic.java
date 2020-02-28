package bit_manipulation;

public class BitBasic {

    // to check even or odd
    private static void evenOddTest(int num){
        System.out.println(( num&1) == 0 ?  "EVEN" : "ODD" );
    }

    //count no. of set bits
    private static void countNoOfSetBits(int num){
        int count = 0;
        while(num > 0){
            count += num&1;
            num = num>>1;
        }
        System.out.println("no. of set bits are :" +count);
    }

    // min no. of bits to convert a to b
    private static void minNoOfBitsToConvert(int a, int b){
        int res = a^b;
        System.out.println("min. bits to convert a to b : "+res);
    }



    public static void main(String[] args) {
        System.out.println(5&2); //AND operator
        System.out.println(2|1); // OR operator
        System.out.println(5<<2); //a<<b means, here in this eg. a = 5, b = 2. So o/p will be written as 5 * 2^2 i.e. a*2^b;
        System.out.println(5>>2);//a>>b means, here in this eg. a = 5, b = 2. So o/p will be written as 5/ 2^2 i.e. a/2^b;
        System.out.println(1^11); // XOR operator
        System.out.println(~(4)); // NOT operator flipping all the bits
        evenOddTest(1111112);
        countNoOfSetBits(5);
        minNoOfBitsToConvert(11,15);


    }
}
