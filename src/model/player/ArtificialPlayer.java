package model.player;
import controller.GameController;
import model.cell.Cell;
import model.cell.State;
import model.games.*;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String name, State state) {
        super(name,state);
    }

    @Override
    public int[] makeMove(Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validMove = false;

        // Utilisation de GridNeed pour récupérer la taille de la grille.
        int[] gridSize = GridNeed.getGridSize(GameController.getCurrentGame());
        int sizeRow = gridSize[0];
        int sizeCol = gridSize[1];

        while (!validMove) {
            // Génère des coordonnées aléatoires dans les limites de la grille.
            int row = (int) (Math.random() * sizeRow);
            int col = (int) (Math.random() * sizeCol);

            // Vérifie si la case est vide.
            if (grid[row][col].getState() == State.EMPTY) {
                coordonnees[0] = row;
                coordonnees[1] = col;
                validMove = true;
            }
        }

        return coordonnees;
    }


}
