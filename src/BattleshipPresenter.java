

class BattleshipPresenter {
    private BattleshipModel model;
    private BattleshipView view;

    public BattleshipPresenter(BattleshipModel model, BattleshipView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Player player1 = new HumanPlayer("Player 1", model, view);
        Player player2 = new HumanPlayer("Player 2", model, view);

        // Assuming these methods are available and handle player ship placements
        model.placePlayerShips(player1, view);
        model.placePlayerShips(player2, view);

        playGame(player1, player2);
    }

    private void playGame(Player player1, Player player2) {
        while (true) {
            player1.playTurn(model.getPlayer2Board(), model.getPlayer1Board());
            if (model.allShipsSunk(model.getPlayer2Board())) {
                view.showWinMessage(player1.getName());
                break;
            }

            player2.playTurn(model.getPlayer1Board(), model.getPlayer2Board());
            if (model.allShipsSunk(model.getPlayer1Board())) {
                view.showWinMessage(player2.getName());
                break;
            }
        }
    }

}