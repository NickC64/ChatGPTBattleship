package players;

import UI.BattleshipView;
import game.BattleshipModel;
import game.GridSquareStatus;

/**
 * An interface based method of playing turns, designed for human players
 */
public class HumanPlayer implements Player {
    private String name;
    private BattleshipModel model;
    private BattleshipView view;

    public HumanPlayer(String name, BattleshipModel model, BattleshipView view) {
        this.name = name;
        this.model = model;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    /**
     * Guides the human player through the process of playing 1 turn
     * @param opponentBoard the board of the opponent
     * @param playerBoard the board of the player
     * @return whether a ship was hit during this turn
     */
    public boolean playTurn(GridSquareStatus[][] opponentBoard, GridSquareStatus[][] playerBoard) {
        view.flushView();
        view.showTurnMessage(name);

        view.printBoard(playerBoard);
        view.printAttemptsBoard(opponentBoard);


        while (true) {
            int row = view.getCoordinateInput("row");
            int col = view.getCoordinateInput("column");

            if (!isValidCoordinates(row, col)) {
                view.showInvalidCoordinatesMessage();
                continue;
            }

            // Assume game.BattleshipModel methods like receivePlayerGuess are available
            if (model.checkIfAlreadyAttempted(row, col, opponentBoard)) {
                view.showAlreadyGuessedMessage(name);
                continue;
            }
            boolean hit = false;
            if (model.checkIfHit(row, col, opponentBoard)){
                view.showHitMessage(name);
                hit = true;
            } else{
                view.showMissMessage(name);
            }
            model.attemptHit(row, col, opponentBoard);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return hit;
        }
    }

    private boolean isValidCoordinates(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
}
