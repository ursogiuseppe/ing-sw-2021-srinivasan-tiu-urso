package it.polimi.ingsw.server.lobby.messages.clientMessages.lobbyMessage;

import it.polimi.ingsw.server.Connection;
import it.polimi.ingsw.server.lobby.Lobby;
import it.polimi.ingsw.server.lobby.messages.clientMessages.ClientMessage;

public abstract class ClientLobbyMessage extends ClientMessage {

    public abstract void handle(Connection connection, Lobby lobby);
}
