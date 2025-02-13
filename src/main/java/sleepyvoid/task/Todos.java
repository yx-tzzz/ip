package sleepyvoid.task;

public class Todos extends Task {
    
    public Todos(String description) {
        super(description);
    }

    @Override
    public String getTaskType() {
        return "T";
    };

}
