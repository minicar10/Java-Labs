package ConnectFour;

public class ConnectFourGame {
    public static final int PLAYING = 0;
    public static final int RED_WINS = 1;
    public static final int BLACK_WINS = 2;
    public static final int DRAW = 3;
    public static final int RED = 4;
    public static final int BLACK = 5;
    public static final int EMPTY = 6;

    int[][] board;

    public ConnectFourGame() {
        board = new int[6][6];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public boolean dropPiece(int column, int player) {
        if (getLowestPieceRow(column) != -1) {
            board[getLowestPieceRow(column)][column] = player;
            return true;
        }
        return false;
    }

    private int checkHorizontalStatus() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c <= 3; c++) {
                if (board[r][c] == RED && board[r][c + 1] == RED && board[r][c + 2] == RED && board[r][c + 3] == RED)
                    return RED_WINS;
                else if (board[r][c] == BLACK && board[r][c + 1] == BLACK && board[r][c + 2] == BLACK
                        && board[r][c + 3] == BLACK)
                    return BLACK_WINS;
            }
        }
        return PLAYING;
    }

    private int checkVerticalStatus() {
        int redCount = 0;
        int blackCount = 0;
        for (int cols = 0; cols < board.length; cols++) {
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][cols] == RED) {
                    redCount++;
                    blackCount = 0;
                } else if (board[row][cols] == BLACK) {
                    blackCount++;
                    redCount = 0;
                } else {
                    redCount = 0;
                    blackCount = 0;
                }
            }
            if (redCount == 4) {
                return RED_WINS;
            }
            if (blackCount == 4) {
                return BLACK_WINS;
            }
            redCount = 0;
            blackCount = 0;
        }
        return PLAYING;
    }

    private int checkDiagonalStatus() {
        return PLAYING;
    }

    public int status() {
        boolean allFilled = true;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == EMPTY) {
                    allFilled = false;
                }
            }
        }

        if (allFilled && checkHorizontalStatus() == PLAYING && checkVerticalStatus() == PLAYING
                && checkDiagonalStatus() == PLAYING) {
            return DRAW;
        }

        if (checkHorizontalStatus() == RED_WINS) {
            return RED_WINS;
        } else if (checkHorizontalStatus() == BLACK_WINS) {
            return BLACK_WINS;
        }

        if (checkVerticalStatus() == RED_WINS) {
            return RED_WINS;
        } else if (checkVerticalStatus() == BLACK_WINS) {
            return BLACK_WINS;
        }

        if (checkDiagonalStatus() == RED_WINS) {
            return RED_WINS;
        } else if (checkDiagonalStatus() == BLACK_WINS) {
            return BLACK_WINS;
        }

        return PLAYING;
    }

    public int getSpot(int row, int col) {
        if (col < 0 || col > 5 || row < 0 || row > 5) {
            return -1;
        }

        return board[row][col];
    }

    public int getLowestPieceRow(int column) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] != BLACK && board[row][column] != RED) {
                return row;
            }
        }
        return -1;
    }

    public boolean columnFull(int column) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void draw() {
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int col = 0; col < board[row].length; col++) {
                String pieceName = "";

                switch (board[row][col]) {
                    case BLACK -> pieceName = "BLACK";
                    case RED -> pieceName = "RED  ";
                    case EMPTY -> pieceName = "EMPTY";
                }

                System.out.print(pieceName);
                if (col < board[row].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
    }
}
