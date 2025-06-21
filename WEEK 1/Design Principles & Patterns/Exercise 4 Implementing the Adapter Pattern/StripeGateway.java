package adapter;

public class StripeGateway {
    public void makeStripePayment(double amountInDollars) {
        System.out.println("Stripe processing payment of $" + amountInDollars);
    }
}
