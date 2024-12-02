package model.games;

import model.cell.Cell;
import model.cell.State;
import model.player.ArtificialPlayer;
import model.player.HumanPlayer;
import model.player.Player;
import view.GameDisplay;
import view.InteractionUtilisateur;
import view.Menu;

public abstract class Game implements InteractionUtilisateur {
    private int sizeRow;
    private int sizeCol;
    private Cell[][] grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameDisplay affichage;
    private Game currentGame;
    private int winCondition;

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public void setSizeRow(int sizeRow) {
        this.sizeRow = sizeRow;
    }

    public int getSizeRow() {
        return sizeRow;
    }

    public int getSizeCol() {
        return sizeCol;
    }

    public void setSizeCol(int sizeCol) {
        this.sizeCol = sizeCol;
    }

    public Game(GameDisplay affichage, int sizeRow, int sizeCol) {
        this.affichage = affichage;
        this.currentGame = this;
        grid = new Cell[sizeRow][sizeCol];
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                grid[i][j] = new Cell();
            }
        }
        whoPlay();
    }


    public int[] getGridSizeNeed() {
        return new int[]{sizeRow, sizeCol};
    }

    protected void setWinCondition(int winCondition) {
        this.winCondition = winCondition;
    }

    private void whoPlay() {
        Menu.SELECTGAMEMODE.display();
        String gameRule = getInput();
        switch (gameRule) {
            case "1":
                player1 = new HumanPlayer("Player 1", State.X);
                player2 = new HumanPlayer("Player 2", State.O);
                break;
            case "2":
                player1 = new HumanPlayer("Player 1", State.X);
                player2 = new ArtificialPlayer("Player 2", State.O);
                break;
            case "3":
                player1 = new ArtificialPlayer("Player 1", State.X);
                player2 = new ArtificialPlayer("Player 2", State.O);
                break;
            default:
                Menu.SELECTGAMEMODE.display();
                whoPlay();
        }
        currentPlayer = player1;
    }

    public int[] moveIsCorrect(Player player) {
        boolean validMove = false;
        int[] coordonnees = null;

        while (!validMove) {

            if (currentGame instanceof Puissance4) {
                coordonnees = player.makeMovep4(grid);
                validMove = true;
            } else {
                coordonnees = player.makeMove(grid);

                if (grid[coordonnees[0]][coordonnees[1]].getState() == State.EMPTY) {
                    validMove = true;
                } else {
                    if (player instanceof ArtificialPlayer) {
                        continue;
                    } else {
                        Menu.CASEOCCUPEE.display();
                    }
                }
            }
        }
        return coordonnees;
    }



    public void setOwner(int row, int col, Player player) {
        grid[row][col].setState(player.getState());

    }


    public boolean isDraw() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].getState() == State.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public boolean isWinner() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].getState() != State.EMPTY) {
                    if (rowOk(i, j) || colOk(i, j) || diag1Ok(i, j) || diag2Ok(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean rowOk(int row, int col) {
        State playerState = grid[row][col].getState();
        int count = 1;


        for (int k = 1; k < winCondition; k++) {
            if (isValidCell(row, col + k) && grid[row][col + k].getState() == playerState) {
                count++;
            } else {
                break;
            }
        }

        return count >= winCondition;
    }

    private boolean colOk(int raw, int col) {
        State playerState = grid[raw][col].getState();
        int count = 1;
        for (int k = 1; k < winCondition; k++) {
            if (isValidCell(raw + k, col) && grid[raw + k][col].getState() == playerState) {
                count++;
            } else {
                break;
            }
        }
        return count >= winCondition;
    }

    private boolean diag1Ok(int row, int col) {
        State playerState = grid[row][col].getState();
        int count = 1;

        // Compte uniquement vers le bas à droite
        for (int k = 1; k < winCondition; k++) {
            if (isValidCell(row + k, col + k) && grid[row + k][col + k].getState() == playerState) {
                count++;
            } else {
                break;
            }
        }

        return count >= winCondition;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private boolean diag2Ok(int row, int col) {
        State playerState = grid[row][col].getState();
        int count = 1;

        // Compte uniquement vers le bas à gauche
        for (int k = 1; k < winCondition; k++) {
            if (isValidCell(row + k, col - k) && grid[row + k][col - k].getState() == playerState) {
                count++;
            } else {
                break;
            }
        }

        return count >= winCondition;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}


