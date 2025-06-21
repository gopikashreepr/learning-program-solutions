package observer;

public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(double newPrice) {
        System.out.println("📱 MobileApp for " + user + ": Stock price updated to $" + newPrice);
    }
}
