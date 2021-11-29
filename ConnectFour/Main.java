package ConnectFour;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConnectFourGame connectFourGame = new ConnectFourGame();
        Scanner keyboardInput = new Scanner(System.in);
        int currentPlayer = (int) (Math.round(Math.random()));
        boolean inhibitChange = false;

        for (;;) {
            System.out.println(currentPlayer == 0 ? "RED'S TURN" : "BLACK'S TURN");
            connectFourGame.draw();

            System.out.println("Place a piece at a destination");
            int column = keyboardInput.nextInt();

            if (currentPlayer == 0) {
                if (connectFourGame.dropPiece(column, ConnectFourGame.RED)) {
                    inhibitChange = false;
                } else {
                    inhibitChange = true;
                }
            } else {
                if (connectFourGame.dropPiece(column, ConnectFourGame.BLACK)) {
                    inhibitChange = false;
                } else {
                    inhibitChange = true;
                }
            }

            if (inhibitChange) {
                System.out.println("Piece could not be placed, please try again.");
            }

            if (!inhibitChange) {
                currentPlayer = currentPlayer == 0 ? 1 : 0;
            }

            if (connectFourGame.status() == ConnectFourGame.BLACK_WINS
                    || connectFourGame.status() == ConnectFourGame.RED_WINS) {
                if (connectFourGame.status() == ConnectFourGame.BLACK_WINS) {
                    System.out.println("Black Wins!");
                    System.out.println("Red Loses!");
                }
                if (connectFourGame.status() == ConnectFourGame.RED_WINS) {
                    System.out.println("Red Wins!");
                    System.out.println("Black Loses!");
                }
                return;
            }
        }
    }
}
