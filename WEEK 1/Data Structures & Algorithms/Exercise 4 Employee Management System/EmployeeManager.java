public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("✅ Employee added: " + emp.getName());
        } else {
            System.out.println("❌ Array is full. Cannot add more employees.");
        }
    }

    public Employee searchById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        System.out.println("📋 All Employees:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteById(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift elements to the left
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null;
            size--;
            System.out.println("🗑️ Employee with ID " + id + " deleted.");
        } else {
            System.out.println("❌ Employee with ID " + id + " not found.");
        }
    }
}
