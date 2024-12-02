package model.player;

import model.cell.Cell;
import model.cell.State;
import model.games.Game;

public abstract class Player {
    private String name;
    State state;

    public Player(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public abstract int[] makeMove(Cell[][] grid);
    public abstract int[] makeMovep4(Cell[][] grid);

    public String getName() {
        return name;
    }
    public State getState() {
        return state;
    }
    public String getRep(){
        return state.getValue();
    }
    @Override
    public String toString() {
        return getRep();
    }
}

