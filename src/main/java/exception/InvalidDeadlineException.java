package exception;

import utility.Strings;
import utility.Ui;

public class InvalidDeadlineException extends Exception{
    public static void printErrorMessage() {
        Ui ui = new Ui();
        ui.printMessage("Invalid input format \n " +
                Strings.LEADING_SPACE + "To add a deadline to the list, type: deadline XX /by XX (Don't miss out the /!..)");
    }
}
