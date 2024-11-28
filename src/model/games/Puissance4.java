package model.games;

import view.GameDisplay;
import view.InteractionUtilisateur;

public class Puissance4 extends Game implements InteractionUtilisateur {
    public Puissance4(GameDisplay affichage) {
        super(affichage);
        this.setWinCondition(4);
        this.setSizeRow(6);
        this.setSizeCol(7);
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
