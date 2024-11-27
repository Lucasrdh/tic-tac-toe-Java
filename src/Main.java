import controller.GameController;
import model.games.Game;
import model.games.TicTacToe;
import view.GameDisplay;

public class Main {
    public static void main(String[] args) {
        GameDisplay affichage = new GameDisplay();
TicTacToe game = new TicTacToe(affichage);
        GameController controller = new GameController(game, affichage);
        controller.play();
    }
}