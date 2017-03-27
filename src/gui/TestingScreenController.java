package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class TestingScreenController {
    @FXML
    private MenuItem selectAlert;
    @FXML
    private Button zipFileButton, sourceFileButton, startButton, pauseButton;
    @FXML
    private TextField zipFileText, sourceFileText;
    @FXML
    private CheckBox warningBox, criticalBox, errorBox;



    public void initialize() {
        //auto-set pause button to be off to show scan not running
        pauseButton.setDisable(true);
        setEventHandlers();
    }

    @FXML
    void setEventHandlers() {

        //Checks if "Alert Configuration" was selected from menu
        // and then opens Alert Screen
        selectAlert.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AlertScreen.fxml"));
                Stage alertStage = new Stage();
                Scene alertScreen = new Scene(root);
                alertStage.setScene(alertScreen);
                alertStage.setTitle("Alerts");
                alertStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Finds Source File Name and Path
        sourceFileButton.setOnAction(sourceButton -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File sourceFile = fileChooser.showOpenDialog(UIMain.getPrimaryStage());
            UIMain.getModel().setSourceFilePath(sourceFile.getPath());
            UIMain.getModel().setSourceFileName(sourceFile.getName());
            sourceFileText.setText(String.format("%1$40s", UIMain.getModel().getSourceFileName()));
        });

        //Finds Zip File Name and Path
        zipFileButton.setOnAction(zipButton -> {
            DirectoryChooser fileChooser = new DirectoryChooser();
            fileChooser.setTitle("Open Resource File");
            File sourceFile = fileChooser.showDialog(UIMain.getPrimaryStage());
            UIMain.getModel().setZipFilePath(sourceFile.getPath());
            UIMain.getModel().setZipFileName(sourceFile.getName());
            zipFileText.setText(String.format("%1$40s", UIMain.getModel().getZipFileName()));
        });

        //Check if "Start Scan" was pressed
        startButton.setOnAction(startScan -> {
            startButton.setDisable(true);
            pauseButton.setDisable(false);
            UIMain.getModel().setRunStatus(true);
        });

        //Check if "Pause Scan" button was pressed
        pauseButton.setOnAction(pauseScan -> {
            startButton.setDisable(false);
            pauseButton.setDisable(true);
            UIMain.getModel().setRunStatus(false);
        });

        //Listens for when warning checkbox changes
        //Then update severityBoxes array in UIModel
        warningBox.setOnAction(warningButton -> {
            if (warningBox.isSelected() == true) {
                UIMain.getModel().setSeverityBoxes(0, true);
            } else if (warningBox.isSelected() == false) {
                UIMain.getModel().setSeverityBoxes(0, false);
            }
        });

        //Listens for when error checkbox changes
        //Then updates severityBoxes array in UIModel
        errorBox.setOnAction(errorButton -> {
            if (errorBox.isSelected() == true) {
                UIMain.getModel().setSeverityBoxes(1, true);
            } else if (errorBox.isSelected() == false) {
                UIMain.getModel().setSeverityBoxes(1, false);
            }
        });

        //Listens for when critical checkbox changes
        //Then updates severityBoxes array in UIModel
        criticalBox.setOnAction(criticalButton -> {
            if (criticalBox.isSelected() == true) {
                UIMain.getModel().setSeverityBoxes(2, true);
            } else if (criticalBox.isSelected() == false) {
                UIMain.getModel().setSeverityBoxes(2, false);
            }
        });
    }
}


