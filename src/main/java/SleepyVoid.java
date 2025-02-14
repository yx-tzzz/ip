import exception.InvalidDeadlineException;
import exception.InvalidEventException;
import exception.InvalidTodoException;

import java.util.Scanner;
import java.util.ArrayList;

public class SleepyVoid {
    private static final String LEADING_SPACE = "                ";
    private static final String TASK_COUNT_MESSAGE = "          Now there's %d pending task(s) in the list.";

    public static void printTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println(LEADING_SPACE + (taskCount) + ". " + storedObjects.get(taskCount-1).toString());
    }

    public static void printAddedTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println("            " + "/ᐠ˵+ +˵マ added: " );
        printTask(taskCount, storedObjects);
        System.out.printf((TASK_COUNT_MESSAGE) + "%n", taskCount);
    }

    public static void printCommands() {

        System.out.println(LEADING_SPACE + "To add a task in the list, type: todo XX");
        System.out.println(LEADING_SPACE + "To add an event in the list, type: event XX /from XX /to XX");
        System.out.println(LEADING_SPACE + "To add a task with a deadline into the list, type: deadline XX /by XX");
        System.out.println(LEADING_SPACE + "To mark an item as done, type: mark (the task number)");
        System.out.println(LEADING_SPACE + "To view the current list, type: list");
        System.out.println(LEADING_SPACE + "To end the conversation with me, type bye \n");
        System.out.println(LEADING_SPACE + "Ps Command words are not case sensitive!!");
        System.out.println(LEADING_SPACE + "XX in the examples are your inputs");
        System.out.println(LEADING_SPACE + "Hope this makes things easier /ᐠ˵≡ ≡˵マ");

    }

    public static void main(String[] args) {
        String logo = "   /\\_/\\  \n" +
                     "  / _ _ \\ \n" +
                    " /       \\ \n" +
                    "|   >o<   | \n" +
                    "\\   _ _   / \n";
        System.out.println("Hello... \n" + logo + "I'm void, what can I do for you..?");
        System.out.println("Before I forget, here's a guide I've made to help you, here you gooo");
        printCommands();

        Scanner scanInputs = new Scanner(System.in);
        ArrayList<Task> storedObjects = new ArrayList<Task>();
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
                    if (storedObjects.isEmpty()) {
                        System.out.println(LEADING_SPACE + "List is currently empty, would you like to add some tasks into the list? ^ ，，^");
                        System.out.println(LEADING_SPACE + "Here's the guide on how to use me in case you forgotz\n");
                        printCommands();
                    } else {
                        for (int i = 0; i < taskCount; i++) {
                            printTask(i + 1, storedObjects);
                        }
                    }
                    break;

                case "mark":
                    try {
                        int objectIndex = Integer.parseInt(inputParts[1]) - 1;
                        storedObjects.get(objectIndex).markAsDone();
                        System.out.print("            /ᐠ˵, ,˵マ ");
                        System.out.println("Nice! I've marked this task as done:");
                        printTask(objectIndex + 1, storedObjects);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("            /ᐠ˵x x˵マ ");
                        System.out.println("Invalid as there are " + taskCount +
                                " items in the list, please select a number in the range to mark item as done" );
                    } catch (NumberFormatException e) {
                        System.out.print("            /ᐠ˵x x˵マ ");
                        System.out.println( "Invalid input, please enter an integer from 1 to " + taskCount + "after the input command mark" );
                    }
                    break;


                case "todo":
                    try {
                        if (inputParts.length < 2) {
                            throw new InvalidTodoException();
                        }
                        storedObjects.add(new Todos(inputParts[1].trim()));
                        taskCount++;
                        printAddedTask(taskCount, storedObjects);
                    } catch (InvalidTodoException e) {
                        System.out.print("            /ᐠ˵x x˵マ ");
                        System.out.println("Missing input after the todo command, please key in the task after the todo command (eg todo XX)");
                    }
                    break;

                case "event":
                    try {
                        if (inputParts.length < 2){
                            throw new InvalidEventException();
                        }
                        String[] eventParts = inputParts[1].split(" /from | /to ", 3);
                        if (eventParts.length < 3) {
                            throw new InvalidEventException();
                        }
                        storedObjects.add(new Events(eventParts[0], eventParts[1], eventParts[2]));
                        taskCount++;
                        printAddedTask(taskCount, storedObjects);
                    } catch (InvalidEventException e) {
                        System.out.print("            /ᐠ˵x x˵マ ");
                        System.out.println(" Invalid input format \n" + LEADING_SPACE
                                + "To add an event to the list, type: event XX /from XX /to XX (Don't miss out the /!..)");
                    }
                    break;

                case "deadline":
                    try {
                        if (inputParts.length < 2) {
                            throw new InvalidDeadlineException();
                        }
                        String[] deadlineParts = inputParts[1].split(" /by ", 2);
                        if (deadlineParts.length < 2) {
                            throw new InvalidDeadlineException();
                        }
                        storedObjects.add(new Deadlines(deadlineParts[0], deadlineParts[1]));
                        taskCount++;
                        printAddedTask(taskCount, storedObjects);
                    } catch (InvalidDeadlineException e) {
                        System.out.print("            /ᐠ˵x x˵マ ");
                        System.out.println("Invalid input format \n " +
                                LEADING_SPACE + "To add a deadline to the list, type: deadline XX /by XX (Don't miss out the /!..)");
                    }
                    break;

            }
        }

        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");
        scanInputs.close();
        
    }
}
