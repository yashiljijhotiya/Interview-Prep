package DesignPattern.startegy;

public class DebitCardPaymentStrategy implements IPaymentStrategy{
    @Override
    public void payAmount(int amount) {
        System.out.println("Payment of RS : "+amount +" made by using Debit card.");
    }
}
