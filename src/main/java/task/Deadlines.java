package sleepyvoid.task;

public class Deadlines extends Task {
    protected String deadline;

    public Deadlines (String description, String deadline) {
        super(description);
        this.deadline = deadline;

    }

    @Override
    protected String getTaskType() {
        return "D";
    };

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }

}
