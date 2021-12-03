package HashTableOfWords;

public class Word {
    private String value;

    private static final String vowels = "aeiou";
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";

    public Word(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Word other) {
        return this.value.equals(other.value);
    }

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value == "BOOT" ? (2 * 4) % 10 : (getNumberOfVowels() * value.length()) % 10;
    }

    private int getNumberOfVowels() {
        int count = 0;
        for (char c : value.toLowerCase().toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }
}
