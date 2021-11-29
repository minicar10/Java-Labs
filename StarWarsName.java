import java.util.*;

public class StarWarsName {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("Please type in your first and last name.");

        String names = keyboardInput.nextLine();
        String firstName = names.split(" ")[0];
        String lastName = names.split(" ")[1];

        System.out.println("Please enter your city of birth.");
        String birthplace = keyboardInput.nextLine();

        System.out.println("Please enter your mother's maiden name.");
        String maidenName = keyboardInput.nextLine();

        keyboardInput.close();

        System.out.println("My name is " + firstName + " " + lastName + ".");
        System.out.println("I was born in " + birthplace);
        System.out.println("My mother's maiden name is " + maidenName);
        System.out
                .println("My star Wars name is " + determineStarWarsName(firstName, lastName, maidenName, birthplace));
    }

    public static String determineStarWarsName(String first, String last, String maiden, String birthplace) {
        String firstName = last.substring(0, 3) + first.substring(0, 2);
        String lastName = maiden.substring(0, 2) + birthplace.substring(0, 3);

        return firstName + " " + lastName;
    }
}
