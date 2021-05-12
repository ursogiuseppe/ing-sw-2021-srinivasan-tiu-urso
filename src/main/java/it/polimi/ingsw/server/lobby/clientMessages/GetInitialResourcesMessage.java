package it.polimi.ingsw.server.lobby.clientMessages;

import it.polimi.ingsw.controller.ServerController;
import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.server.Connection;
import it.polimi.ingsw.server.lobby.clientMessages.ClientMessage;

public class GetInitialResourcesMessage implements ClientMessage {

    Resource resource;
    int position;

    public GetInitialResourcesMessage(Resource resource, int position) {
        this.resource = resource;
        this.position = position;
    }

    @Override
    public void handle(Connection c, ServerController serverController) {
        try {
            serverController.getInitialResources(c.getNickname(), resource, position);
        } catch (Exception e) {
            // TODO
        }
    }
}
