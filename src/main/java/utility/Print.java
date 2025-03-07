package utility;

import utility.Strings;

public class Print {

    public static void printCommands() {

        System.out.println(Strings.LEADING_SPACE + "To add a task in the list, type: todo XX");
        System.out.println(Strings.LEADING_SPACE + "To add an event in the list, type: event XX /from XX /to XX");
        System.out.println(Strings.LEADING_SPACE + "To add a task with a deadline into the list, type: deadline XX /by XX");
        System.out.println(Strings.LEADING_SPACE + "To remove a task in the list, type: remove [task index]");
        System.out.println(Strings.LEADING_SPACE + "To mark an item as done, type: mark (the task number)");
        System.out.println(Strings.LEADING_SPACE + "To view the current list, type: list");
        System.out.println(Strings.LEADING_SPACE + "To end the conversation with me, type: bye \n");
        System.out.println(Strings.LEADING_SPACE + "Ps Command words are not case sensitive!!");
        System.out.println(Strings.LEADING_SPACE + "XX in the examples are your inputs");
        System.out.println(Strings.LEADING_SPACE + "Hope this makes things easier  /ᐠ˵≡ ≡˵マ");

    }
}
