package HashTableOfWords;

import java.io.File;
import java.util.Scanner;

public class HashTableRunner {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(
                    new File("C:\\Users\\mchscs012\\Documents\\Java-Labs\\HashTableOfWords\\words.dat"));
            HashTable<Word> hashTable = new HashTable<>(sc.nextInt());

            while (sc.hasNextLine()) {
                hashTable.add(new Word(sc.nextLine()));
            }

            System.out.println(hashTable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Houston, we have a problem!");
        }
    }
}