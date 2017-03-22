package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.awt.event.ActionListener;
import java.util.Observable;

public class AlertScreenController {
    @FXML
    ComboBox errorAlert;
    @FXML
    ComboBox criticalAlert;
    @FXML
    ComboBox warningAlert;

    private String errorAlertTone;
    private String criticalAlertTone;
    private String warningAlertTone;

    public void initialize(){
        initializeComboBoxes();
        setEventHandlers();

    }

    public void initializeComboBoxes(){
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

    public void setEventHandlers(){
        errorAlert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                errorAlertTone = (String)errorAlert.getSelectionModel().getSelectedItem();
                errorAlert.setPromptText(errorAlertTone);

            }
        });

        criticalAlert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                criticalAlertTone = (String)criticalAlert.getSelectionModel().getSelectedItem();
                criticalAlert.setPromptText(criticalAlertTone);

            }
        });

        warningAlert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                warningAlertTone = (String)warningAlert.getSelectionModel().getSelectedItem();
                warningAlert.setPromptText(warningAlertTone);

            }
        });

    }


}
