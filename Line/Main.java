package Line;

import java.util.*;

public class Main {
    static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] args) {
        MyPoint[] pointData = getPointData();
        Line lineOne = new Line(pointData[0], pointData[1]);
        Line lineTwo = new Line(pointData[2], pointData[3]);

        while (true) {
            printMenu();
            int menuInput = keyboardInput.nextInt();

            switch (menuInput) {
                case 1 -> System.out.println(lineOne);
                case 2 -> System.out.println(lineTwo);
                case 3 -> {
                    changeLine(lineOne);
                }
                case 4 -> {
                    changeLine(lineTwo);
                }
                case 5 -> {
                    MyPoint intersection = Line.findIntersection(lineOne, lineTwo);

                    if (Double.isNaN(intersection.getX()) || Double.isNaN(intersection.getY())) {
                        System.out.println("No valid intersection found.");
                    } else {
                        System.out.println(intersection);
                    }
                }
                default -> {
                    printMenu();
                }
            }
        }

    }

    public static void printMenu() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println("1. View Line One");
        System.out.println("2. View Line Two");
        System.out.println("3. Change Line One");
        System.out.println("4. Change Line Two");
        System.out.println("5. View Intersection");
        System.out.println("////////////////////////////");
        System.out.println("//Please make a selection.//");
        System.out.println("////////////////////////////");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    }

    public static void changeLine(Line inputLine) {
        System.out.println("1. Change Point One");
        System.out.println("2. Change Point Two");
        System.out.println("3. Change Both");
        System.out.println("4. Cancel");

        int selection = keyboardInput.nextInt();

        if (selection == 4) {
            return;
        }

        System.out.println("Enter a new X value");
        double newX = keyboardInput.nextDouble();
        System.out.println("Enter a new Y value");
        double newY = keyboardInput.nextDouble();

        switch (selection) {
            case 1 -> {
                inputLine.setPointOne(new MyPoint(newX, newY));
            }
            case 2 -> {
                inputLine.setPointTwo(new MyPoint(newX, newY));
            }
            case 3 -> {
                inputLine.setPointOne(new MyPoint(newX, newY));
                inputLine.setPointTwo(new MyPoint(newX, newY));
            }
        }
    }

    public static MyPoint[] getPointData() {
        MyPoint[] pointData = new MyPoint[4];

        double tempX;
        double tempY;

        for (int i = 0; i < 4; i++) {
            System.out.println("Provide X Value.");
            tempX = keyboardInput.nextDouble();
            System.out.println("Provide Y Value.");
            tempY = keyboardInput.nextDouble();
            System.out.println("Point Created.\n");
            pointData[i] = new MyPoint(tempX, tempY);
        }

        return pointData;
    }
}
