package observer;

public class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    @Override
    public void update(double newPrice) {
        System.out.println("💻 WebApp for " + user + ": Stock price updated to $" + newPrice);
    }
}
