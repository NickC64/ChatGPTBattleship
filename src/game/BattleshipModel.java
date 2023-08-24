package game;

import UI.BattleshipView;
import players.Player;


/**
 * Contains all the state variables necessary to represent the status of the game;
 */
public class BattleshipModel {
    private GridSquareStatus[][] player1Board;
    private GridSquareStatus[][] player2Board;
    private ShipPlacementStrategy player1PlacementStrategy;
    private ShipPlacementStrategy player2PlacementStrategy;

    public BattleshipModel() {
        player1Board = new GridSquareStatus[10][10];
        player2Board = new GridSquareStatus[10][10];
        initializeBoard(player1Board);
        initializeBoard(player2Board);
    }

    public GridSquareStatus[][] getPlayer1Board() {
        return player1Board;
    }

    public GridSquareStatus[][] getPlayer2Board() {
        return player2Board;
    }
    private void initializeBoard(GridSquareStatus[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = GridSquareStatus.EMPTY;
            }
        }
    }


    public boolean checkIfHit(int row, int col, GridSquareStatus[][] opponentBoard) {
        GridSquareStatus status = opponentBoard[row][col];
        return status == GridSquareStatus.SHIP;
    }

    public boolean checkIfAlreadyAttempted(int row, int col, GridSquareStatus[][] opponentBoard) {
        GridSquareStatus status = opponentBoard[row][col];
        return status == GridSquareStatus.HIT || status == GridSquareStatus.MISS;
    }

    public void attemptHit(int row, int col, GridSquareStatus[][] opponentBoard) {
        if (opponentBoard[row][col] == GridSquareStatus.SHIP) {
            opponentBoard[row][col] = GridSquareStatus.HIT;
        } else {
            opponentBoard[row][col] = GridSquareStatus.MISS;
        }

    }

    public boolean allShipsSunk(GridSquareStatus[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == GridSquareStatus.SHIP) {
                    return false;
                }
            }
        }
        return true;
    }
}
