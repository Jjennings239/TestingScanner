package gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;

public class LoginScreenController {
    @FXML
    private Button nextButton;
    @FXML
    private Text usernameWarning;
    @FXML
    private TextField username;

    void initialize(){setEventHandlers();}

    void setEventHandlers(){
       username.setOnKeyPressed(getUsername ->{

               UIMain.getModel().setUsernameEntered(true);
       });

        nextButton.setOnAction(startTest -> {
               try{
                   if(!UIMain.getModel().getUsernameEntered()){
                       usernameWarning.setVisible(true);
                   }
                   else {
                       UIMain.getModel().setUsername(username.getText());
                       Parent root = FXMLLoader.load(getClass().getResource("TestingScanner.fxml"));
                       Scene testingScanner = new Scene(root);
                       UIMain.setCurrentScene(testingScanner, "ARGO Testing Scanner");
                   }
               }catch(IOException e){
                   e.printStackTrace();
               }
       });
    }
}
