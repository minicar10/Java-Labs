package Acronyms;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> entries = new ArrayList<String>();
        Scanner scanner = new Scanner(new File("Acronyms\\input.dat"));
        Map<String, String> map = new HashMap<String, String>();

        while (scanner.hasNext()) {
            entries.add(scanner.nextLine());
        }

        int numEntries = Integer.parseInt(entries.remove(0));

        for (int i = 0; i < numEntries; i++) {
            String[] entry = entries.get(i).split(" - ");
            map.put(entry[0], entry[1]);
        }

        ArrayList<String> output = new ArrayList<String>();
        Arrays.asList(entries.get(entries.size() - 1).split(" ")).forEach(word -> {
            if (map.containsKey(word)) {
                output.add(map.get(word));
            } else {
                output.add(word);
            }
        });

        System.out.println(output.stream().reduce((a, b) -> a + " " + b).get());
    }
}
