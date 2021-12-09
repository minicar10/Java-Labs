package ChristmasFun;

import java.util.*;
import java.io.*;

public class Lycanthropy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ChristmasFun\\data\\lycanthropy.dat"));
        ArrayList<Double[]> entries = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");

            double one = Double.parseDouble(split[0]);
            double two = Double.parseDouble(split[1]);

            entries.add(new Double[] { one, two });
        }

        for (Double[] entry : entries) {
            System.out.printf("%.3f\n", getDosage(entry[0], entry[1]));
        }
    }

    static double getDosage(double weight, double moonlightIntensity) {
        return Math.pow(weight * 3.14, 0.333) / Math.pow(moonlightIntensity + 1234567890, 0.2);
    }
}
