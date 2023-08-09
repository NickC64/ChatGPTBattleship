interface BattleshipView {

    void flushView();
    void printBoard(GridStatus[][] board);
    void printAttemptsBoard(GridStatus[][] board);
    void showWinMessage(String playerName);
    void showTurnMessage(String playerName);
    void showAlreadyGuessedMessage(String playerName);
    void showHitMessage(String playerName);
    void showMissMessage(String playerName);
    int getCoordinateInput(String coordinateType);
    void showInvalidCoordinatesMessage();
}