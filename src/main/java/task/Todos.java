package task;

public class Todos extends Task {
    
    public Todos(String description) {
        super(description);
    }

    @Override
    public String getTaskType() {
        return "T";
    };

    @Override
    public String toFileFormat() {
        return "Todo | " + super.toFileFormat();
    }
}


