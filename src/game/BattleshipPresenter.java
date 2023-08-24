package game;

import UI.BattleshipView;
import players.Player;

public class BattleshipPresenter {
    private BattleshipModel model;
    private BattleshipView view;

    public BattleshipPresenter(BattleshipModel model, BattleshipView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Dirty method to randomly place ships and start the game
     * @param player1 the first player
     * @param player2 the second player
     */

    public void startGame(Player player1, Player player2) {

        ShipPlacementStrategy placementStrategy = new RandomShipPlacementStrategy();
        placementStrategy.placeShips(model.getPlayer1Board());
        placementStrategy.placeShips(model.getPlayer2Board());

        playGame(player1, player2);
    }

    /**
     * Facilitates the turns of the game. If a player hits a ship, they are allowed to play again. If all of a player
     * are sunk, that player loses and the game ends.
     * @param player1 player1
     * @param player2 player2
     */
    private void playGame(Player player1, Player player2) {
        boolean gameEnded = false;
        while (!gameEnded) {
            for (Player player: new Player[] {player1, player2}) {
                boolean turnEnded = false;
                while (!turnEnded) {

                    boolean hit = player.playTurn(model.getPlayer2Board(), model.getPlayer1Board());
                    if (hit) {
                        if (model.allShipsSunk(model.getPlayer2Board())) {
                            view.showWinMessage(player1.getName());
                            gameEnded = true;
                            turnEnded = true;
                        }
                    } else{
                        turnEnded = true;
                    }

                }

            }
        }
    }

}