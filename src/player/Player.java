package player;
import cell.*;
import games.*;
import ui.*;

public abstract class Player {
    private String name;
    private String representation;

    public Player(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    public abstract int[] makeMove(Cell[][] grid);

    public Player() {

    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}

