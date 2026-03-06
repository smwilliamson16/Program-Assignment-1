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
          System.out.println("Delete is not implemented yet.");
          break;
        case "4":
          System.out.println("Clear is not implemented yet.");
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
    System.out.println("3) Delete task (coming soon)");
    System.out.println("4) Clear tasks (coming soon)");
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
}