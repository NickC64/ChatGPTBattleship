interface Player {
    String getName();
    void playTurn(GridStatus[][] opponentBoard, GridStatus[][] playerBoard);
}
