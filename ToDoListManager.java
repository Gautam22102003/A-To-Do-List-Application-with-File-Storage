import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ToDoListManager {
    private List<Task> tasks;
    private final String fileName = "tasks.dat";

    public ToDoListManager() {
        tasks = loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public boolean deleteTask(String title) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                saveTasks();
                return true;
            }
        }
        return false;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task searchTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    public void markTaskAsCompleted(String title) {
        Task task = searchTaskByTitle(title);
        if (task != null) {
            task.markCompleted();
            saveTasks();
        }
    }

    public void markTaskAsPending(String title) {
        Task task = searchTaskByTitle(title);
        if (task != null) {
            task.markPending();
            saveTasks();
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private List<Task> loadTasks() {
        List<Task> taskList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            taskList = (List<Task>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous tasks found, starting fresh.");
        }
        return taskList;
    }
}
