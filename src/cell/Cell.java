package cell;

public class Cell {
    private String representation;

    public Cell() {
        enum Celltype{
            EMPTY,
            X,
            O;
            private final String representation;
        }
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
