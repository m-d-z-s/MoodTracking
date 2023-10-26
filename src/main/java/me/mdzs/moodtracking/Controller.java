package me.mdzs.moodtracking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    @FXML
    private Button buttonSend;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<String> comboBox;


    @FXML
    protected void SendClick(ActionEvent event) {
        System.out.println("Button clicked!");
    }
}