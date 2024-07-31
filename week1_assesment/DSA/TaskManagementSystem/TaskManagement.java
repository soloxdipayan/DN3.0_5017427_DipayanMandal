public class TaskManagement {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "In Progress"));
        taskList.addTask(new Task(3, "Task 3", "Completed"));

 
        System.out.println("Traversing tasks:");
        taskList.traverseTasks();

        // Searching a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting task
        System.out.println("\nDeleting Task with ID 2:");
        boolean isDeleted = taskList.deleteTask(2);
        if (isDeleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }

        //  tasks after deletion
        System.out.println("\nTraversing tasks after deletion:");
        taskList.traverseTasks();
    }
}
