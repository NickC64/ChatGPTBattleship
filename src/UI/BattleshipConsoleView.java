package UI;

import game.GridSquareStatus;

import java.util.Scanner;


/**
 * A terminal based implementation of the UI
 */
public class BattleshipConsoleView implements BattleshipView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void flushView() {
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
        System.out.flush();
    }

    /**
     * Takes advantage of the monospaced text of the terminal to print a console version of the player's board
     * @param board the board to print
     */
    @Override
    public void printBoard(GridSquareStatus[][] board) {
        System.out.println("Your board");
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(getSymbol(board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Takes advantage of the monospaced text of the terminal to print a console version of the moves the player made
     * @param board the board to print
     */
    @Override
    public void printAttemptsBoard(GridSquareStatus[][] board) {
        System.out.println("Your attempts");
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(getSymbolAttempts(board[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getSymbol(GridSquareStatus status) {
        switch (status) {
            case EMPTY:
                return ".";
            case SHIP:
                return "S";
            case HIT:
                return "X";
            case MISS:
                return "O";
            default:
                return " ";
        }
    }

    private String getSymbolAttempts(GridSquareStatus status) {
        switch (status) {
            case EMPTY, SHIP:
                return ".";
            case HIT:
                return "X";
            case MISS:
                return "O";
            default:
                return " ";
        }
    }

    public void showWinMessage(String playerName) {
        System.out.println("Congratulations, " + playerName + "! You've won!");
    }
    public void showTurnMessage(String playerName) {
        System.out.println(playerName + "'s Turn!");
    }

    public void showAlreadyGuessedMessage(String playerName) {
        System.out.println(playerName + ", you've already guessed this position. Try again.");
    }

    public void showHitMessage(String playerName) {
        System.out.println(playerName + ", you hit a ship!");
    }

    public void showMissMessage(String playerName) {
        System.out.println(playerName + ", you missed!");
    }

    public int getCoordinateInput(String coordinateType) {
        while (true) {
            System.out.print("Enter " + coordinateType + " (0-9): ");
            int coordinate = scanner.nextInt();

            if (coordinate < 0 || coordinate > 9) {
                showInvalidCoordinatesMessage();
            } else {
                return coordinate;
            }
        }
    }

    public void showInvalidCoordinatesMessage() {
        System.out.println("Invalid input. Please enter valid coordinates.");
    }

}
