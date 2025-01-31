import java.util.Scanner;

public class SleepyVoid {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
        String logo = "   /\\_/\\  \n" +
                     "  / _ _ \\ \n" +
                    " /       \\ \n" +
                    "|   >o<   | \n" +
                    "\\   _ _   / \n";
        System.out.println("Hello... \n" + logo + "I'm void, what can I do for you..?");
        Scanner scanInputs = new Scanner(System.in);
        boolean isChatRunning = true;
        while(isChatRunning){
            String userInput = scanInputs.nextLine().trim();

            if (userInput.equalsIgnoreCase("bye")){
                isChatRunning = false;
            }
            else {
                System.out.println("            " +
                        "/ᐠ˵- -˵マ: " + userInput);
            }
        }
        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");

        
    }
}
