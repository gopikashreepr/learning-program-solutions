package mvc;

public class Main {
    public static void main(String[] args) {
        // Model
        Student student = new Student("Alice", "S101", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        System.out.println("\n🔄 Updating student grade...");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
