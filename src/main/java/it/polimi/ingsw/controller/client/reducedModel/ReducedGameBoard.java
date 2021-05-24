package it.polimi.ingsw.controller.client.reducedModel;

import it.polimi.ingsw.model.cards.Card;
import it.polimi.ingsw.model.cards.DevelopmentCard;
import it.polimi.ingsw.model.cards.LeaderCard;
import it.polimi.ingsw.model.marbles.Marble;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReducedGameBoard {

    // Market
    static final int gridRowLength = 3;
    static final int gridColLength = 4;
    private Marble[] marblesGrid;

    // Development card grid
    public static final int GRID_ROW_LENGTH = 3;
    public static final int GRID_COL_LENGTH = 4;
    private List<Stack<DevelopmentCard>> grid;

    // Decks
    private List<LeaderCard> leaderCardDeck;
    private List<DevelopmentCard> developmentCardDeck;
    private List<Card> discardDeck;

    public ReducedGameBoard() {
        this.marblesGrid = new Marble[(gridRowLength * gridColLength) + 1];
        grid = new ArrayList<>();
        leaderCardDeck = new ArrayList<>();
        developmentCardDeck = new ArrayList<>();
        discardDeck = new ArrayList<>();
    }


}