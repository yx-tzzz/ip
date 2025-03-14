package utility;

import task.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages a list of tasks, providing methods to add, remove, update, and return tasks.
 */
public class TaskList implements Iterable<Task>{
    private ArrayList<Task> tasks;


    /**
     * Adds the list of tasks into the current task list
     *
     * @param tasks the list of tasks in storage
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks in the list
     */
    public int taskCount(){
        return tasks.size();
    }


    /**
     * Adds a task into the list
     *
     * @param task The task to be added into the list
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Checks if the task list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    /**
     * Removes a task from the list via the index.
     *
     * @param index The index of the task to be removed from the list.
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    /**
     * Marks a task in the list as done via the index.
     *
     * @param index The index of the task to be marked as done in the list.
     */
    public void markTask(int index) {
        tasks.get(index).markAsDone();
    }

    /**
     * Returns a task in the list as a String based on the given index.
     *
     * @param index The index of the task to be returned as String
     * @return The task associated with the given index
     */
    public String toString(int index) {
        return tasks.get(index).toString();
    }

    /**
     * Returns an iterator over the tasks in the task list.
     * The iterator follows the order of tasks as they are stored in the list.
     *
     * @return An {@link Iterator} over the tasks in the task list.
     */
    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public TaskList findTasksByKeyword(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTask().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return new TaskList(matchingTasks);
    }


}
