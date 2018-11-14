package fr.istic.gm.aodp;

import fr.istic.gm.aodp.activeobject.impl.Monitor;
import fr.istic.gm.aodp.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/rootPane.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.addMonitor(new Monitor());
        mainController.addMonitor(new Monitor());
        mainController.addMonitor(new Monitor());
        mainController.addMonitor(new Monitor());

        primaryStage.setTitle("Active Object");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
