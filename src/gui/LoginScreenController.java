package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {
@FXML
private Button nextButton;
@FXML
private Text usernameWarning;
@FXML
private TextField username;


    public void initialize(){
        setEventHandlers();
    }

   public void setEventHandlers(){
       username.setOnKeyPressed(new EventHandler<KeyEvent>(){
           @Override
           public void handle(KeyEvent event){

               UIMain.getModel().setUsernameEntered(true);
           }
       });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try{
                   if(!UIMain.getModel().getUsernameEntered()){
                       usernameWarning.setVisible(true);
                   }
                   else {
                       Parent root = FXMLLoader.load(getClass().getResource("TestingScanner.fxml"));
                       Scene testingScanner = new Scene(root);
                       UIMain.setCurrentScene(testingScanner, "ARGO Testing Scanner");
                   }
               }catch(IOException e){
                   e.printStackTrace();
               }
           }
       });


   }
}
