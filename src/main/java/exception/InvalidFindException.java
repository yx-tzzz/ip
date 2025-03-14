package exception;

import utility.Strings;
import utility.Ui;

public class InvalidFindException extends Exception{
    public static void printErrorMessage() {
        Ui ui = new Ui();
        ui.printMessage("Invalid input format, please add the keyword you want to find after the command \n" +
                Strings.LEADING_SPACE + "eg To find tasks with the related keyword in the list, type: find [keyword]");
    }
}
