package problem_solving;

public class ChoclateWrapper {


    private static void maxChocolateBuy(int price, int money, int wrapperToBuy){
        if(money < 0 || money < price){
            System.out.println("Sorry no chocolate can be buy with the money!");
            return;
        }
        int totalChocolateBought =  money/price;
        int collectedWrapper = totalChocolateBought;

        while(collectedWrapper >= wrapperToBuy){
            int bought = collectedWrapper/wrapperToBuy;
            int rem = collectedWrapper%wrapperToBuy;
            collectedWrapper = rem + bought;
            totalChocolateBought += bought;
        }
        System.out.printf("total chocolate bought are :  " + totalChocolateBought);
    }
    public static void main(String[] args) {
        maxChocolateBuy(1,-11,3);
    }
}
