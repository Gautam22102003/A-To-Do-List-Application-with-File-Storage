import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ToDoListManager manager = new ToDoListManager();

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    searchTask();
                    break;
                case 5:
                    markTaskCompleted();
                    break;
                case 6:
                    markTaskPending();
                    break;
                case 7:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Search Task by Title");
        System.out.println("5. Mark Task as Completed");
        System.out.println("6. Mark Task as Pending");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void addTask() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task due date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dateString);

        Task task = new Task(title, description, dueDate);
        manager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        System.out.println("\nYour Tasks:");
        if (manager.getTasks().isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : manager.getTasks()) {
                System.out.println("----");
                System.out.println(task);
            }
        }
    }

    private static void deleteTask() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter task title to delete: ");
        String title = scanner.nextLine();
        if (manager.deleteTask(title)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found with the title: " + title);
        }
    }

    private static void searchTask() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter task title to search: ");
        String title = scanner.nextLine();
        Task task = manager.searchTaskByTitle(title);
        if (task != null) {
            System.out.println("Task found: ");
            System.out.println(task);
        } else {
            System.out.println("Task not found with the title: " + title);
        }
    }

    private static void markTaskCompleted() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter task title to mark as completed: ");
        String title = scanner.nextLine();
        manager.markTaskAsCompleted(title);
        System.out.println("Task marked as completed.");
    }

    private static void markTaskPending() {
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Enter task title to mark as pending: ");
        String title = scanner.nextLine();
        manager.markTaskAsPending(title);
        System.out.println("Task marked as pending.");
    }
}
