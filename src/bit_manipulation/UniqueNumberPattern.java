package bit_manipulation;

public class UniqueNumberPattern {

    private static int findOneUniqueNumber(int arr[]){
        int num = 0;
        for(int i : arr){
            num = num^i;
        }
        return num;
    }

    private static int[] findTwoUniqueNumber(int arr[]){
        int xor = 0;
        //in this loop we will get the 2 unique number
        for(int i : arr){
            xor = xor^i;
        }
        // Now from xor we have to find the right most set bit ie the position of first right most set bit
        int setBit = 0;
        int position = 0;
        while (setBit != 1){
            setBit = xor & 1;
            position++;
            xor = xor>>1;
        }

        int newXOR = 0;
        for(int i : arr){
            if(getBit(i, position-1)){
                newXOR = newXOR^i;
            }
        }
        int firstNum = newXOR;
        int secondNum = xor^newXOR;
        int result [] = {firstNum, secondNum};
        return result;
    }

    private static boolean getBit(int n, int position){
        return ((n & (1 << position))!= 0);
    }

    private static int setBit(int n, int position){
        return (n | (1 << position));
    }


    private static int findUniqueThreeTimes(int arr[]){
        int result = 0;
        for (int i = 0; i < 64; i++) {
            int sum = 0;
            for (int num : arr) {
                if(getBit(num, i)){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                result = setBit(result,i);
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
