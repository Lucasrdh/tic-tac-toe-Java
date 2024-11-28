package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class Gomoku extends Game implements InteractionUtilisateur {
    public Gomoku(GameDisplay affichage) {
        super(affichage);
        this.setWinCondition(5);
        this.setSizeRow(15);
        this.setSizeCol(15);
    }


    @Override
    protected int getGridSizeRow() {
        return getSizeRow();
    }

    @Override
    protected int getGridSizeColumn() {
        return getSizeCol();
    }

    @Override
    public int[] getGridSizeNeed() {
        return new int[]{getSizeRow(), getSizeCol()};
    }
}
