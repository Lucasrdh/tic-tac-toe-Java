package view;

import model.cell.Cell;

public class GameDisplay {
    public void renduGrid(Cell[][] grid) {
        int sizeRow = grid.length;
        int sizeCol = grid[0].length;
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                System.out.print(grid[i][j].getRep());
                if (j < sizeCol - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < sizeRow - 1) {
                for (int k = 0; k < sizeCol; k++) {
                    System.out.print("---");
                    if (k < sizeCol - 1) {
                        System.out.print("+");
                    }
                }

                System.out.println();
            }
        }
    }
}
