package model.player;
import model.cell.Cell;
import model.cell.State;


public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String name, State state) {
        super(name,state);
    }

    @Override
    public int[] makeMove(Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validMove = false;

        int sizeRow = grid.length;
        int sizeCol = grid[0].length;

        while (!validMove) {
            int row = (int) (Math.random() * sizeRow);
            int col = (int) (Math.random() * sizeCol);

            if (grid[row][col].getState() == State.EMPTY) {
                coordonnees[0] = row;
                coordonnees[1] = col;
                validMove = true;
            }
        }

        return coordonnees;
    }


}
