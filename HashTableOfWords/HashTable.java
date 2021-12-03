package HashTableOfWords;

import java.util.LinkedList;

public class HashTable<T> {
    private LinkedList<T>[] table;

    private int greatestNonEmpty = 0;

    public HashTable(int size) {
        table = new LinkedList[size];
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

        if (index > greatestNonEmpty) {
            greatestNonEmpty = index;
        }

        table[index].add(element);
    }

    public String toString() {
        String returnString = "HASHTABLE\n";

        for (int i = 0; i < table.length; i++) {
            if (i <= greatestNonEmpty) {
                returnString += "Bucket " + i + ": ";
                if (table[i] != null) {

                    // regex that removes all braces and commas of the tostring array
                    returnString += table[i].toString().replaceAll("\\[|\\]|,|\\s", " ");
                }
                returnString += "\n";
            }
        }

        return returnString;
    }
}