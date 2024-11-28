package model.player;
import controller.GameController;
import model.cell.Cell;
import model.cell.State;
import model.games.GridNeed;
import view.InteractionUtilisateur;
import view.Menu;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HumanPlayer extends Player implements InteractionUtilisateur {

    public HumanPlayer(String name, State state) {
        super(name, state);
    }

    @Override
    public int[] makeMove(Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validInput = false;

        // Récupérer les dimensions de la grille via GridNeed
        int[] gridSize = GridNeed.getGridSize(GameController.getCurrentGame());
        int sizeRow = gridSize[0];
        int sizeCol = gridSize[1];

        // Construire dynamiquement le regex pour valider l'entrée utilisateur
        String regex = String.format("[1-%d] [1-%d]", sizeRow, sizeCol);

        while (!validInput) {
            // Afficher le menu d'instructions
            Menu.HOWTOPLAY.display();

            // Lire l'entrée utilisateur
            String input = getInput().trim();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                // Extraire les coordonnées si l'entrée correspond au regex
                String[] parts = input.split(" ");
                coordonnees[0] = Integer.parseInt(parts[0]) - 1; // Index ligne (0-based)
                coordonnees[1] = Integer.parseInt(parts[1]) - 1; // Index colonne (0-based)

                // Vérifier que la case est vide
                if (grid[coordonnees[0]][coordonnees[1]].getState() == State.EMPTY) {
                    validInput = true;
                } else {
                    System.out.println("Cette case est déjà occupée. Veuillez en choisir une autre.");
                }
            } else {
                // Message d'erreur en cas d'entrée invalide
                System.out.printf("Entrée invalide. Entrez des coordonnées entre 1 et %d pour la ligne, et entre 1 et %d pour la colonne.\n", sizeRow, sizeCol);
            }
        }
        return coordonnees;
    }

}
