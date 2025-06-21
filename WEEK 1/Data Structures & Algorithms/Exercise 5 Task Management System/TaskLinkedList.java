public class TaskLinkedList {
    private TaskNode head;

    // Add task at end
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("✅ Task added: " + task.taskName);
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("⚠️ No tasks found.");
            return;
        }
        System.out.println("📋 Task List:");
        TaskNode temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Search by task ID
    public Task searchTask(int taskId) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Delete by task ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("⚠️ List is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("🗑️ Task deleted with ID " + taskId);
            return;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;

        while (curr != null) {
            if (curr.task.taskId == taskId) {
                prev.next = curr.next;
                System.out.println("🗑️ Task deleted with ID " + taskId);
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("❌ Task not found with ID " + taskId);
    }
}
