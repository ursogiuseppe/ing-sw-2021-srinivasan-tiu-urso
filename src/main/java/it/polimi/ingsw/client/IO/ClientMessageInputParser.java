package it.polimi.ingsw.client.IO;

import it.polimi.ingsw.client.IO.InputHandling.InputHandler;
import it.polimi.ingsw.client.IO.InputHandling.ViewHandler;
import it.polimi.ingsw.server.lobby.messages.clientMessages.ClientMessage;

public class ClientMessageInputParser {

    public static ClientMessage parseInput(String input, CLI cli) {

        String[] in = input.split(" ");
        String command = in[0].toUpperCase();

        return switch (command) {
            case "CREATEGAME" -> InputHandler.createGame(in); // tested
            case "SHOWGAMES"-> InputHandler.showGames(); // tested
            case "JOINGAME" -> InputHandler.joinGame(in, cli); // tested
            case "LEAVELOBBY" -> InputHandler.leaveLobby(in, cli); // tested
            case "QUIT" -> InputHandler.quit(in); // TODO fix
            case "SHOW" -> ViewHandler.show(in, cli); // tested
            case "DISCARDEXCESSCARD" -> InputHandler.discardExcessCard(in, cli); // tested ---
            case "BUYDEVELOPMENTCARD" -> InputHandler.buyDevelopmentCard(in, cli); // tested ---
            case "ENDTURN" -> InputHandler.endTurn(in); // tested ----
            case "DISCARDCARD" -> InputHandler.discardCard(in, cli); // -----
            case "GETFROMMARKET" -> InputHandler.getFromMarket(in, cli); // TODO fix WMRS ----
            case "STOREFROMSUPPLY" -> InputHandler.storeFromSupply(in, cli); // tested
            case "STOREFROMSUPPLYTOEXTRADEPOSIT" -> InputHandler.storeFromSupplyToExtraDeposit(in, cli); // TODO controllare se ho sistemato gli indici
            case "GETINITIALRESOURCES" -> InputHandler.getInitialResources(in, cli); // tested
            case "LOADGAMESETTINGS" -> InputHandler.loadGameSettings(in); // TODO test
            case "CHANGEDEPOSIT" -> InputHandler.changeDeposit(in, cli); // tested
            case "PLAYLEADERCARD" -> InputHandler.playLeaderCard(in, cli); // tested
            case "ACTIVATEDASHBOARDPRODUCTION" -> InputHandler.activateDashboardProduction(in, cli); // tested
            case "ACTIVATEDEVELOPMENTPRODUCTION" -> InputHandler.activateDevelopmentProduction(in, cli); // tested
            case "ACTIVATELEADERPRODUCTION" -> InputHandler.activateLeaderProduction(in, cli); // tested
            case "HACK" -> InputHandler.hack(); // used to give pretty much unlimited resources, testing purposes
            case "GIMME" -> InputHandler.gimme(in); // gives a developmentcard without paying, testing purposes
            case "PLAY" -> InputHandler.play(in); // plays a developmentcard without paying, testing purposes
            case "STARTGAME" -> InputHandler.startGame(in, cli);
            default -> {
                cli.printErrorMessage("Invalid Command");
                yield null;
            }
        };

    }
}
