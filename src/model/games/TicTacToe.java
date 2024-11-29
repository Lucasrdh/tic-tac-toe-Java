package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class TicTacToe extends Game implements InteractionUtilisateur {
    public TicTacToe(GameDisplay affichage) {
        super(affichage,3,3);
        this.setWinCondition(3);

    }



    protected int getGridSizeRow() {
        return getSizeRow();
    }


    protected int getGridSizeColumn() {
        return getSizeCol();
    }

    @Override
    public int[] getGridSizeNeed() {
        return new int[]{getSizeRow(), getSizeCol()};
    }
}
