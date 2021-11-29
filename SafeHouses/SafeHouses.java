/** 
 * Erick Torres,
 * Beck - 4th,
 * Computer Science 3, 
 * 25 August, 2021
 */

package SafeHouses;

import java.util.*;
import java.io.*;

public class SafeHouses {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/SafeHouses/safehouses.in"));
        ArrayList<String> fileParsedValues = new ArrayList<>();
        ArrayList<String> subsequentValues = new ArrayList<>();
        ArrayList<Integer> houseNumbers = new ArrayList<>();

        while (fileReader.hasNext()) {
            fileParsedValues.add(fileReader.nextLine());
        }

        int numberOfTrials = Integer.parseInt(fileParsedValues.get(0));

        for (int i = 1; i < fileParsedValues.size(); i++) {
            subsequentValues.add(fileParsedValues.get(i));
        }

        for (int i = 0; i < subsequentValues.size(); i++) {
            int houseNumber = Integer.parseInt(subsequentValues.get(i).split(" ")[0]);
            houseNumbers.add(houseNumber);
        }

        for (int i = 0; i < subsequentValues.size(); i++) {
            if (numberOfTrials > 0) {
                if (houseNumbers.get(i) % 7 != 0) {
                    System.out.println("DANGER!");
                } else {
                    System.out.println(subsequentValues.get(i));
                }
                numberOfTrials--;
            }
        }
    }
}
