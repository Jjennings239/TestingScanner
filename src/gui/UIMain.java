package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UIMain extends Application {

    private static Stage pStage;
    private static UIModel model = new UIModel();

    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        primaryStage.setTitle("ARGO Testing Scanner");
        primaryStage.setScene(new Scene(root, 775, 400));
        primaryStage.show();
    }

    public static Stage getPrimaryStage(){
        return pStage;
    }

    private void setPrimaryStage(Stage pStage){
        UIMain.pStage = pStage;
    }

    public static void setCurrentScene(Scene scene, String title){
        Stage stage = UIMain.getPrimaryStage();
        stage.setTitle(title);
        stage.setScene(scene);
    }

    public static UIModel getModel(){
        return model;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
