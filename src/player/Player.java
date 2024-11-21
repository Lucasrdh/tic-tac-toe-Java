package player;

import cell.*;
import games.*;
import ui.*;

public abstract class Player {
    private String name;
    State state;

    public Player(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public abstract int[] makeMove(Cell[][] grid);

    public Player() {

    }

    public String getName() {
        return name;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public String getRep(){
        return state.getValue();
    }
    @Override
    public String toString() {
        return getRep();
    }
}

