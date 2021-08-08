package bit_manipulation;

//It is used to calculate the no. set bit present in the given number.
public class BrianKernighanAlgorithm {
    private static int countNoOfSetBits(int num){
        int count = 0;
        while(num > 0){
            num = num&(num-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countNoOfSetBits(4));
    }
}
