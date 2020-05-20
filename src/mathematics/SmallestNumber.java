package mathematics;

public class SmallestNumber {

    private  static int findSmallest(int num){
        int numArr[] = new int[10];
        int result = 0;
        while(num > 0){
            int val = num%10;
            numArr[val]++;
            num = num/10;
        }

        for(int i = 1; i <= 9;i++){
            if(numArr[i] != 0){
                result = i;
                numArr[i]--;
                break;
            }
        }

        for(int i = 0; i <= 9; i++){
            while (numArr[i]-- != 0){
                result = result * 10 + i;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(findSmallest(371109));

    }
}
