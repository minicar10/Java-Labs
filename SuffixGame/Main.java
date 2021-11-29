package SuffixGame;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("C:\\Users\\mchscs012\\Documents\\Java Labs\\SuffixGame\\suffixgame.in"));

        ArrayList<String> data = new ArrayList<>();
        ArrayList<String[]> couples = new ArrayList<>();

        while (reader.hasNextLine()) {
            data.add(reader.nextLine());
        }

        int trials = Integer.parseInt(data.remove(0)) / 2;

        for (int i = 0; i < data.size(); i += 2) {
            couples.add(new String[] { data.get(i), data.get(i + 1) });
        }

        for (int i = 0; i < trials; i++) {
            System.out.println("Game #" + (i + 1) + ":");
            System.out.println(String.format("\tThe input words are %s and %s", couples.get(i)[0], couples.get(i)[1]));
            System.out.println(String.format("\tthe words entered in the notebook are %s and %s",
                    returnFinalStrings(couples.get(i))[0], returnFinalStrings(couples.get(i))[1]));
        }
    }

    public static String[] returnFinalStrings(String[] input) {
        String invertedCoupleOne = reverse(input[0]);
        String invertedCoupleTwo = reverse(input[1]);

        int shortestLength = Math.min(input[0].length(), input[1].length());

        for (int i = 0; i < shortestLength - 1; i++) {
            if (invertedCoupleOne.charAt(i) == invertedCoupleTwo.charAt(i)) {
                invertedCoupleOne = invertedCoupleOne.substring(i, invertedCoupleOne.length());
                invertedCoupleTwo = invertedCoupleTwo.substring(i, invertedCoupleTwo.length());
            } else {
                break;
            }
        }

        return new String[] { reverse(invertedCoupleOne), reverse(invertedCoupleTwo) };
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
