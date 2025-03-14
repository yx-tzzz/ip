package utility;

import task.*;
import java.util.ArrayList;
import java.util.Iterator;


public class TaskList implements Iterable<Task>{
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int taskCount(){
        return tasks.size();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void markTask(int index) {
        tasks.get(index).markAsDone();
    }

    public String toString(int index) {
        return tasks.get(index).toString();
    }

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
