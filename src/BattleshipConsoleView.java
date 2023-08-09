import java.util.Scanner;

class BattleshipConsoleView implements BattleshipView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void flushView() {
        for (int i = 0; i < 200; i++) {
            System.out.println();
        }
        System.out.flush();
    }

    @Override
    public void printBoard(GridStatus[][] board) {
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

    @Override
    public void printAttemptsBoard(GridStatus[][] board) {
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

    private String getSymbol(GridStatus status) {
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

    private String getSymbolAttempts(GridStatus status) {
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

    public void showPlayerTypeMenu() {
        System.out.println("Select player type:");
        System.out.println("1. Human Player");
        System.out.println("2. Computer Player");
    }

    public void showInvalidPlayerTypeMessage() {
        System.out.println("Invalid selection. Please choose 1 for Human Player or 2 for Computer Player.");
    }
}
