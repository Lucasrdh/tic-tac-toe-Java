package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class Gomoku extends Game implements InteractionUtilisateur {
    public Gomoku(GameDisplay affichage) {
        super(affichage,15,15);
        this.setWinCondition(5);
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
