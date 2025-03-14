import exception.InvalidDeadlineException;
import exception.InvalidEventException;
import exception.InvalidTodoException;
import exception.InvalidRemoveException;
import utility.*;
import task.*;

import java.util.Scanner;
import java.util.ArrayList;

public class SleepyVoid {
    private static TaskList taskList;
    private static Ui ui;
    private static Storage storage;
    private static Parser parser;


    public SleepyVoid() {
        ui = new Ui();
        storage = new Storage();
        taskList = new TaskList(storage.loadTasks());
        parser = new Parser(taskList, storage, ui);
    }

    public void run() {
        ui.printWelcomeMessage();
        ui.printCommands();
        Scanner scanInputs = new Scanner(System.in);
        boolean isChatRunning = true;

        while (isChatRunning) {
            String userInput = scanInputs.nextLine().trim();
            isChatRunning = parser.parseCommand(userInput);
        }
        ui.printEndMessage();
        scanInputs.close();
    }

    public static void main(String[] args) {
        new SleepyVoid().run();
    }

}










//    public static void main(String[] args) {
//
//        Ui.printWelcomeMessage();
//        Ui.printCommands();
//
//        Scanner scanInputs = new Scanner(System.in);
//        ui = new Ui();
//        storage = new Storage();
//        ArrayList<Task> storedObjects = new ArrayList<Task>();
//        storedObjects = storage.loadTasks();
//        int taskCount = storedObjects.size();
//        boolean isChatRunning = true;
//
//        while(isChatRunning){
//            String userInput = scanInputs.nextLine().trim();
//            String[] inputParts = userInput.split(" ",2);
//            String command = inputParts[0].toLowerCase();
//
//            switch (command) {
//                case "bye":
//                    storage.saveTasks(storedObjects);
//                    isChatRunning = false;
//                    break;
//
//                case "list":
//                    System.out.println(Strings.LIST_VOID);
//                    if (storedObjects.isEmpty()) {
//                        Ui.printEmptyListMessage();
//                        Ui.printCommands();
//                    } else {
//                        Ui.printAllTask(taskCount, storedObjects);
//                    }
//                    break;
//
//                case "mark":
//                    try {
//                        int objectIndex = Integer.parseInt(inputParts[1]) - 1;
//                        storedObjects.get(objectIndex).markAsDone();
//                        System.out.print("            /ᐠ˵, ,˵マ ");
//                        System.out.println("Nice! I've marked this task as done:");
//                        Ui.printTask(objectIndex + 1, storedObjects);
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        System.out.println("Invalid as there are " + taskCount +
//                                " items in the list, please select a number in the range to mark item as done");
//                    } catch (NumberFormatException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        System.out.println("Invalid input, please enter an integer from 1 to " + taskCount + "after the input command mark");
//                    }
//                    break;
//
//
//                case "todo":
//                    try {
//                        if (inputParts.length < 2) {
//                            throw new InvalidTodoException();
//                        }
//                        storedObjects.add(new Todos(inputParts[1].trim()));
//                        taskCount++;
//                        Ui.printAddedTask(taskCount, storedObjects);
//                    } catch (InvalidTodoException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        InvalidTodoException.printErrorMessage();
//                    }
//                    break;
//
//                case "event":
//                    try {
//                        if (inputParts.length < 2) {
//                            throw new InvalidEventException();
//                        }
//                        String[] eventParts = inputParts[1].split(" /from | /to ", 3);
//                        if (eventParts.length < 3) {
//                            throw new InvalidEventException();
//                        }
//                        storedObjects.add(new Events(eventParts[0], eventParts[1], eventParts[2]));
//                        taskCount++;
//                        Ui.printAddedTask(taskCount, storedObjects);
//                    } catch (InvalidEventException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        InvalidEventException.printErrorMessage();
//                    }
//                    break;
//
//                case "deadline":
//                    try {
//                        if (inputParts.length < 2) {
//                            throw new InvalidDeadlineException();
//                        }
//                        String[] deadlineParts = inputParts[1].split(" /by ", 2);
//                        if (deadlineParts.length < 2) {
//                            throw new InvalidDeadlineException();
//                        }
//                        storedObjects.add(new Deadlines(deadlineParts[0], deadlineParts[1]));
//                        taskCount++;
//                        Ui.printAddedTask(taskCount, storedObjects);
//                    } catch (InvalidDeadlineException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        InvalidDeadlineException.printErrorMessage();
//                    }
//                    break;
//
//                case "remove":
//                    try {
//                        if (inputParts.length < 2) {
//                            throw new InvalidRemoveException();
//                        }
//                        int indexToRemove = Integer.parseInt(inputParts[1]) - 1;
//                        System.out.println("            /ᐠ˵- -˵マ removed: " + indexToRemove + "." + storedObjects.get(indexToRemove).toString());
//                        storedObjects.remove(indexToRemove);
//                        taskCount--;
//                    } catch (InvalidRemoveException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        InvalidRemoveException.printErrorMessage();
//                    } catch (NumberFormatException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        System.out.println("Invalid input format, please ensure the input after the command is a number \n " +
//                                Strings.LEADING_SPACE + "eg To remove a task to the list, type: remove [task index]");
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.print(Strings.ERROR_VOID);
//                        System.out.println("Invalid input format, please ensure the number is an existing task number\n " +
//                                Strings.LEADING_SPACE + "eg To remove a task to the list, type: remove [task index]");
//                    }
//                    break;
//
//                default:
//                    System.out.println(Strings.LEADING_SPACE + inputParts[0] + "is an invalid command, please use any of the commands listed below");
//                    Ui.printCommands();
//
//            }
//
//        }
//        Ui.printEndMessage();
//        scanInputs.close();
//    }

