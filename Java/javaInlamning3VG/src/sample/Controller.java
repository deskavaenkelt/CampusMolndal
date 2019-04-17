package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    private ToggleGroup movieToggleGroup;
    @FXML
    private ToggleGroup ticketToggleGroup;

    @FXML
    public void onButtonClicked() {
        if (ticketToggleGroup.getSelectedToggle().equals("1 ticket")) {
            System.out.println("Nice");
        }
    }

}
