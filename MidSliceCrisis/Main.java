package MidSliceCrisis;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> entries = new ArrayList<>();

        Scanner fs = new Scanner(new File("C:\\Users\\mchscs012\\Documents\\Java Labs\\MidSliceCrisis\\Crisis.in"));

        while (fs.hasNext()) {
            entries.add(fs.nextLine());
        }

        final int numDataSetsFollowed = Integer.parseInt(entries.remove(0));

        for (int i = 0; i < numDataSetsFollowed; i++) {
            String currentEntry = entries.get(i);

            if (currentEntry.contains("?")) {
                System.out.println("A’ight, wha’ever.");
            } else if (currentEntry.contains(".")) {
                System.out.println("Dood, tha’s jus like you are ‘pinion man.");
            } else if (currentEntry.contains("!")) {
                System.out.println("Quit killin’ me vibes mon.");
            }
        }
    }
}
