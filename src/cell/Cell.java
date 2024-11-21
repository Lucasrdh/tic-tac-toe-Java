package cell;

public class Cell {
    private State state;

    // Constructeur par défaut, initialise l'état de la cellule à EMPTY
    public Cell() {
        this.state = State.EMPTY;
    }

    // Méthode pour définir l'état de la cellule
    public void setState(State state) {
        this.state = state;
    }

    // Méthode pour obtenir la représentation textuelle de l'état de la cellule
    public String getRep() {
        return this.state.getValue();
    }

    // Retourne l'état actuel de la cellule
    public State getState() {
        return this.state;
    }

    // Redéfinition de la méthode toString() pour une représentation textuelle plus intuitive
    @Override
    public String toString() {
        return getRep();
    }
}
