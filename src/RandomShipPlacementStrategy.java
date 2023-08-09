import java.util.Random;

class RandomShipPlacementStrategy implements ShipPlacementStrategy {
    private static final int BOARD_SIZE = 10;
    private static final int NUM_SHIPS = 5;
    private static final int SHIP_LENGTHS[] = { 5, 4, 3, 3, 2 };

    private Random random = new Random();

    @Override
    public void placeShips(GridStatus[][] playerBoard) {

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

    private boolean isValidPlacement(GridStatus[][] playerBoard, int row, int col, int shipLength, boolean isHorizontal) {
        if (isHorizontal) {
            if (col + shipLength > BOARD_SIZE) {
                return false; // Ship would be out of bounds
            }
            for (int c = col; c < col + shipLength; c++) {
                if (playerBoard[row][c] == GridStatus.SHIP) {
                    return false; // Ship overlaps with another ship
                }
            }
        } else {
            if (row + shipLength > BOARD_SIZE) {
                return false; // Ship would be out of bounds
            }
            for (int r = row; r < row + shipLength; r++) {
                if (playerBoard[r][col] == GridStatus.SHIP) {
                    return false; // Ship overlaps with another ship
                }
            }
        }
        return true;
    }

    private void placeShip(GridStatus[][] playerBoard, int row, int col, int shipLength, boolean isHorizontal) {
        if (isHorizontal) {
            for (int c = col; c < col + shipLength; c++) {
                playerBoard[row][c] = GridStatus.SHIP;
            }
        } else {
            for (int r = row; r < row + shipLength; r++) {
                playerBoard[r][col] = GridStatus.SHIP;
            }
        }
    }
}
