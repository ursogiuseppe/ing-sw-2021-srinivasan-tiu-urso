package it.polimi.ingsw.server.lobby.messages.clientMessages.gameMessages.game;

import it.polimi.ingsw.client.SinglePlayerView;
import it.polimi.ingsw.controller.ServerController;
import it.polimi.ingsw.server.Connection;
import it.polimi.ingsw.server.lobby.messages.clientMessages.gameMessages.ClientGameMessage;

import java.io.Serializable;

public class PlayerStoresFromSupplyToExtraDeposit extends ClientGameMessage implements Serializable {
    private int leaderCardPos;
    private int from;
    private int to;

    public PlayerStoresFromSupplyToExtraDeposit(int leaderCardPos, int from, int to) {
        this.leaderCardPos = leaderCardPos;
        this.from = from;
        this.to = from;
    }

    @Override
    public void handle(Connection c, ServerController serverController) {
        int output = serverController.storeFromSupplyInExtraDeposit(c.getNickname(), leaderCardPos, from, to);
        if(output == 0) {
            c.sendSuccessfulMoveMessage("Successfull storage to extra deposit, adding resource to leader card " +
                    leaderCardPos + " on position " + to);
        }
    }

    @Override
    public void handleLocally(SinglePlayerView singlePlayerView, ServerController serverController) {
        int output = serverController.storeFromSupplyInExtraDeposit(singlePlayerView.getNickname(), leaderCardPos, from, to);
        if(output == 0) {
            singlePlayerView.printSuccessfulMove("Successfull storage to extra deposit, adding resource to leader card " +
                    leaderCardPos + " on position " + to);
        }
    }
}
