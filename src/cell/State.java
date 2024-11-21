package cell;

public enum State {
    EMPTY(". ."),
    X(".X."),
    O(".O.");

    private final String value;

    private State(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
