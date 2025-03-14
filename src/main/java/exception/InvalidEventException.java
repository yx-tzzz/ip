package exception;

import utility.Strings;
import utility.Ui;

public class InvalidEventException extends Exception {
    public static void printErrorMessage() {
        Ui ui = new Ui();
        ui.printMessage(" Invalid input format \n" + Strings.LEADING_SPACE
                + "To add an event to the list, type: event XX /from XX /to XX (Don't miss out the /!..)");
    }
}
