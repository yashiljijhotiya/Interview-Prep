package problem_solving;

public class ChoclateWrapper {


    private static void maxChoclateBuy(int price, int money, int wrapperToBuy){
        if(money < 0 || money < price){
            System.out.println("Sorry no choclate can be buy with the money!");
        }
        int total = 0;
        int rem = 0;
        total =  money/price;
        if(total < wrapperToBuy){
            System.out.println("total choclate can be buy are : " +total);
        }
        while(total > wrapperToBuy){
            rem = total/wrapperToBuy;

        }
    }
    public static void main(String[] args) {
        maxChoclateBuy(1,15,3);
    }
}
