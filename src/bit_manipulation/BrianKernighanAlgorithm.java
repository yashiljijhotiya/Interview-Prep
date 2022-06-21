package bit_manipulation;

//It is used to calculate the no. set bits present in the given number. In this algorithm we will perform '&' operation with num & num -1
// till the result becomes zero and we will increment the counter at every step that will give us the no. of set bits.
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
