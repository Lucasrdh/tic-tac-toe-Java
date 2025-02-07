package controller;

import model.games.Game;
import model.player.Player;
import view.GameDisplay;
import view.Menu;

public class GameController {
    private Game game;
    private GameDisplay affichage;

    public GameController(Game game, GameDisplay affichage) {
        this.game = game;
        this.affichage = affichage;
    }
    public void play() {
        boolean gameRunning = true;
        while (gameRunning) {
            affichage.renduGrid(game.getGrid());
            Player currentPlayer = game.getCurrentPlayer();

            int[] resultat = game.moveIsCorrect(currentPlayer);
            game.setOwner(resultat[0], resultat[1], currentPlayer);

            if (game.isWinner()) {
                affichage.renduGrid(game.getGrid());
                Menu.VICTOIRE.display();
                gameRunning = false;
            } else if (game.isDraw()) {
                affichage.renduGrid(game.getGrid());
                Menu.MATCHNUL.display();
                gameRunning = false;
            } else {
                game.switchPlayer();
            }
        }

    }

    public void setGame(Game game) {
        this.game = game;
    }
    public Game getCurrentGame() {
        return game;
    }
}
