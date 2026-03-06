import java.util.ArrayList;

/**
 * Represents a simple to-do list
 * Stores tasks and provides basic operations
 */
public class TodoList {

  private ArrayList<String> tasks;

  /** Creates an empty to-do list */
  public TodoList() {
    tasks = new ArrayList<>();
  }

  /**
   * Adds a task to the list.
   *
   * @param task the task to add
   */
  public void addTask(String task) {
    tasks.add(task);
  }



  /**
   * Returns the list of tasks
   *
   * @return the task list
   */
  public ArrayList<String> getTasks() {
    return tasks;
  }

  /**
   * Returns true if the list is empty
   *
   * @return whether the list is empty
   */
  public boolean isEmpty() {
    return tasks.isEmpty();
  }
}