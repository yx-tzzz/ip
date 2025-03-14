package exception;

import utility.Strings;
import utility.Ui;

public class InvalidRemoveException extends Exception{
    public static void printErrorMessage() {
        Ui ui = new Ui();
        ui.printMessage("Invalid input format, please add the task number after the command \n" +
                Strings.LEADING_SPACE + "eg To remove a task in the list, type: remove [task index]");
    }
}
