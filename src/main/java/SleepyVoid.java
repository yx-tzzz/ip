import exception.InvalidDeadlineException;
import exception.InvalidEventException;
import exception.InvalidTodoException;
import exception.InvalidRemoveException;
import utility.*;
import task.*;

import java.util.Scanner;
import java.util.ArrayList;

public class SleepyVoid {

    public static void printTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println(Strings.LEADING_SPACE + (taskCount) + ". " + storedObjects.get(taskCount-1).toString());
    }

    public static void printAddedTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println("            /ᐠ˵+ +˵マ added: " );
        printTask(taskCount, storedObjects);
        System.out.printf((Strings.TASK_COUNT_MESSAGE) + "%n", taskCount);
    }



    public static void main(String[] args) {

        System.out.println("Hello... \n" + Strings.LOGO + "I'm void, what can I do for you..?");
        System.out.println("Before I forget, here's a guide I've made to help you, here you gooo");
        Print.printCommands();

        Scanner scanInputs = new Scanner(System.in);
        Files storage = new Files();
        ArrayList<Task> storedObjects = new ArrayList<Task>();
        storedObjects = storage.loadTasks();
        int taskCount = storedObjects.size();
        boolean isChatRunning = true;

        while(isChatRunning){
            String userInput = scanInputs.nextLine().trim();
            String[] inputParts = userInput.split(" ",2);
            String command = inputParts[0].toLowerCase();

            switch(command) {
                case "bye":
                    storage.saveTasks(storedObjects);
                    isChatRunning = false;
                    break;

                case "list":
                    System.out.println(Strings.LIST_VOID);
                    if (storedObjects.isEmpty()) {
                        System.out.println(Strings.LEADING_SPACE + "List is currently empty, would you like to add some tasks into the list? ^ ，，^");
                        System.out.println(Strings.LEADING_SPACE + "Here's the guide on how to use me in case you forgotz\n");
                        Print.printCommands();
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
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid as there are " + taskCount +
                                " items in the list, please select a number in the range to mark item as done" );
                    } catch (NumberFormatException e) {
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid input, please enter an integer from 1 to " + taskCount + "after the input command mark" );
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
                        System.out.print(Strings.ERROR_VOID);
                        InvalidTodoException.printErrorMessage();
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
                        System.out.print(Strings.ERROR_VOID);
                        InvalidEventException.printErrorMessage();
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
                        System.out.print(Strings.ERROR_VOID);
                        InvalidDeadlineException.printErrorMessage();
                    }
                    break;

                case "remove":
                    try {
                        if (inputParts.length < 2) {
                            throw new InvalidRemoveException();
                        }
                        int indexToRemove = Integer.parseInt(inputParts[1]) - 1;
                        System.out.println("            /ᐠ˵- -˵マ removed: " + indexToRemove + "." + storedObjects.get(indexToRemove).toString());
                        storedObjects.remove(indexToRemove);
                        taskCount--;
                    } catch (InvalidRemoveException e) {
                        System.out.print(Strings.ERROR_VOID);
                        InvalidRemoveException.printErrorMessage();
                    } catch (NumberFormatException e) {
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid input format, please ensure the input after the command is a number \n " +
                                Strings.LEADING_SPACE + "eg To remove a task to the list, type: remove [task index]");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid input format, please ensure the number is an existing task number\n " +
                                Strings.LEADING_SPACE + "eg To remove a task to the list, type: remove [task index]");
                    }
                    break;

                default:
                    System.out.println(Strings.LEADING_SPACE + inputParts[0] + "is an invalid command, please use any of the commands listed below");
                    Print.printCommands();

            }
        }

        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");
        scanInputs.close();
        
    }
}
