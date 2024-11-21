package games;

import player.*;
import cell.*;
import ui.*;

public class TicTacToe extends Game implements InteractionUtilisateur {


    public TicTacToe(GameDisplay affichage) {
        super(affichage);

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