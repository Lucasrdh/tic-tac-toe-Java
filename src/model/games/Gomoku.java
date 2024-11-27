package model.games;
import view.GameDisplay;
import view.InteractionUtilisateur;

public class Gomoku extends Game implements InteractionUtilisateur {


    public Gomoku(GameDisplay affichage) {
        super(affichage);
        this.setWinCondition(5);

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