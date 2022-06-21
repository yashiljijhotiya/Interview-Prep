package DesignPattern.startegy;

public class UPIPaymentStrategy implements  IPaymentStrategy{
    @Override
    public void payAmount(int amount) {
        System.out.println("Payment of RS : "+amount +" made by using UPI.");
    }
}
