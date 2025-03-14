package exception;

import utility.Strings;
import utility.Ui;

public class InvalidTodoException extends Exception{
    public static void printErrorMessage() {
        Ui ui = new Ui();
        ui.printMessage("Missing input after the todo command, please key in the task after the todo command (eg todo XX)");
    }
}
