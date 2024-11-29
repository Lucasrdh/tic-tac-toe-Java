package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class Puissance4 extends Game implements InteractionUtilisateur {
    public Puissance4(GameDisplay affichage) {
        super(affichage,6,7);
        this.setWinCondition(4);

    }




    @Override
    public int[] getGridSizeNeed() {
        return new int[]{getSizeRow(), getSizeCol()};
    }
}
