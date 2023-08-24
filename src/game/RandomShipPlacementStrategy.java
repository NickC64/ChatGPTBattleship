package game;

import java.util.Random;


/**
 * A naive implementation of random ship placement
 */
public class RandomShipPlacementStrategy implements ShipPlacementStrategy {
    private static final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 5;
    private static final int SHIP_LENGTHS[] = { 5, 4, 3, 3, 2 };

    private Random random = new Random();

    /**
     * Randomly generates ship placements
     * @param playerBoard the board to place ships on
     */
    @Override
    public void placeShips(GridSquareStatus[][] playerBoard) {

        for (int shipLength : SHIP_LENGTHS) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(BOARD_SIZE);
                int col = random.nextInt(BOARD_SIZE);
                boolean isHorizontal = random.nextBoolean();

                if (isValidPlacement(playerBoard, row, col, shipLength, isHorizontal)) {
                    placeShip(playerBoard, row, col, shipLength, isHorizontal);
                    placed = true;
                }
            }
        }
    }

    /**
     * Checks if a particular ship placement choice is within bounds or overlaps with another ship.
     * This method is needed because our ship placement generation strategy is naive
     * @param playerBoard
     * @param row the row of the first ship square
     * @param col the column of the first ship square
     * @param shipLength the length of the ship
     * @param isHorizontal whether the ship is aligned horizontally (it is otherwise vertical
     * @return true if the ship placement is valid.
     */
    private boolean isValidPlacement(GridSquareStatus[][] playerBoard, int row, int col, int shipLength, boolean isHorizontal) {
        if (isHorizontal) {
            if (col + shipLength > BOARD_SIZE) {
                return false; // Ship would be out of bounds
            }
            for (int c = col; c < col + shipLength; c++) {
                if (playerBoard[row][c] == GridSquareStatus.SHIP) {
                    return false; // Ship overlaps with another ship
                }
            }
        } else {
            if (row + shipLength > BOARD_SIZE) {
                return false; // Ship would be out of bounds
            }
            for (int r = row; r < row + shipLength; r++) {
                if (playerBoard[r][col] == GridSquareStatus.SHIP) {
                    return false; // Ship overlaps with another ship
                }
            }
        }
        return true;
    }

    private void placeShip(GridSquareStatus[][] playerBoard, int row, int col, int shipLength, boolean isHorizontal) {
        if (isHorizontal) {
            for (int c = col; c < col + shipLength; c++) {
                playerBoard[row][c] = GridSquareStatus.SHIP;
            }
        } else {
            for (int r = row; r < row + shipLength; r++) {
                playerBoard[r][col] = GridSquareStatus.SHIP;
            }
        }
    }
}
