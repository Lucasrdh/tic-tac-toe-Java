package player;
import cell.*;
import games.*;
import ui.*;


public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String name, String representation) {
        super(name, representation);
    }

    @Override
    public int[] makeMove(Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validMove = false;

        while (!validMove) {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);

            if (grid[row][col].isEmpty()) {
                coordonnees[0] = row;
                coordonnees[1] = col;
                validMove = true;
            }
        }

        return coordonnees;
    }

}
