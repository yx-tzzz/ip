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

    protected void markAsDone(){
        this.isDone = true;
    }

    protected void unmarkCompletedTask() {
        this.isDone = false;
    }

}

