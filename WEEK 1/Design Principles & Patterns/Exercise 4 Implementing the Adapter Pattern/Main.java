package adapter;

public class Main {
    public static void main(String[] args) {
        // Using Stripe
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(150.00);

        // Using PayPal
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        payPalProcessor.processPayment(250.00);
    }
}
