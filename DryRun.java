import java.util.*;
import java.io.*;

public class DryRun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("T:\\MCHS\\CS Club\\DryRun\\dryrun.dat"));
        ArrayList<String> values = new ArrayList<>();
        int linesToFollow;

        while (fileScanner.hasNextLine()) {
            values.add(fileScanner.nextLine());
        }

        linesToFollow = Integer.parseInt(values.remove(0));

        for (int i = 0; i < values.size(); i++) {
            System.out.println("Mayde to " + values.get(i) + "!");
            linesToFollow--;
            if (linesToFollow == 0) {
                return;
            }
        }
    }
}
