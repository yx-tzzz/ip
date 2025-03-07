package task;

public class Task {
    protected String description;
    protected boolean isDone;


    public Task( String description) {
        this.description = description;
        this.isDone = false;

    }

    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    protected String getTaskType() {
        return " ";
    };

    @Override
    public String toString() {
        return "[" + getTaskType() + "][" + getStatusIcon() + "] " + description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public String toFileFormat() {
        return (isDone ? "Completed ^* *^" : "Yet to do...") + " | " + description;
    }

}

