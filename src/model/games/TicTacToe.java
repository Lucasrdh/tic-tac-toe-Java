package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class TicTacToe extends Game implements InteractionUtilisateur {


    public TicTacToe(GameDisplay affichage) {
        super(affichage);
this.setWinCondition(3);
    }

    @Override
    protected int getGridSizeColumn() {
        return 3;
    }

    @Override
    protected int getGridSizeRow() {
        return 3;
    }


}