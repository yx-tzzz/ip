import java.util.Scanner;

public class SleepyVoid {
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }
        public void markAsDone(){
            this.isDone = true;
        }
        public void unmarkCompletedTask(){
            this.isDone = false;
        }
    }

    public static void main(String[] args) {
        String logo = "   /\\_/\\  \n" +
                     "  / _ _ \\ \n" +
                    " /       \\ \n" +
                    "|   >o<   | \n" +
                    "\\   _ _   / \n";
        System.out.println("Hello... \n" + logo + "I'm void, what can I do for you..?");
        Scanner scanInputs = new Scanner(System.in);
        Task[] storedObjects = new Task[100];
        int taskCount = 0;
        boolean isChatRunning = true;
        while(isChatRunning){
            String userInput = scanInputs.nextLine().trim();
            String[] inputParts = userInput.split(" ");
            String command = inputParts[0].toLowerCase();
            switch(command) {
                case "bye":
                    isChatRunning = false;
                    break;
                case "list":
                    System.out.println("            /ᐠ˵= =˵マ: ");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println("                " + (i + 1) + ". [" + storedObjects[i].getStatusIcon()+ "] " + storedObjects[i].description);
                    }
                    break;
                case "mark":
                    int objectIndex = Integer.parseInt(inputParts[1]) - 1;
                    storedObjects[objectIndex].markAsDone();
                    System.out.print("            /ᐠ˵, ,˵マ ");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("                " + (objectIndex + 1) + ". [" + storedObjects[objectIndex].getStatusIcon() + "] " + storedObjects[objectIndex].description);
                    break;

                default:
                    Task newTask = new Task(userInput);
                    storedObjects[taskCount] = newTask;
                    taskCount++;
                    System.out.println("            " +
                            "/ᐠ˵+ +˵マ added: " + userInput);
            }
        }
        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");

        
    }
}
