package adapter;

public class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("PayPal processing payment of $" + amount);
    }
}
