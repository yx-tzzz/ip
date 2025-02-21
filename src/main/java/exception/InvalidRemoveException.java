package exception;

import utility.Strings;

public class InvalidRemoveException extends Exception{
    public static void printErrorMessage() {
        System.out.println("Invalid input format, please add the task number after the command \n" +
                Strings.LEADING_SPACE + "eg To remove a task to the list, type: remove [task index]");
    }
}
