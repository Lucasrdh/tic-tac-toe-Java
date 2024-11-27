package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class Puissance4 extends Game implements InteractionUtilisateur {
    public Puissance4(GameDisplay affichage) {
        super(affichage);
        this.setWinCondition(4);

    }



    @Override
    protected int getGridSizeRow() {
        return 6;
    }
    @Override
    protected int getGridSizeColumn(){
        return 7;
    }
}
