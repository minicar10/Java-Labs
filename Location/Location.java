package Location;

import java.util.*;

import java.io.*;

public class Location {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/Location/location.in"));
        ArrayList<String> parsedValues = new ArrayList<>();
        ArrayList<String> sentenceHolder = new ArrayList<>();
        int numberOfLines;

        while (fileScanner.hasNext()) {
            parsedValues.add(fileScanner.nextLine());
        }

        numberOfLines = Integer.parseInt(parsedValues.get(0));

        for (int i = 1; i < parsedValues.size(); i++) {
            if (numberOfLines > 0) {
                String[] extractedWords = parsedValues.get(i).split(" ");
                sentenceHolder.add(extractedWords[0]);
                sentenceHolder.add(extractedWords[extractedWords.length - 1]);
            } else {
                break;
            }
        }

        for (int i = 0; i < sentenceHolder.size(); i++) {
            if (i < sentenceHolder.size() - 1) {
                System.out.print(sentenceHolder.get(i) + " ");
            } else {
                System.out.print(sentenceHolder.get(i) + ".");
            }
        }
    }
}
