package Hangman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        Scanner keyboardInput = new Scanner(System.in);

        do {
            System.out.println("Please create an input.");
            hangmanGame.addGuessedLetter(keyboardInput.nextLine().charAt(0));
            hangmanGame.printSentence();
            hangmanGame.printGuessed();
        } while (hangmanGame.guessesLeft() > 0 && !hangmanGame.won());
    }
}
