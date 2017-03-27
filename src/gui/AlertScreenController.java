package gui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class AlertScreenController {
    @FXML
    ComboBox errorAlert;
    @FXML
    ComboBox criticalAlert;
    @FXML
    ComboBox warningAlert;
    @FXML
    private Button exitButton;

    public void initialize(){
        initializeComboBoxes();
        setEventHandlers();}

    private void initializeComboBoxes(){
        errorAlert.getItems().add("Ping");
        errorAlert.getItems().add("Chime");
        errorAlert.getItems().add("Horn");

        criticalAlert.getItems().add("Ping");
        criticalAlert.getItems().add("Chime");
        criticalAlert.getItems().add("Horn");

        warningAlert.getItems().add("Ping");
        warningAlert.getItems().add("Chime");
        warningAlert.getItems().add("Horn");
    }

    private void setEventHandlers() {
        errorAlert.setOnAction(ee ->
                UIMain.getModel().setAlertTones(1, (String) errorAlert.getSelectionModel().getSelectedItem()));
        errorAlert.setPromptText(UIMain.getModel().getAlertTones(1));

        criticalAlert.setOnAction(ec ->
                UIMain.getModel().setAlertTones(2, (String) criticalAlert.getSelectionModel().getSelectedItem()));
        criticalAlert.setPromptText(UIMain.getModel().getAlertTones(2));


        warningAlert.setOnAction(ew ->
                UIMain.getModel().setAlertTones(0, (String) warningAlert.getSelectionModel().getSelectedItem()));
        warningAlert.setPromptText(UIMain.getModel().getAlertTones(0));

        exitButton.setOnAction(closeWindow -> {
            ((Node)(closeWindow.getSource())).getScene().getWindow().hide();
        });
    }
}
