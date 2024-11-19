public class Menu {

    public Menu() {

    }

    //    public String playerPseudo() {
//        System.out.println("Ton pseudo ?");
//        return player.nextLine();
//    }
//    public typePartie() {
//
//    }

    public void howtoPlay() {
        System.out.println("Entrez les coordonnées de votre coup (ligne et colonne, entre 1 et 3, séparées par un espace). Ex: 1 2");
    }

    public void caseOccupee() {
        System.out.println("Case occupée, réessaie ! ");
    }

    public void invalide() {
        System.out.println("Entrée invalide (ligne + colonne) ex = 0 1");
    }

    public void matchNul() {
        System.out.println("C'est un match nul !");
    }
    public void victoire(){
        System.out.println("Victoire !");
    }
    public void selectGameMode(){
        System.out.println("Select game mode = 1 PvP, 2 PvM, 3 MvM : ");
    }
}

