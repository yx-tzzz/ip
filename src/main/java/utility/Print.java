package utility;

import task.*;
import java.util.ArrayList;

public class Print extends Strings{

    public static void commands() {

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

    public static void welcomeMessage() {
        System.out.println("Hello... \n" + LOGO + "I'm void, what can I do for you..?");
        System.out.println("Before I forget, here's a guide I've made to help you, here you gooo");
    }

    public static void printTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println(Strings.LEADING_SPACE + (taskCount) + ". " + storedObjects.get(taskCount-1).toString());
    }

    public static void printAddedTask(int taskCount, ArrayList<Task> storedObjects) {
        System.out.println(ADD_VOID);
        printTask(taskCount, storedObjects);
        System.out.printf((Strings.TASK_COUNT_MESSAGE) + "%n", taskCount);
    }

    public static void endMessage() {
        System.out.println(END_VOID);
    }
}
