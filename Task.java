import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private String title;
    private String description;
    private boolean completed; // Status of task
    private LocalDate dueDate; // Due date for task

    // Constructor with due date and status
    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.completed = false; // Default status is not completed
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void markPending() {
        this.completed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (completed ? "Completed" : "Pending") + "\nDue Date: " + dueDate;
    }
}
