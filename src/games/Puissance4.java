package games;

import ui.GameDisplay;
import ui.InteractionUtilisateur;

public class Puissance4 extends Game implements InteractionUtilisateur {
    public Puissance4(GameDisplay affichage) {
        super(affichage);
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
