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
        String[] storedObjects = new String[100];
        int count = 0;
        boolean isChatRunning = true;
        while(isChatRunning){
            String userInput = scanInputs.nextLine().trim();

            if (userInput.equalsIgnoreCase("bye")){
                isChatRunning = false;
            }
            else if (userInput.equalsIgnoreCase("list")){
                System.out.println("            /ᐠ˵- -˵マ: ");
                for (int i = 0; i<count; i++){
                    System.out.println("                " + (i+1) + ". " + storedObjects[i]);
                }
            }
            else {
                storedObjects[count] = userInput;
                count++;
                System.out.println("            " +
                        "/ᐠ˵- -˵マ added: " + userInput);
            }
        }
        System.out.println("            "
                + "/ᐠ˵_ _˵マ ᶻ\uD835\uDE07\uD803\uDC01: Bye, see you soonᶻ \uD835\uDE07 \uD803\uDC01");

        
    }
}
