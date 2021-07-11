package bit_manipulation;

public class BitBasic {

    // to check even or odd
    // coz every even no. ends with '0' as end bit and odd no.  ends with '1' bit, so if we do '&' operator with no.
    // eg 5 :- 101 & 1 = 101 i.e. odd last is 1
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

    // min no. of bits to convert a to b 11
    //                                   00
    private static void minNoOfBitsToConvert(int a, int b){
        int res = a^b;
        System.out.println("min. bits to convert a to b : "+res);
    }


    private static void removeLastSetBit(int n){
        int res = n & (n-1);
        System.out.println(res);
    }

    private static void swap(int a, int b){
        a = a^b;
        b = b^a;
        a = a^b;
        System.out.println("no. after swapping are : a  =  "  + a + "  &  b  =  " + b );
    }
    /* Power of 2 always have only one bit set ie last bit eg 2 = 10, 4 = 100, 8 = 1000
    and if we subtract number by 1  eg num =  4 = 100 now subtract -1 = 3 = 11 and we so & operator (4 & 3)
    (100 & 011) = 0
    * */
    private static boolean isPowerOf2(int num){
        if((num&(num-1)) == 0){
            return true;
        }
        return false;
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
        swap(5,7);
    }
}
