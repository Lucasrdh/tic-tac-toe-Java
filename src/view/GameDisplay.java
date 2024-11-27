package view;

import model.cell.Cell;

public class GameDisplay {
    public void renduGrid(Cell[][] grid) {
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getRep());
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.print("------");
                System.out.println();
            }
        }
    }
}
