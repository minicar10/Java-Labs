package LinkedListTester;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        Scanner scanner = new Scanner(System.in);

        for (;;) {
            System.out.println("OPTIONS:");
            System.out.println(" 1. SIZE – RETURNS THE NUMBER OF ITEMS IN THE LIST");
            System.out.println(" 2. PRINT – PRINTS THE VALUES CONTAINED IN THE LIST");
            System.out.println(" 3. PRINT FIRST – PRINTS THE VALUE OF FIRST");
            System.out.println(" 4. PRINT LAST– PRINTS THE VALUE OF THE LAST");
            System.out.println(" 5. GET LOCATION – PRINTS THE ITEM AT SPOT X");
            System.out.println(" 6. REMOVE FIRST – REMOVES FIRST AND PRINTS ITS VALUE");
            System.out.println(" 7. REMOVE LAST – REMOVES LAST AND PRINTS ITS VALUE");
            System.out.println(" 8. REMOVE X – REMOVES AND PRINTS THE ITEM AT SPOT X");
            System.out.println(" 9. ADD TO FIRST – ADDS A STRING TO THE FRONT OF THE LIST");
            System.out.println("10. ADD TO LAST – ADDS A STRING TO THE BACK OF THE LIST");
            System.out.println("11. INSERT – ADD A STRING AT A GIVEN LOCATION");
            System.out.println("12. SET X – CHANGES THE VALUE AT SPOT X TO THE VALUE ENTERED BY THE USER");
            System.out.println("13. IS EMPTY – TELL YOU IF THE LIST IS EMPTY OF NOT");
            System.out.println("14. CLEAR – EMPTIES THE LIST");
            System.out.println(" 0. EXIT – CLOSES THE PROGRAM");

            System.out.println("ENTER YOUR CHOICE: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println("SIZE: " + list.size());
                case 2 -> System.out.println("PRINT: " + list);
                case 3 -> System.out.println("PRINT FIRST: " + list.getFirst());
                case 4 -> System.out.println("PRINT LAST: " + list.getLast());
                case 5 -> System.out.println("GET LOCATION: " + list.get(scanner.nextInt()));
                case 6 -> System.out.println("REMOVE FIRST: " + list.removeFirst());
                case 7 -> System.out.println("REMOVE LAST: " + list.removeLast());
                case 8 -> System.out.println("REMOVE X: " + list.remove(scanner.nextInt()));
                case 9 -> {
                    System.out.println("Please enter a string to add to the list: ");
                    list.addFirst(scanner.next());
                }
                case 10 -> {
                    System.out.println("Please enter a string to add to the list: ");
                    list.addLast(scanner.next());
                }
                case 11 -> {
                    System.out.println("Please enter a string to insert into the list: ");
                    String str = scanner.nextLine();
                    System.out.println("Please enter a location to insert the string: ");
                    list.add(scanner.nextInt(), str);
                }
                case 12 -> {
                    System.out.println("Please enter in a location to change the value: ");
                    int loc = scanner.nextInt();
                    System.out.println("Please enter in a new value: ");
                    list.set(loc, scanner.next());
                }
                case 13 -> System.out.println("IS EMPTY: " + list.isEmpty());
                case 14 -> {
                    list.clear();
                    System.out.println("List has been cleared");
                    System.out.println("New list: " + list);
                }
                default -> {
                    scanner.close();
                    return;
                }
            }
        }
    }
}
