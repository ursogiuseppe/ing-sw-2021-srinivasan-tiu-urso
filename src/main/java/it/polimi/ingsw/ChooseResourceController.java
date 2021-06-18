package it.polimi.ingsw;

import it.polimi.ingsw.client.ClientConnection;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ChooseResourceController {

    private static final int NUM_SHELFES = 6;
    private static final int EXTRA_DEPOSITS_SIZE = 2;

    private Slot[] depositSlots;

    private Slot[] extraDeposit1Slots;

    private Slot[] extraDeposit2Slots;

    @FXML
    private Pane pane;

    @FXML private Label labelGold;
    @FXML private Label labelShield;
    @FXML private Label labelStone;
    @FXML private Label labelServant;

    // TODO leaderCard WE

    @FXML
    public void initialize() {
        depositSlots = new Slot[NUM_SHELFES];
        extraDeposit1Slots = new Slot[EXTRA_DEPOSITS_SIZE];
        extraDeposit2Slots = new Slot[EXTRA_DEPOSITS_SIZE];

        depositSlots[0] = new Slot(230, 20, 40, 40);
        depositSlots[1] = new Slot(210, 60, 40, 40);
        depositSlots[2] = new Slot(250, 60, 40, 40);
        depositSlots[3] = new Slot(190, 100, 40, 40);
        depositSlots[4] = new Slot(230, 100, 40, 40);
        depositSlots[5] = new Slot(270, 100, 40, 40);
        extraDeposit1Slots[0] = new Slot(210, 390, 40, 40);
        extraDeposit1Slots[1] = new Slot(250, 390, 40, 40);

        extraDeposit2Slots[0] = new Slot(210, 450, 40, 40);
        extraDeposit2Slots[1] = new Slot(250, 450, 40, 40);

        for (Slot depositSlot : depositSlots) {
            depositSlot.setStroke(Color.RED);
            pane.getChildren().add(depositSlot.getRectangle());
        }

        for (Slot extraSlot : extraDeposit1Slots) {
            extraSlot.setStroke(Color.RED);
            pane.getChildren().add(extraSlot.getRectangle());
        }

        for (Slot extraSlot : extraDeposit2Slots) {
            extraSlot.setStroke(Color.RED);
            pane.getChildren().add(extraSlot.getRectangle());
        }
    }

    @FXML
    private void handleAddGold(InputEvent event) {
        int number = Integer.parseInt(labelGold.getText()) + 1;
        labelGold.setText(Integer.toString(number));
    }

    @FXML
    private void handleSubGold(InputEvent event) {
        int number = Math.max(Integer.parseInt(labelGold.getText()) - 1, 0);
        labelGold.setText(Integer.toString(number));
    }

    @FXML
    private void handleAddShield(InputEvent event) {
        int number = Integer.parseInt(labelShield.getText()) + 1;
        labelShield.setText(Integer.toString(number));
    }

    @FXML
    private void handleSubShield(InputEvent event) {
        int number = Math.max(Integer.parseInt(labelShield.getText()) - 1, 0);
        labelShield.setText(Integer.toString(number));
    }

    @FXML
    private void handleAddStone(InputEvent event) {
        int number = Integer.parseInt(labelStone.getText()) + 1;
        labelStone.setText(Integer.toString(number));
    }

    @FXML
    private void handleSubStone(InputEvent event) {
        int number = Math.max(Integer.parseInt(labelStone.getText()) - 1, 0);
        labelStone.setText(Integer.toString(number));
    }

    @FXML
    private void handleAddServant(InputEvent event) {
        int number = Integer.parseInt(labelServant.getText()) + 1;
        labelServant.setText(Integer.toString(number));
    }

    @FXML
    private void handleSubServant(InputEvent event) {
        int number = Math.max(Integer.parseInt(labelServant.getText()) - 1, 0);
        labelServant.setText(Integer.toString(number));
    }
}
