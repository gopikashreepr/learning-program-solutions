public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add products
        manager.addProduct(new Product(101, "Laptop", 10, 50000.0));
        manager.addProduct(new Product(102, "Keyboard", 50, 700.0));

        // Display
        System.out.println("Initial Inventory:");
        manager.displayInventory();

        // Update
        manager.updateProduct(101, "Gaming Laptop", 8, 60000.0);
        System.out.println("\nAfter Update:");
        manager.displayInventory();

        // Delete
        manager.deleteProduct(102);
        System.out.println("\nAfter Deletion:");
        manager.displayInventory();
    }
}
