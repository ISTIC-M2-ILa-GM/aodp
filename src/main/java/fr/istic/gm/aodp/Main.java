package fr.istic.gm.aodp;

import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.activeobject.impl.MonitorImpl;
import fr.istic.gm.aodp.controllers.MainController;
import fr.istic.gm.aodp.diffusion.impl.CausalDiffusion;
import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.domain.Monitor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;

import static fr.istic.gm.aodp.enums.ChartIdentifier.MONITOR_1;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Generator generator = GeneratorStarter.start(new CausalDiffusion(), 4000);
        Monitor monitor1 = new MonitorImpl(MONITOR_1);
        Canal canal1 = new Canal(monitor1, Executors.newScheduledThreadPool(4), 500L);
        generator.attach(canal1);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/rootPane.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.addMonitor(monitor1);
        monitor1.attach(mainController);

        primaryStage.setTitle("Active Object");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Main.launch(args);
    }
}
