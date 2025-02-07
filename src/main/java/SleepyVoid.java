import java.util.Scanner;

public class SleepyVoid {
    private static final String LEADING_SPACE = "                ";
    private static final String TASK_COUNT_MESSAGE = "          Now there's %d pending task(s) in the list.";

    public static void printTask(int taskCount, Task[] storedObjects) {
        System.out.println(LEADING_SPACE + (taskCount) + ". " + storedObjects[taskCount-1].toString());
    }

    public static void printAddedTask(int taskCount, Task[] storedObjects) {
        System.out.println("            " + "/ᐠ˵+ +˵マ added: " );
        printTask(taskCount, storedObjects);
        System.out.printf((TASK_COUNT_MESSAGE) + "%n", taskCount);
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
            String[] inputParts = userInput.split(" ",2);
            String command = inputParts[0].toLowerCase();

            switch(command) {
                case "bye":
                    isChatRunning = false;
                    break;

                case "list":
                    System.out.println("            /ᐠ˵= =˵マ: ");
                    for (int i = 0; i < taskCount; i++) {
                        printTask(i + 1, storedObjects);
                    }
                    break;

                case "mark":
                    int objectIndex = Integer.parseInt(inputParts[1]) - 1;
                    storedObjects[objectIndex].markAsDone();
                    System.out.print("            /ᐠ˵, ,˵マ ");
                    System.out.println("Nice! I've marked this task as done:");
                    printTask(objectIndex + 1, storedObjects);
                    break;

                case "todo":
                    storedObjects[taskCount] = new Todos(inputParts[1].trim());
                    taskCount++;
                    printAddedTask(taskCount, storedObjects);
                    break;

                case "event":
                    String[] eventParts = inputParts[1].split(" /from | /to ",3);
                    storedObjects[taskCount] = new Events(eventParts[0], eventParts[1], eventParts[2]);
                    taskCount++;
                    printAddedTask(taskCount, storedObjects);
                    break;

                case "deadline":
                    String[] deadlineParts = inputParts[1].split(" /by ", 2);
                    storedObjects[taskCount] = new Deadlines(deadlineParts[0], deadlineParts[1]);
                    taskCount++;
                    printAddedTask(taskCount, storedObjects);
                    break;

                default:
                    storedObjects[taskCount] = new Task(userInput);
                    taskCount++;
                    printAddedTask(taskCount, storedObjects);
            }
        }

        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");
        scanInputs.close();
        
    }
}
