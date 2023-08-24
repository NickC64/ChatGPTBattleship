package game;

/**
 * The status of a single grid square: It can either be empty, contain a part of a ship, contain a hit on a ship, or
 * a miss caused by a hit attempt on an empty gird square
 */
public enum GridSquareStatus {
    EMPTY, SHIP, HIT, MISS
}
