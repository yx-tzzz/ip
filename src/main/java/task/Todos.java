package task;

/**
 * The Todos class represents a todo task.
 * It extends the abstract Task class and provides specific functionality for todo tasks,
 * such as a task type identifier and a custom file format for saving.
 */
public class Todos extends Task {

    /**
     * Creates a new Todos instance with the given user input.
     *
     * @param description The description of the todo task provided by the user.
     */
    public Todos(String description) {
        super(description);
    }

    /**
     * Returns the task type identifier for a todo task.
     *
     * @return A string representing the task type ("T" for todo).
     */
    @Override
    public String getTaskType() {
        return "T";
    };

    /**
     * Returns a formatted string representation of the todo task for saving to a text file.
     * The format adds the task type and the default file format provided by Task class.
     *
     * @return A string representation of the todo task in text file format.
     */
    @Override
    public String toFileFormat() {
        return "Todo | " + super.toFileFormat();
    }
}


