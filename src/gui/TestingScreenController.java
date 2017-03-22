package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TestingScreenController {
    @FXML
    MenuItem selectAlert;
    @FXML
    Button zipFileButton;
    @FXML
    Button sourceFileButton;
    @FXML
    TextField zipFileText;
    @FXML
    TextField sourceFileText;
    @FXML
    Button startButton;
    @FXML
    Button pauseButton;
    @FXML
    TableView dataTable;

    boolean appRunning;

    private ObservableList<String> data = FXCollections.observableArrayList("1", "2", "3", "4");

    public void initialize(){
        pauseButton.setDisable(true);
        setEventHandlers();
    }

    public void setEventHandlers(){
        selectAlert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               try {
                   Parent root = FXMLLoader.load(getClass().getResource("AlertScreen.fxml"));
                   Stage alertStage = new Stage();
                   Scene alertScreen  = new Scene(root);
                   alertStage.setScene(alertScreen);
                   alertStage.setTitle("Alerts");
                   alertStage.show();
               }
               catch(IOException e){
                   e.printStackTrace();
               }
               }
        });

        zipFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.showOpenDialog(UIMain.getPrimaryStage());
            }
        });
        sourceFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File sourceFile = fileChooser.showOpenDialog(UIMain.getPrimaryStage());
                String sourcePath = sourceFile.getPath();
                String sourceFilename = sourceFile.getName();
                sourceFileText.setText(String.format("%1$40s", sourceFilename));

            }
        });

        zipFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DirectoryChooser fileChooser = new DirectoryChooser();
                fileChooser.setTitle("Open Resource File");
                File sourceFile = fileChooser.showDialog(UIMain.getPrimaryStage());
                String zipPath = sourceFile.getPath();
                String zipFilename = sourceFile.getName();
                System.out.println(zipPath);
                zipFileText.setText(String.format("%1$40s", zipFilename));
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startButton.setDisable(true);
                pauseButton.setDisable(false);
                appRunning = true;

                dataTable.setEditable(true);
            }
        });

        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startButton.setDisable(false);
                pauseButton.setDisable(true);
                appRunning = false;
            }
        });

    }

}
