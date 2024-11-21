package games;

import cell.*;
import player.ArtificialPlayer;
import player.HumanPlayer;
import player.Player;
import ui.GameDisplay;
import ui.InteractionUtilisateur;
import ui.Menu;

public abstract class Game implements InteractionUtilisateur {
    private int size = 3;
    private Cell[][] grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameDisplay affichage;

    public Game(GameDisplay affichage) {
        this.affichage = affichage;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
        whoPlay();
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
            coordonnees = player.makeMove(grid);
            if (grid[coordonnees[0]][coordonnees[1]].getState() == State.EMPTY) {
                validMove = true;

            } else {
                if (player instanceof ArtificialPlayer) {
                    coordonnees = player.makeMove(grid);
                } else {
                    Menu.CASEOCCUPEE.display();
                }
            }
        }
        return coordonnees;
    }


    public void setOwner(int row, int col, Player player) {
        grid[row][col].setState(player.getState());

    }


    private boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].getState() == State.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner() {
        for (int i = 0; i < size; i++) {
            if (grid[i][0].getState().equals(currentPlayer.getState()) &&
                    grid[i][1].getState().equals(currentPlayer.getState()) &&
                    grid[i][2].getState().equals(currentPlayer.getState())) {
                return true;
            }
        }
        for (int j = 0; j < size; j++) {
            if (grid[0][j].getState().equals(currentPlayer.getState())
                    && grid[1][j].getState().equals(currentPlayer.getState())
                    && grid[2][j].getState().equals(currentPlayer.getState())) {
                return true;
            }
        }
        if (grid[0][0].getState().equals(currentPlayer.getState())
                && grid[1][1].getState().equals(currentPlayer.getState())
                && grid[2][2].getState().equals(currentPlayer.getState())) {
            return true;
        }
        if (grid[0][2].getState().equals(currentPlayer.getState())
                && grid[1][1].getState().equals(currentPlayer.getState())
                && grid[2][2].getState().equals(currentPlayer.getState())) {
            return true;
        }
        return false;
    }


    public void play() {
        boolean gameRunning = true;
        while (gameRunning) {
            affichage.renduGrid(grid);
            int[] resultat = moveIsCorrect(currentPlayer);
            setOwner(resultat[0], resultat[1], currentPlayer);

            if (isWinner()) {
                affichage.renduGrid(grid);
                Menu.VICTOIRE.display();
                gameRunning = false;
            } else if (isDraw()) {
                affichage.renduGrid(grid);
                Menu.MATCHNUL.display();
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }
}
