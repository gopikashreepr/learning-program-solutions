package proxy;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");

        // First access: should load from server
        System.out.println("First call:");
        image1.display();

        // Second access: should use cached image
        System.out.println("\nSecond call:");
        image1.display();

        // Different image
        System.out.println("\nNew image:");
        Image image2 = new ProxyImage("sunset.jpg");
        image2.display();
    }
}
