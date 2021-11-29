package VideoStore;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();

        Scanner keyboardInput = new Scanner(System.in);

        for (;;) {
            System.out.println("------OPTIONS------");
            System.out.println("1. Rent Movie");
            System.out.println("2. Rent Games");
            System.out.println("3. Check Out");
            System.out.println("4. Exit Terminal");
            System.out.println("Please make an input");
            int input = keyboardInput.nextInt();

            switch (input) {
                case 1 -> {
                    ArrayList<Video> videosInStock = videoStore.videosInStock();

                    for (int i = 0; i < videosInStock.size(); i++) {
                        System.out.println(i + ". " + videosInStock.get(i));
                    }

                    System.out.println("EXIT");
                    System.out.println("Your selection?");

                    String innerInput = keyboardInput.nextLine();

                    if (innerInput.equalsIgnoreCase("EXIT")) {
                        break;
                    } else {
                        videoStore.addRental(videosInStock.get(Integer.parseInt(innerInput)));
                    }
                }
                case 2 -> {
                    ArrayList<Game> gamesInStock = videoStore.gamesInStock();

                    for (int i = 0; i < gamesInStock.size(); i++) {
                        System.out.println(i + ". " + gamesInStock.get(i));
                    }

                    System.out.println("EXIT");
                    System.out.println("Your selection?");

                    String innerInput = keyboardInput.nextLine();

                    if (innerInput.equalsIgnoreCase("EXIT")) {
                        break;
                    } else {
                        videoStore.addRental(gamesInStock.get(Integer.parseInt(innerInput)));
                    }
                }
            }
        }
    }
}
