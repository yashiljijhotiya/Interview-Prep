package mathematics;

public class MultipleOf3 {

    private static int isMultipleOF3(int num){
        int oddCount = 0, evenCount = 0;
        if(num == 0)
            return 1;
        if(num == 1)
            return 0;
        if(num < 0)
            num = -num;
        while(num != 0){
            if((num & 1) != 0){
                oddCount++;
            }
            if((num & 2) != 0){
                evenCount++;
            }
            num = num >> 2;
        }
        return isMultipleOF3(Math.abs(oddCount - evenCount));
    }

    public static void main(String[] args) {
        int num = 27;
        if(isMultipleOF3(num) != 0){
            System.out.println(num + " is multiple of 3.");
        }
        else
        System.out.println(num + " is not a multiple of 3.");

    }
}
