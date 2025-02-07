# A-To-Do-List-Application-with-File-Storage
This Java project will involve creating a simple To-Do list application where users can add, edit, delete, and view tasks. The tasks will be saved to a file, ensuring that the list persists even when the application is closed. Users can also mark tasks as completed or pending, and set due dates for each task.

### Key Features:
- **Add New Tasks**: Create new tasks with a title, description, and due date.
- **View Tasks**: Display all tasks stored in the application.
- **Delete Tasks**: Remove tasks from the list by title.
- **Search Tasks**: Find tasks by their title.
- **Mark Tasks as Completed/Pending**: Easily track the status of each task.
- **Persistence**: Task data is saved using file-based storage for later retrieval.

### Technologies Used:
- Java 8+
- Object Serialization (for saving tasks)
- Java Time API (for handling due dates)

### Project Structure:
- **Task.java**: Represents individual tasks with attributes like title, description, due date, and status (completed or pending).
- **ToDoListManager.java**: Manages the list of tasks, including adding, deleting, updating, and searching for tasks.
- **TaskManagerApp.java**: Command-Line Interface (CLI) for interacting with the user and performing operations on the tasks.

### Compile the classes:
-javac TaskManagerApp.java Task.java ToDoListManager.java
### Run the application:
- java TaskManagerApp

This project is intended to demonstrate basic Java programming concepts, including object-oriented programming, file handling, and date manipulation.
