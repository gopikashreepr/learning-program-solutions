package strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("=== Using Credit Card ===");
        context.setPaymentStrategy(new CreditCardPayment("1234567890123456", "Alice"));
        context.makePayment(1500.75);

        System.out.println("\n=== Using PayPal ===");
        context.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        context.makePayment(950.50);

        System.out.println("\n=== No Strategy Set ===");
        context.setPaymentStrategy(null);
        context.makePayment(200);
    }
}
