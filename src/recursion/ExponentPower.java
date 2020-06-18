package recursion;

public class ExponentPower {

    private static long power(int num, int pow){
        if(pow == 0){
            return 1;
        }
        else{
            return num * power(num, pow - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(power(3,5));
    }
}
