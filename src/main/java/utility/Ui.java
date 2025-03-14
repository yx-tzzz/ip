package utility;

/**
 * The Ui class handles user interface interactions, such as displaying messages,
 * commands, and task-related information to the user.
 * It extends the `Strings` class to access commonly used Strings and ASCII art.
 */
public class Ui extends Strings{

    /**
     * Displays a list of available commands and their usage instructions to the user.
     * This includes commands for adding tasks, marking tasks as done, viewing the task list, finding keywords,
     * and ending the chat.
     */
    public void printCommands() {

        System.out.println(LEADING_SPACE + "To add a task in the list, type: todo XX");
        System.out.println(LEADING_SPACE + "To add an event in the list, type: event XX /from XX /to XX");
        System.out.println(LEADING_SPACE + "To add a task with a deadline into the list, type: deadline XX /by XX");
        System.out.println(LEADING_SPACE + "To remove a task in the list, type: remove [task index]");
        System.out.println(LEADING_SPACE + "To mark an item as done, type: mark [task index]");
        System.out.println(LEADING_SPACE + "To view the current list, type: list");
        System.out.println(LEADING_SPACE + "To find task/s that contain a particular keyword, type: find (keyword)");
        System.out.println(LEADING_SPACE + "To end the conversation with me, type: bye \n");
        System.out.println(LEADING_SPACE + "Ps Command words are not case sensitive!!");
        System.out.println(LEADING_SPACE + "XX in the examples are your inputs");
        System.out.println(LEADING_SPACE + "Hope this makes things easier  /ᐠ˵≡ ≡˵マ");

    }

    /**
     * Displays a welcome message to the user, which contains the chatbot logo and a brief introduction.
     */
    public void printWelcomeMessage() {
        System.out.println("Hello... \n" + LOGO + "I'm void, what can I do for you..?");
        System.out.println("Before I forget, here's a guide I've made to help you, here you gooo");
    }

    /**
     * Displays a specific task from the task list.
     *
     * @param taskCount  The index of the task to display.
     * @param taskList   The task list containing the task to display.
     */
    public void printTask(int taskCount, TaskList taskList) {
        System.out.println(Strings.LEADING_SPACE + (taskCount) + ". " + taskList.toString(taskCount-1));
    }

    /**
     * Displays the task that has been added to the task list,
     * together with the total number of tasks in the list.
     *
     * @param taskCount  The total number of tasks in the list after adding the new task.
     * @param taskList   The task list containing the newly added task.
     */
    public void printAddedTask(int taskCount, TaskList taskList) {
        System.out.println(ADD_VOID);
        printTask(taskCount, taskList);
        System.out.printf((Strings.TASK_COUNT_MESSAGE) + "%n", taskCount);
    }

    /**
     * Displays a goodbye message to the user when the conversation ends.
     */
    public void printEndMessage() {
        System.out.println(END_VOID);
    }

    /**
     * Displays a message indicating that the task list is currently empty.
     * Provides a reminder of the available commands to help the user add tasks.
     */
    public void printEmptyListMessage() {
        System.out.println(Strings.LEADING_SPACE + "List is currently empty, would you like to add some tasks into the list? ^ ，，^");
        System.out.println(Strings.LEADING_SPACE + "Here's the guide on how to use me in case you forgotz\n");
    }

    /**
     * Displays all the tasks currently in the task list.
     *
     * @param taskCount  The total number of tasks in the list.
     * @param taskList   The task list containing all tasks to display.
     */
    public void printAllTask(int taskCount, TaskList taskList) {
        for (int i = 0; i < taskCount; i++) {
            printTask(i + 1, taskList);
        }
    }
}
