package view;

public enum Menu {
    CASEOCCUPEE("Case occupée, réessaie ! \n"),
    INVALIDE("Entrée invalide (ligne + colonne) ex = 1 1\n"),
    MATCHNUL("C'est un match nul !\n"),
    VICTOIRE("Victoire !\n"),
    SELECTGAMEMODE("Select game mode = 1 PvP, 2 PvM, 3 MvM : \n"),
    SELECTGAME("Choisisser votre jeux : \n 1 - TicTacToe \n 2 - Puissance 4 \n 3 - Gomoku \n"),
    BONNEENTREE("Rentre des coordonnées entre 1 et %d pour la ligne, et entre 1 et %d pour la colonne.\n");

    private final String message;

    Menu(String message) {
        this.message = message;
    }

    public void display(Object... parameters) {
        System.out.printf(this.message, parameters);
    }
}

