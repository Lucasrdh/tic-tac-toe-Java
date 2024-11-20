package cell;

public class Cell {
    private String representation;

    public Cell() {
        this.representation = " ";
    }
    public boolean isEmpty() {
        return this.representation.equals(" ");
    }

    public String getRepresentation() {

        return representation;
    }
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
