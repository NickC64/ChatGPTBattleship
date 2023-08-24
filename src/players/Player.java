package players;

import game.GridSquareStatus;

public interface Player {
    String getName();
    boolean playTurn(GridSquareStatus[][] opponentBoard, GridSquareStatus[][] playerBoard);
}
