package DesignPattern.startegy;
/* Strategy pattern is useful when we have multiple algorithms for specific task
and we want our application to be flexible to chose any of the algorithm at runtime for specific task.
Strategy pattern is also known as Policy Pattern. We define multiple algorithms and
let client application pass the algorithm to be used as a parameter.

One of the best example of strategy pattern is Collections.sort() method that takes Comparator parameter.
Based on the different implementations of Comparator interfaces, the Objects are getting sorted in different ways.

It uses composition instead of inheritance, It is a type of behaviour pattern.

It follows Open/Closed Principle. You can introduce new strategies without having to change the context.
*

Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns are based on composition.



**/
public class Driver {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product1 = new Product("Bleu da chanel", 10000);
        Product product2 = new Product("Iphone 13 Pro Max", 139000);
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);
        shoppingCart.pay(new CreditCardPaymentStrategy());
    }
}
