public class Task {
    protected String description;
    protected boolean isDone;


    public Task( String description) {
        this.description = description;
        this.isDone = false;

    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getTaskType() {
        return " ";
    };

    @Override
    public String toString() {
        return "[" + getTaskType() + "][" + getStatusIcon() + "] " + description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public void unmarkCompletedTask() {
        this.isDone = false;
    }

}

