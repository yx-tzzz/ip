package utility;

import exception.InvalidDeadlineException;
import exception.InvalidEventException;
import exception.InvalidRemoveException;
import exception.InvalidTodoException;
import task.Deadlines;
import task.Events;
import task.Todos;

public class Parser {

    private TaskList taskList;
    private Storage storage;
    private Ui ui;

    public Parser(TaskList taskList, Storage storage, Ui ui) {
        this.taskList = taskList;
        this.storage = storage;
        this.ui = ui;
    }

    public boolean parseCommand(String userInput) {
        String[] inputParts = userInput.split(" ",2);
        String command = inputParts[0].toLowerCase();
        int taskCount = taskList.taskCount();

        if (command.equals("bye")) {
            storage.saveTasks(taskList);
            return false;
        } else {
            switch (command) {
                case "list":
                    System.out.println(Strings.LIST_VOID);
                    if (taskList.isEmpty()) {
                        ui.printEmptyListMessage();
                        ui.printCommands();
                    } else {
                        ui.printAllTask(taskCount, taskList);
                    }
                    break;

                case "mark":
                    try {
                        int objectIndex = Integer.parseInt(inputParts[1]) - 1;
                        taskList.markTask(objectIndex);
                        System.out.print("            /ᐠ˵, ,˵マ ");
                        System.out.println("Nice! I've marked this task as done:");
                        ui.printTask(objectIndex + 1, taskList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid as there are " + taskCount +
                                " items in the list, please select a number in the range to mark item as done");
                    } catch (NumberFormatException e) {
                        System.out.print(Strings.ERROR_VOID);
                        System.out.println("Invalid input, please enter an integer from 1 to " + taskCount + "after the input command mark");
                    }
                    break;


                case "todo":
                    try {
                        if (inputParts.length < 2) {
                            throw new InvalidTodoException();
                        }
                        taskList.addTask(new Todos(inputParts[1].trim()));
                        taskCount++;
                        ui.printAddedTask(taskCount, taskList);
                    } catch (InvalidTodoException e) {
                        System.out.print(Strings.ERROR_VOID);
                        InvalidTodoException.printErrorMessage();
                    }
                    break;

                case "event":
                    try {
                        if (inputParts.length < 2) {
                            throw new InvalidEventException();
                        }
                        String[] eventParts = inputParts[1].split(" /from | /to ", 3);
                        if (eventParts.length < 3) {
                            throw new InvalidEventException();
                        }
                        taskList.addTask(new Events(eventParts[0], eventParts[1], eventParts[2]));
                        taskCount++;
                        ui.printAddedTask(taskCount, taskList);
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
                        taskList.addTask(new Deadlines(deadlineParts[0], deadlineParts[1]));
                        taskCount++;
                        ui.printAddedTask(taskCount, taskList);
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
                        System.out.println(Strings.REMOVE_VOID + " removed: " + indexToRemove + "." + taskList.toString(indexToRemove));
                        taskList.removeTask(indexToRemove);
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
                    ui.printCommands();
            }
            return true;
        }
    }
}
