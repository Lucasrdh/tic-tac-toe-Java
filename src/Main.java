import model.games.TicTacToe;
import view.GameDisplay;

public class Main {
    public static void main(String[] args) {
        GameDisplay affichage = new GameDisplay();
TicTacToe ticTacToe = new TicTacToe(affichage);
ticTacToe.play();
    }
}