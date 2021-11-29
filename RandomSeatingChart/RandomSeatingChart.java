package RandomSeatingChart;

import java.util.*;

public class RandomSeatingChart {

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> seats = new ArrayList<>();
        int numberOfSeats;

        System.out.println("Please enter in the name of each student. Type 'Done' to complete entry.");

        for (;;) {
            String input = keyboardInput.nextLine();
            if (input.equals("Done")) {
                break;
            }
            names.add(input);
        }

        System.out.println("Please enter the number of seats in the classroom.");
        numberOfSeats = keyboardInput.nextInt();
        keyboardInput.close();

        if (numberOfSeats < names.size()) {
            System.out.println("Error not enough seats in your class");
            return;
        }

        for (int i = 0; i < numberOfSeats; i++) {
            seats.add(i);
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.println(randomSeat(seats));
            System.out.println(names.get(i));
            System.out.println("-----------------------------------");
        }
    }

    public static int randomSeat(ArrayList<Integer> seats) {
        Random random = new Random();
        Integer randomValue = random.nextInt(seats.size());
        seats.remove(randomValue);

        return randomValue;
    }
}
