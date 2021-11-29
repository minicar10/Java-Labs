package Crossing;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fs = new Scanner(new File("C:\\Users\\mchscs012\\Documents\\Java Labs\\Crossing\\crossing.in"));
        ArrayList<String> entries = new ArrayList<>();
        int numTestCases;

        while (fs.hasNextLine()) {
            entries.add(fs.nextLine());
        }

        numTestCases = Integer.parseInt(entries.remove(0));
    }
}
