package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class TicTacToe extends Game implements InteractionUtilisateur {
    public TicTacToe(GameDisplay affichage) {
        super(affichage);
        this.setWinCondition(3);
        this.setSizeRow(3);
        this.setSizeCol(3);
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
