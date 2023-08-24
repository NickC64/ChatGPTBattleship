package UI;

import game.GridSquareStatus;

/**
 * UI methods for the operation of the game and to facilitate human moves
 */
public interface BattleshipView {

    void flushView();
    void printBoard(GridSquareStatus[][] board);
    void printAttemptsBoard(GridSquareStatus[][] board);
    void showWinMessage(String playerName);
    void showTurnMessage(String playerName);
    void showAlreadyGuessedMessage(String playerName);
    void showHitMessage(String playerName);
    void showMissMessage(String playerName);
    int getCoordinateInput(String coordinateType);
    void showInvalidCoordinatesMessage();
}