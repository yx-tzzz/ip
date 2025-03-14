package utility;

import task.*;
import java.util.ArrayList;

public class Ui extends Strings{

    public void printCommands() {

        System.out.println(LEADING_SPACE + "To add a task in the list, type: todo XX");
        System.out.println(LEADING_SPACE + "To add an event in the list, type: event XX /from XX /to XX");
        System.out.println(LEADING_SPACE + "To add a task with a deadline into the list, type: deadline XX /by XX");
        System.out.println(LEADING_SPACE + "To remove a task in the list, type: remove [task index]");
        System.out.println(LEADING_SPACE + "To mark an item as done, type: mark (the task number)");
        System.out.println(LEADING_SPACE + "To view the current list, type: list");
        System.out.println(LEADING_SPACE + "To end the conversation with me, type: bye \n");
        System.out.println(LEADING_SPACE + "Ps Command words are not case sensitive!!");
        System.out.println(LEADING_SPACE + "XX in the examples are your inputs");
        System.out.println(LEADING_SPACE + "Hope this makes things easier  /ᐠ˵≡ ≡˵マ");

    }

    public void printWelcomeMessage() {
        System.out.println("Hello... \n" + LOGO + "I'm void, what can I do for you..?");
        System.out.println("Before I forget, here's a guide I've made to help you, here you gooo");
    }

    public void printTask(int taskCount, TaskList taskList) {
        System.out.println(Strings.LEADING_SPACE + (taskCount) + ". " + taskList.toString(taskCount-1));
    }

    public void printAddedTask(int taskCount, TaskList taskList) {
        System.out.println(ADD_VOID);
        printTask(taskCount, taskList);
        System.out.printf((Strings.TASK_COUNT_MESSAGE) + "%n", taskCount);
    }

    public void printEndMessage() {
        System.out.println(END_VOID);
    }

    public void printEmptyListMessage() {
        System.out.println(Strings.LEADING_SPACE + "List is currently empty, would you like to add some tasks into the list? ^ ，，^");
        System.out.println(Strings.LEADING_SPACE + "Here's the guide on how to use me in case you forgotz\n");
    }

    public void printAllTask(int taskCount, TaskList taskList) {
        for (int i = 0; i < taskCount; i++) {
            printTask(i + 1, taskList);
        }
    }

    public void printMessage (String string) {
        System.out.println(string);
    }
}
