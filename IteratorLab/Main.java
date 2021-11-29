package IteratorLab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> entries = new ArrayList<>();

        for (;;) {
            String in = input.nextLine();
            if (in.equals("exit")) {
                break;
            }
            entries.add(in);
        }

        input.close();

        entries.add("a b c a b c a     a");
        entries.add("a b c d e f g h i j x x x x     x");
        entries.add("1 2 3 4 5 6 a b c a b c     b");

        Iterator<String> iterator = entries.iterator();

        while (iterator.hasNext()) {
            String[] split = iterator.next().split(" ");

            String removal = split[split.length - 1];

            ArrayList<String> sanitizedEntries = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {
                if (!(split[i].equals(removal) || split[i].equals(""))) {
                    sanitizedEntries.add(split[i]);
                }
            }

            System.out.println(sanitizedEntries);
        }
    }
}
