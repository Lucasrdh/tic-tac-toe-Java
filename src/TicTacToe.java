import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TicTacToe extends Cell implements InteractionUtilisateur {
    private static final int size = 3;
    private Cell[][] grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private Menu menu = new Menu();


    public TicTacToe(Menu menu) {
        this.menu = menu;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
        whoPlay();
    }

    private void whoPlay() {
        menu.selectGameMode();
        String gameRule = getInput();
        switch (gameRule) {
            case "1":
                player1 = new HumanPlayer("Player 1", "X");
                player2 = new HumanPlayer("Player 2", "0");
                break;
            case "2":
                player1 = new HumanPlayer("Player 1", "X");
                player2 = new ArtificialPlayer("Player 2", "0");
                break;
            case "3":
                player1 = new ArtificialPlayer("Player 1", "X");
                player2 = new ArtificialPlayer("Player 2", "0");
                break;
            default:
                menu.selectGameMode();
                whoPlay();
        }
        currentPlayer = player1;
    }

    public int[] moveIsCorrect(Player player) {
        boolean validMove = false;
        int[] coordonnees = null;
        while (!validMove) {
            coordonnees = player.makeMove(menu,grid);
            if (grid[coordonnees[0]][coordonnees[1]].isEmpty()) {
                validMove = true;

            } else {
                if (player instanceof ArtificialPlayer) {
                    coordonnees = player.makeMove(menu,grid);
                } else {
                    menu.caseOccupee();
                }
            }
        }
        return coordonnees;
    }


    public void setOwner(int row, int col, Player player) {
        grid[row][col].setRepresentation(player.getRepresentation());

    }


    private boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner() {
        for (int i = 0; i < size; i++) {
            if (grid[i][0].getRepresentation().equals(currentPlayer.getRepresentation()) &&
                    grid[i][1].getRepresentation().equals(currentPlayer.getRepresentation()) &&
                    grid[i][2].getRepresentation().equals(currentPlayer.getRepresentation())) {
                return true;
            }
        }
        for (int j = 0; j < size; j++) {
            if (grid[0][j].getRepresentation().equals(currentPlayer.getRepresentation())
                    && grid[1][j].getRepresentation().equals(currentPlayer.getRepresentation())
                    && grid[2][j].getRepresentation().equals(currentPlayer.getRepresentation())) {
                return true;
            }
        }
        if (grid[0][0].getRepresentation().equals(currentPlayer.getRepresentation())
                && grid[1][1].getRepresentation().equals(currentPlayer.getRepresentation())
                && grid[2][2].getRepresentation().equals(currentPlayer.getRepresentation())) {
            return true;
        }
        if (grid[0][2].getRepresentation().equals(currentPlayer.getRepresentation())
                && grid[1][1].getRepresentation().equals(currentPlayer.getRepresentation())
                && grid[2][2].getRepresentation().equals(currentPlayer.getRepresentation())) {
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getRepresentation());
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

    public void play() {
        boolean gameRunning = true;
        while (gameRunning) {
            display();
            int[] resultat = moveIsCorrect(currentPlayer);
            setOwner(resultat[0], resultat[1], currentPlayer);

            if (isWinner()) {
                display();
                menu.victoire();
                gameRunning = false;
            } else if (isDraw()) {
                display();
                menu.matchNul();
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}
