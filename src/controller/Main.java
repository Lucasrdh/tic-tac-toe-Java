package controller;

import model.games.Game;
import view.GameDisplay;

public class Main {
    public static void main(String[] args) {
        GameDisplay affichage = new GameDisplay();
        Game game = controller.GameFactory.createGame(affichage); // Crée le jeu via la GameFactory
        GameController controller = new GameController(game, affichage);
        controller.setGame(game);
        controller.play();
    }
}
