package HashTableOfWords;

import java.util.LinkedList;

public class HashTable<T> {
    private LinkedList<T>[] table;

    public HashTable() {
        table = new LinkedList[10];
    }

    public void add(T element) {
        int index = element.hashCode();
        LinkedList<T> val;

        try {
            val = table[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }

        if (val == null) {
            table[index] = new LinkedList<>();
        }

        table[index].add(element);
    }

    public String toString() {
        String returnString = "";

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                returnString += "Bucket " + i + ": " + table[i] + "\n";
            }
        }

        return returnString;
    }
}