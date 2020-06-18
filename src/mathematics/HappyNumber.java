package mathematics;
//TC : log(n)
public class HappyNumber {

    private static boolean isHappyNum(int num){
        int slow = num, fast = num;
        do{
         slow = findSquareSum(slow);//move one step
         fast = findSquareSum(findSquareSum(fast));//move two step

        }while (slow != fast);//detect cycle

        return slow == 1;// see if the cycle stuck at 1
    }

    private  static  int findSquareSum(int num){
        int sum = 0, digit;
        while(num > 0){
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNum(12));
        System.out.println(isHappyNum(23));
    }
}
