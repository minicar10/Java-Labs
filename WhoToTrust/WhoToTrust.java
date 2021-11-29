/** 
 * Erick Torres,
 * Beck - 4th,
 * Computer Science 3, 
 * 25 August, 2021
 */

package WhoToTrust;

import java.util.*;
import java.io.*;

public class WhoToTrust {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/WhoToTrust/trust.in"));
        ArrayList<String> fileParsedValues = new ArrayList<>();
        ArrayList<String> subsequentValues = new ArrayList<>();

        while (fileReader.hasNext()) {
            fileParsedValues.add(fileReader.nextLine());
        }

        int numberOfTrials = Integer.parseInt(fileParsedValues.get(0));

        for (int i = 1; i < fileParsedValues.size(); i++) {
            subsequentValues.add(fileParsedValues.get(i));
        }

        for (int i = 0; i < subsequentValues.size(); i++) {
            if (numberOfTrials > 0) {
                String sanitizedString = subsequentValues.get(i).toLowerCase().replace(" ", "");
                if (sanitizedString.contains("forest")) {
                    System.out.println("TWO-TWELVE!");
                } else {
                    System.out.println("Glory to Stroudonia...");
                }
                numberOfTrials--;
            }
        }
    }
}
