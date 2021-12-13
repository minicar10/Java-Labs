package ChristmasFun;

import java.io.*;
import java.util.*;

public class Graveyard {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ChristmasFun\\data\\graveyard.dat"));

        Map<Character, Integer> letters = new HashMap<>();
        String buffer = "";

        while (scanner.hasNextLine()) {
            char[] temp = scanner.nextLine().toCharArray();

            for (char character : temp) {
                if (isAsciiLetter(character)) {
                    buffer += String.valueOf(character);
                }
            }
        }

        buffer = buffer.toUpperCase();

        for (char character : buffer.toCharArray()) {
            if (letters.get(character) == null) {
                letters.put(character, 1);
            } else {
                letters.put(character, letters.get(character).intValue() + 1);
            }
        }

        List<Map.Entry<Character, Integer>> sortedValueList = new LinkedList<>(letters.entrySet());

        Collections.sort(sortedValueList, (one, two) -> -(one.getValue().compareTo(two.getValue())));

        for (Map.Entry<Character, Integer> entry : sortedValueList) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
            System.out.println();
        }
    }

    static boolean isAsciiLetter(Character c) {
        return c.hashCode() >= 65 && c.hashCode() <= 122;
    }
}
