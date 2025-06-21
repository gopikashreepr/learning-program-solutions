package observer;

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser1 = new MobileApp("Alice");
        Observer webUser1 = new WebApp("Bob");

        market.registerObserver(mobileUser1);
        market.registerObserver(webUser1);

        market.setStockPrice(105.50);
        market.setStockPrice(110.75);

        market.removeObserver(webUser1);
        System.out.println("\nBob (WebApp) has unsubscribed.\n");

        market.setStockPrice(99.99);
    }
}
