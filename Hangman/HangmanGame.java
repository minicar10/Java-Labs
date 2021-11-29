package Hangman;

import java.util.*;

public class HangmanGame {
    public static final int MAX_GUESSES = 6;
    private int wrongGuess;
    private final List<String> sentences;
    private String sentence;
    private ArrayList<Character> vowels;
    private ArrayList<Character> consonants;

    public HangmanGame() {
        sentences = Arrays.asList("Peace begins with a smile.", "Don’t count the days, make the days count.",
                "I failed my way to success.", "You miss one hundred percent of the shots you don’t take.",
                "Be where you are; otherwise, you will miss your life.",
                "Only a mediocre person is always at his best.", "How are you doing on this sunshine day?",
                "Happy go lucky this brilliant moment.", "We are all winners if we apply ourselves.",
                "Believers in the good for all, only way to be.");
        vowels = new ArrayList<>();
        consonants = new ArrayList<>();
        sentence = sentences.get((int) (Math.random() * sentences.size()));
    }

    public boolean won() {
        for (int i = 0; i < sentence.length(); i++) {
            if (!vowels.contains(sentence.charAt(i)) || !consonants.contains(sentence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void printSentence() {
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (vowels.contains(currentChar) && consonants.contains(currentChar)) {
                System.out.print(currentChar);
            } else {
                System.out.print("-");
            }
        }
    }

    public int guessesLeft() {
        return wrongGuess - MAX_GUESSES;
    }

    public boolean addGuessedLetter(char c) {
        if (sentence.toLowerCase().contains(Character.toString(c)) && !vowels.contains(c) && !consonants.contains(c)) {
            if (isVowel(c)) {
                vowels.add(c);
            } else {
                consonants.add(c);
            }
            return true;
        }
        wrongGuess--;
        return false;
    }

    public void printGuessed() {
        System.out.println("\n");
        System.out.println("Guessed Vowels: " + vowels);
        System.out.println("Guessed Consonants: " + consonants);
        System.out.println("You have " + guessesLeft() + " guesses left.");
    }

    public boolean isPunctuation(char c) {
        char x = Character.toLowerCase(c);
        return x == ',' || x == '.' || x == '!' || x == '?' || x == ':' || x == ';' || x == '\'';
    }

    public boolean isInSentence(char c) {
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.toString(sentence.charAt(i)).equalsIgnoreCase(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

    public Boolean isVowel(char c) {
        return Character.toLowerCase(c) == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
