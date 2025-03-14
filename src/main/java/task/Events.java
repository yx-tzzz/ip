package task;


/**
 * The Events class represents an event task.
 * It extends the abstract Task class and provides specific functionality for event tasks,
 * such as storing the start and end times of the event and customizing the string representation
 * and file format for saving.
 */
public class Events extends Task {
    protected String from;
    protected String to;

    /**
     * Constructs a new Events instance with the specified task description, start time, and end time.
     *
     * @param description The description of the event task.
     * @param from        The start time or date of the event.
     * @param to          The end time or date of the event.
     */
    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the task type identifier for an event task.
     *
     * @return A string representing the task type ("E" for event).
     */
    @Override
    public String getTaskType() {
        return "E";
    };

    /**
     * Returns a string representation of the event task, including its type, status, description,
     * start time, and end time.
     *
     * @return A string representation of the event task.
     */
    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Returns a formatted string representation of the event task for saving to a text file.
     * The format includes the task type, default file format from Task class, and the start and end times.
     *
     * @return A string representation of the event task in file format.
     */
    @Override
    public String toFileFormat() {
        return "Event | " + super.toFileFormat() + " | " + from + " ~ " + to;
    }
}
