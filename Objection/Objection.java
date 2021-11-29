package Objection;

import java.util.*;

import java.io.*;

public class Objection {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("C:/Users/mchscs012/Documents/Java Labs/Objection/objection.in"));
        ArrayList<Integer> fileParsedValues = new ArrayList<>();
        ArrayList<Integer> objectionsBeforeHolding = new ArrayList<>();

        while (fileReader.hasNext()) {
            fileParsedValues.add(fileReader.nextInt());
        }

        final int numberOfTrials = fileParsedValues.get(0);

        for (int i = 1; i < fileParsedValues.size(); i++) {
            objectionsBeforeHolding.add(fileParsedValues.get(i));
        }

        for (int i = 0; i < numberOfTrials; i++) {
            if (objectionsBeforeHolding.get(i) >= 0) {
                for (int j = 0; j < objectionsBeforeHolding.get(i); j++) {
                    System.out.println("Objection!");
                }
                System.out.println("HOLD IT!\n");
            } else {
                System.out.println("GUILTY!");
                return;
            }
        }
    }
}
