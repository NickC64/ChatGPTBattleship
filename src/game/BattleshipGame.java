package game;

import UI.BattleshipConsoleView;
import UI.BattleshipView;
import players.HumanPlayer;

/**
 * Ties the MVC model together and starts the game with two human players
 */
public class BattleshipGame {

    public static void main(String[] args) {
        BattleshipModel model = new BattleshipModel();
        BattleshipView view = new BattleshipConsoleView();
        BattleshipPresenter presenter = new BattleshipPresenter(model, view);

        presenter.startGame(new HumanPlayer("Player 1", model, view), new HumanPlayer("Player 2", model, view));
    }
}

