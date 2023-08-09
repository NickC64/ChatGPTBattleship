

public class BattleshipGame {

    public static void main(String[] args) {
        BattleshipPresenter presenter = new BattleshipPresenter(new BattleshipModel(), new BattleshipConsoleView());

        presenter.startGame();
    }
}

