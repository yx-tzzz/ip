package task;

/**
 * The Deadlines class represents a deadline task.
 * It extends from the abstract Task class and provides specific functionality for deadline tasks,
 * such as storing the deadline and customizing the string representation and file format for saving.
 */
public class Deadlines extends Task {
    protected String deadline;

    /**
     * Creates a new Deadlines instance with the specified description and deadline.
     *
     * @param description The description of the deadline task based on the user input.
     * @param deadline    The deadline of the task.
     */
    public Deadlines (String description, String deadline) {
        super(description);
        this.deadline = deadline;

    }

    /**
     * Returns the task type identifier for a deadline task.
     *
     * @return A string representing the task type ("D" for deadline).
     */
    @Override
    protected String getTaskType() {
        return "D";
    };

    /**
     * Returns a string representation of the deadline task, including its type, status, description,
     * and deadline.
     *
     * @return A string representation of the deadline task.
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }
    
    /**
     * Returns a formatted string representation of the deadline task for saving to a file.
     * The format includes the task type, default file format from the superclass, and the deadline.
     *
     * @return A string representation of the deadline task in file format.
     */
    @Override
    public String toFileFormat() {
        return "Deadline | " + super.toFileFormat() + " | " + deadline;
    }
}
