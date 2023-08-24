package game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ShipPlacementStrategyTest {

    GridSquareStatus[][] getTestBoard() {
        ShipPlacementStrategy placementStrategy = new RandomShipPlacementStrategy();
        GridSquareStatus[][] board = new GridSquareStatus[10][10];
        placementStrategy.placeShips(board);
        board[0][0] = GridSquareStatus.HIT;
        board[0][1] = GridSquareStatus.EMPTY;
        board[0][2] = GridSquareStatus.SHIP;
        return board;
    }

    /**
     * Tests that every ship was placed without overlaps and the board only has ships or empty squares
     */
    @Test
    void testRandomBoardPlacement() {

        GridSquareStatus[][] board = getTestBoard();
        int shipSquareCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                assertNotEquals(board[i][j], GridSquareStatus.HIT);
                assertNotEquals(board[i][j], GridSquareStatus.MISS);
                if (board[i][j].equals(GridSquareStatus.SHIP)) {
                    shipSquareCount ++;
                }
            }
        }
        assertEquals(17, shipSquareCount);


    }
}