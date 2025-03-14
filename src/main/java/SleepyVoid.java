import utility.*;

import java.util.Scanner;

/**
 * The SleepyVoid class is a chatbot named SleepyVoid that manages all tasks.
 * Represents a chatbot SleepyVoid that manages task list, storage, ui and parser objects
 * to manage tasks inputted by the user.
 */

public class SleepyVoid {
    private static TaskList taskList;
    private static Ui ui;
    private static Storage storage;
    private static Parser parser;

    /**
     * Creates a new instance of {@code SleepyVoid}.
     * Initializes the user interface, storage, parser, and loads tasks from the text file.
     */
    public SleepyVoid() {
        ui = new Ui();
        storage = new Storage();
        taskList = new TaskList(storage.loadTasks());
        parser = new Parser(taskList, storage, ui);
    }

    /**
     * Runs SleepyVoid chatbot application.
     * Displays a welcome message, shows available commands, then continuously processes user commands.
     * Chatbot ends and exits when the user inputs "bye".
     */
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

    /**
     * The entry point of the program.
     * Initializes and runs the chatbot.
     * @param args Command-line arguments not used in this application.
     */
    public static void main(String[] args) {
        new SleepyVoid().run();
    }

}





