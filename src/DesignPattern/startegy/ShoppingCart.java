package DesignPattern.startegy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);

    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getAmount();
        }
        return sum;
    }

    public void pay(IPaymentStrategy paymentStrategy) {
        int amount = calculateTotal();
        paymentStrategy.payAmount(amount);
    }
}
