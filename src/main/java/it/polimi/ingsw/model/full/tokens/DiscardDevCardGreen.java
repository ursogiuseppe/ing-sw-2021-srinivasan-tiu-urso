package it.polimi.ingsw.model.full.tokens;

import it.polimi.ingsw.model.full.table.DevelopmentCardGrid;
import it.polimi.ingsw.model.full.table.Game;

import java.io.Serializable;

public class DiscardDevCardGreen implements Token, Serializable {

    public static int COLOR_INDEX = 0;

    @Override
    public boolean useToken(Game game) {
        DevelopmentCardGrid developmentCardGrid = game.getGameBoard().getDevelopmentCardGrid();
        developmentCardGrid.discardCard(COLOR_INDEX);
        return developmentCardGrid.discardCard(COLOR_INDEX);
    }

    @Override
    public String getType() {
        return "green";
    }

}