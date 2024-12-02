package model.player;

import model.cell.Cell;
import model.cell.State;
import model.games.Game;
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

        int sizeRow = grid.length;
        int sizeCol = grid[0].length;

        String regex = String.format("[1-%d] [1-%d]", sizeRow, sizeCol);

        while (!validInput) {
            Menu.BONNEENTREE.display(sizeRow, sizeCol);

            String input = getInput().trim();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String[] parts = input.split(" ");
                coordonnees[0] = Integer.parseInt(parts[0]) - 1;
                coordonnees[1] = Integer.parseInt(parts[1]) - 1;

                if (grid[coordonnees[0]][coordonnees[1]].getState() == State.EMPTY) {
                    validInput = true;
                } else {
                    Menu.CASEOCCUPEE.display();
                }
            } else {
                Menu.BONNEENTREE.display(sizeRow, sizeCol);
            }
        }
        return coordonnees;
    }

    public int[] makeMovep4(Cell[][] grid) {
        int[] coordonnees = new int[2];
        boolean validInput = false;
        int sizeRow = grid.length;
        int sizeCol = grid[0].length;
        String regex = String.format("[1-%d]", sizeCol);
        while (!validInput) {
            Menu.BONNEENTREEP4.display(sizeCol);
            String input = getInput().trim();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                int col = Integer.parseInt(input) - 1;
                coordonnees[1] = col;
                for (int row = sizeRow - 1; row >= 0; row--) {
                    if (grid[row][col].getState() == State.EMPTY) {
                        validInput = true;
                        break;
                    }
                }
                if (!validInput) {
                    Menu.COLONNEPLEINE.display();
                }
            } else {
                Menu.BONNEENTREE.display(sizeCol);
            }
        }
        return coordonnees;
    }


}
