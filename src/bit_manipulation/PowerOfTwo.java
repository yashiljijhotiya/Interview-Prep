package bit_manipulation;

public class PowerOfTwo {

    private static boolean isPowerOfTwo(int num){
        if((num & num-1) == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(16));
    }
}
