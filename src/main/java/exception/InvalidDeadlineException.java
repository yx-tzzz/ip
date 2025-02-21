package exception;

import utility.Strings;

public class InvalidDeadlineException extends Exception{
    public static void printErrorMessage() {
        System.out.println("Invalid input format \n " +
                Strings.LEADING_SPACE + "To add a deadline to the list, type: deadline XX /by XX (Don't miss out the /!..)");
    }
}
