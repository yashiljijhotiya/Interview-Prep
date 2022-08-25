package dp.fibonacci;

public class HouseThief {
    private static int findMaxAmountSteal(int [] amount, int curr){
        if(curr >= amount.length){
            return 0;
        }
        int stealCurr = amount[curr] + findMaxAmountSteal(amount, curr+2);
        int skipCurr = findMaxAmountSteal(amount, curr+1);
        return Math.max(stealCurr, skipCurr);
    }

    public int findMaxSteal(int[] wealth) {
        if(wealth.length == 0) return 0;
        int n1=0, n2=wealth[0], temp;
        for(int i=1; i < wealth.length; i++) {
            temp = Math.max(n1 + wealth[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
    public static void main(String[] args) {

    }
}
