class BattleshipModel {
    private GridStatus[][] player1Board;
    private GridStatus[][] player2Board;
    private ShipPlacementStrategy player1PlacementStrategy;
    private ShipPlacementStrategy player2PlacementStrategy;

    public BattleshipModel() {
        player1Board = new GridStatus[10][10];
        player2Board = new GridStatus[10][10];
        initializeBoard(player1Board);
        initializeBoard(player2Board);
    }

    public GridStatus[][] getPlayer1Board() {
        return player1Board;
    }

    public GridStatus[][] getPlayer2Board() {
        return player2Board;
    }
    private void initializeBoard(GridStatus[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = GridStatus.EMPTY;
            }
        }
    }

    public void placePlayerShips(Player player, BattleshipView view) {
        player1PlacementStrategy = new RandomShipPlacementStrategy();
        player2PlacementStrategy = new RandomShipPlacementStrategy();

        if (player.getName().equals("Player 1")) {
            player1PlacementStrategy.placeShips(player1Board);
        } else {
            player2PlacementStrategy.placeShips(player2Board);
        }
    }

    public boolean checkIfHit(int row, int col, GridStatus[][] opponentBoard) {
        GridStatus status = opponentBoard[row][col];
        return status == GridStatus.SHIP;
    }

    public boolean checkIfAlreadyAttempted(int row, int col, GridStatus[][] opponentBoard) {
        GridStatus status = opponentBoard[row][col];
        return status == GridStatus.HIT || status == GridStatus.MISS;
    }

    public void attemptHit(int row, int col, GridStatus[][] opponentBoard) {
        if (opponentBoard[row][col] == GridStatus.SHIP) {
            opponentBoard[row][col] = GridStatus.HIT;
        } else {
            opponentBoard[row][col] = GridStatus.MISS;
        }

    }

    public boolean allShipsSunk(GridStatus[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == GridStatus.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }
}
