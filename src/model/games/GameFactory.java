package controller;

import model.games.Game;
import model.games.TicTacToe;
import model.games.Puissance4;
import model.games.Gomoku;
import view.GameDisplay;
import view.Menu;

import java.util.Scanner;

public class GameFactory {
    public static Game createGame(GameDisplay affichage) {
        Scanner scanner = new Scanner(System.in);
        Menu.SELECTGAME.display(); // Affiche le menu
        int choix = getValidChoice(scanner);

        return switch (choix) {
            case 1 -> new TicTacToe(affichage);
            case 2 -> new Puissance4(affichage);
            case 3 -> new Gomoku(affichage);
            default -> throw new IllegalStateException("Choix non valide : " + choix);
        };
    }

    private static int getValidChoice(Scanner scanner) {
        int choix = -1;
        while (choix < 1 || choix > 3) {
            try {
                System.out.print("Entrez votre choix (1, 2 ou 3) : ");
                choix = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Nettoie l'entrée
            }
        }
        return choix;
    }
}
