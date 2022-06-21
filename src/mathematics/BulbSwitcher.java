package mathematics;
/**
 * Leetcode: 319
 * Logic the no. of bulb on after n iteration are the perfect square no. present less than n.
 * Coz all perfect square have odd no. of factors (2*n+1)
 * */
public class BulbSwitcher {
    private static int bulbSwitch(int n){
        int count = 0;
        for(int i = 1; i * i <= n; i++){
            count++;
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
