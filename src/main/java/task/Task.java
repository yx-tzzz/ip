package task;


/**
 * An abstract class that represents a task.
 * Provides common functionality and attributes for all types of tasks,
 * such as a description, completion status, and methods to mark tasks as done.
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a Task with a description based on user input and initialise its completion status to false (not done).
     *
     * @param description The task given by the user.
     */
    public Task( String description) {
        this.description = description;
        this.isDone = false;

    }

    /**
     * Returns the status icon for the task.
     * Returns "X" if the task is marked as done, and " " if not done.
     *
     * @return String representing the status icon of the task.
     */
    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Returns the type of the task.
     * This method is intended to be overridden by subclasses to provide the specific task types.
     *
     * @return A string representing the task type
     */
    protected String getTaskType() {
        return " ";
    };

    /**
     * Returns a string representation of the task,
     * together with additional information such as its type and completion status.
     *
     * @return A string representation of the task and its related information
     */
    @Override
    public String toString() {
        return "[" + getTaskType() + "][" + getStatusIcon() + "] " + description;
    }

    /**
     * Marks the task as done by setting the completion status to true.
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * Returns a formatted string representation of the task and its related information for saving to a text file.
     *
     * @return A string representation of the task in file format to be added in a text file.
     */
    public String toFileFormat() {
        return (isDone ? "Completed ^* *^" : "Yet to do...") + " | " + description;
    }

    public String getTask() {
        return description;
    }

}

