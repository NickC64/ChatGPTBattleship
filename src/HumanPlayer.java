
class HumanPlayer implements Player {
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

    public void playTurn(GridStatus[][] opponentBoard, GridStatus[][] playerBoard) {
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

            // Assume BattleshipModel methods like receivePlayerGuess are available
            if (model.checkIfAlreadyAttempted(row, col, opponentBoard)) {
                view.showAlreadyGuessedMessage(name);
                continue;
            }
            if (model.checkIfHit(row, col, opponentBoard)){
                view.showHitMessage(name);
            } else{
                view.showMissMessage(name);
            }
            model.attemptHit(row, col, opponentBoard);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;

        }
    }

    private boolean isValidCoordinates(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
}
