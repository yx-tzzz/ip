package exception;

import utility.Strings;

public class InvalidTodoException extends Exception{
    public static void printErrorMessage() {
        System.out.println("Missing input after the todo command, please key in the task after the todo command (eg todo XX)");
    }
}
