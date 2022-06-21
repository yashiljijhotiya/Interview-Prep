package bit_manipulation;

/* To find the power of 2 we will do the '&' operation with num & num -1. If the no. is power of two then it's left most bit is only set
and num - 1 will have all the bits set. And if we do the '&' operation then the result will be zero.
eg => num = 4 ->  (4&3)  = 100 & 11 = 000
* */
public class PowerOfTwo {

    private static boolean isPowerOfTwo(int num) {
        if ((num & num - 1) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(16));
    }
}
