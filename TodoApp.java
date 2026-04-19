import java.util.Scanner;

/**
 * Console application for managing a to-do list
 */
public class TodoApp {

  /**
   * Program entry point.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    TodoList todoList = new TodoList();
    Scanner scanner = new Scanner(System.in);

    boolean running = true;

    while (running) {
      printMenu();
      String choice = scanner.nextLine().trim();

      switch (choice) {
        case "1":
          handleAdd(todoList, scanner);
          break;
        case "2":
          handleView(todoList);
          break;
        case "3":
          handleDelete(todoList, scanner);
          break;
        case "4":
          handleClear(todoList, scanner);
          break;
        case "0":
          running = false;
          System.out.println("Goodbye.");
          break;
        default:
          System.out.println("Invalid option.");
          break;
      }
    }

    scanner.close();
  }

  /** Prints the menu options */
  private static void printMenu() {
    System.out.println();
    System.out.println("=== To-Do List ===");
    System.out.println("1) Add task");
    System.out.println("2) View tasks");
    System.out.println("3) Delete task");
    System.out.println("4) Clear tasks");
    System.out.println("0) Quit");
    System.out.print("Choose an option: ");
  }

  /**
   * Handles adding a task.
   *
   * @param todoList the to-do list
   * @param scanner the scanner for user input
   */
  private static void handleAdd(TodoList todoList, Scanner scanner) {
    System.out.print("Enter a task: ");
    String task = scanner.nextLine().trim();

    if (task.isEmpty()) {
      System.out.println("Task cannot be empty.");
      return;
    }

    todoList.addTask(task);
    System.out.println("Task added.");
  }

  /**
   * Handles displaying tasks.
   *
   * @param todoList the to-do list
   */
  private static void handleView(TodoList todoList) {
    if (todoList.isEmpty()) {
      System.out.println("No tasks found.");
      return;
    }

    System.out.println("Tasks:");
    for (int i = 0; i < todoList.getTasks().size(); i++) {
      System.out.println((i + 1) + ") " + todoList.getTasks().get(i));
    }
  }

  /**
   * Handles deleting a task by number.
   *
   * @param todoList the to-do list
   * @param scanner the scanner for user input
   */
  private static void handleDelete(TodoList todoList, Scanner scanner) {
    if (todoList.isEmpty()) {
      System.out.println("No tasks to delete.");
      return;
    }

    handleView(todoList);
    System.out.print("Enter the number of the task to delete: ");
    String input = scanner.nextLine().trim();

    try {
      int taskNumber = Integer.parseInt(input);

      if (taskNumber < 1 || taskNumber > todoList.getTasks().size()) {
        System.out.println("Invalid task number.");
        return;
      }

      String removedTask = todoList.deleteTask(taskNumber - 1);
      System.out.println("Deleted: " + removedTask);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    }
  }

  /**
   * Handles clearing all tasks.
   *
   * @param todoList the to-do list
   * @param scanner the scanner for user input
   */
  private static void handleClear(TodoList todoList, Scanner scanner) {
    if (todoList.isEmpty()) {
      System.out.println("The list is already empty.");
      return;
    }

    System.out.print("Are you sure you want to clear all tasks? (y/n): ");
    String confirm = scanner.nextLine().trim().toLowerCase();

    if (confirm.equals("y") || confirm.equals("yes")) {
      todoList.clearTasks();
      System.out.println("All tasks cleared.");
    } else {
      System.out.println("Clear canceled.");
    }
  }
}