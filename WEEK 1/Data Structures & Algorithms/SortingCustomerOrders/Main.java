public class Main {
    public static void printOrders(String message, Order[] orders) {
        System.out.println(message);
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Order[] orders1 = {
                new Order(101, "Alice", 2500.0),
                new Order(102, "Bob", 5000.0),
                new Order(103, "Charlie", 1500.0),
                new Order(104, "David", 3000.0)
        };

        // Copy for both sorts
        Order[] orders2 = orders1.clone();

        // Bubble Sort
        BubbleSort.sort(orders1);
        printOrders("📦 Orders after Bubble Sort (by totalPrice desc):", orders1);

        // Quick Sort
        QuickSort.sort(orders2, 0, orders2.length - 1);
        printOrders("⚡ Orders after Quick Sort (by totalPrice desc):", orders2);
    }
}
