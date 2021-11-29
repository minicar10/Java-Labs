import java.util.*;

public class StringLab {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        for (;;) {
            System.out.println("Enter in a string, type 'exit' to leave.");
            String input = keyboardInput.nextLine();
            System.out.println("Raw Input String: " + input);
            if (input.equals("exit")) {
                keyboardInput.close();
                System.out.println("Exiting");
                return;
            }
            System.out.println("Converted String: " + convertToAsteriskString(input));
        }
    }

    public static String convertToAsteriskString(String inputString) {
        String[] separatedArray = inputString.split(" ");
        String returnString = "";

        for (int i = 0; i < separatedArray.length; i++) {
            if (i < separatedArray.length - 1) {
                if (separatedArray[i].length() == 4) {
                    separatedArray[i] = "****";
                }
            } else {
                if (separatedArray[i].length() == 5) {
                    separatedArray[i] = "****.";
                }
            }
        }

        for (int i = 0; i < separatedArray.length; i++) {
            returnString += separatedArray[i];
            if (i < separatedArray.length - 1) {
                returnString += " ";
            }
        }

        return returnString;
    }
}