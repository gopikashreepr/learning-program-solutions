public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5); // Array of size 5

        // Adding employees
        manager.addEmployee(new Employee(1, "Alice", "Manager", 80000));
        manager.addEmployee(new Employee(2, "Bob", "Engineer", 60000));
        manager.addEmployee(new Employee(3, "Charlie", "Analyst", 50000));

        // Traversing employees
        manager.traverse();

        // Searching employee
        System.out.println("\n🔍 Searching for employee ID 2:");
        Employee e = manager.searchById(2);
        System.out.println(e != null ? e : "Not found");

        // Deleting employee
        System.out.println("\n🗑️ Deleting employee ID 2:");
        manager.deleteById(2);

        // Traversing after deletion
        System.out.println("\n📋 Employees after deletion:");
        manager.traverse();
    }
}
