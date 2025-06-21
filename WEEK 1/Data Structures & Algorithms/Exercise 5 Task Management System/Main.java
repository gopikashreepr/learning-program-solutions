public class Main {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        // Add tasks
        list.addTask(new Task(1, "Design UI", "Pending"));
        list.addTask(new Task(2, "Implement Backend", "In Progress"));
        list.addTask(new Task(3, "Testing", "Not Started"));

        // Traverse
        list.traverseTasks();

        // Search
        System.out.println("\n🔍 Searching for Task ID 2:");
        Task t = list.searchTask(2);
        System.out.println(t != null ? t : "Not found");

        // Delete
        System.out.println("\n🗑️ Deleting Task ID 2");
        list.deleteTask(2);

        // Traverse after deletion
        System.out.println("\n📋 Tasks After Deletion:");
        list.traverseTasks();
    }
}
