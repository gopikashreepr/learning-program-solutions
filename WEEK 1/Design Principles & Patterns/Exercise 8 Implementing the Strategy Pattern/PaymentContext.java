package strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    // Execute payment
    public void makePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("❌ No payment method selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
