package games;
import ui.*;

public class Gomoku extends Game implements InteractionUtilisateur {


    public Gomoku(GameDisplay affichage) {
        super(affichage);

    }

    @Override
    protected int getGridSizeColumn() {
        return 15;
    }

    @Override
    protected int getGridSizeRow() {
        return 15;
    }


}