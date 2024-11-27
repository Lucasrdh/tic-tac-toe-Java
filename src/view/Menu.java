package view;

public enum Menu {
    HOWTOPLAY("Entrez les coordonnées de votre coup (ligne et colonne, entre 1 et 3, séparées par un espace). Ex: 1 2\n"),
    CASEOCCUPEE("Case occupée, réessaie ! \n"),
    INVALIDE("Entrée invalide (ligne + colonne) ex = 1 1\n"),
    MATCHNUL("C'est un match nul !\n"),
    VICTOIRE("Victoire !\n"),
    SELECTGAMEMODE("Select game mode = 1 PvP, 2 PvM, 3 MvM : \n");

    private final String message;

    Menu(String message) {
        this.message = message;
    }

    public void display(Object... parameters) {
        System.out.printf(this.message, parameters);
    }
}

