package fr.istic.gm.aodp.controllers;

import com.sun.javafx.collections.ObservableListWrapper;
import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.activeobject.impl.MonitorImpl;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.impl.AtomicDiffusion;
import fr.istic.gm.aodp.diffusion.impl.CausalDiffusion;
import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.domain.Monitor;
import fr.istic.gm.aodp.domain.MonitorObserver;
import fr.istic.gm.aodp.enums.ChartIdentifier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static fr.istic.gm.aodp.enums.ChartIdentifier.MONITOR_1;
import static javafx.scene.chart.PieChart.Data;

@Getter
@Setter
public class MainController implements MonitorObserver {
    @FXML public Button generateButton;


    @FXML private ToggleGroup broadCastMethod;

    @FXML private RadioButton atomicBroadcast;

    @FXML private RadioButton sequentialBroadcast;

    @FXML private RadioButton causalBroadcast;

    @FXML private PieChart pieChart1;

    @FXML private BarChart<Integer, Integer> barChart2;

    @FXML private BarChart<Integer, Integer> barChart3;

    @FXML private PieChart pieChart4;

    private Generator generator;

    private Diffusion myDiffusion;

    private Canal canal1;

    private Monitor monitor;

    public void initialize() {
        this.myDiffusion = new CausalDiffusion();
        this.generator = new GeneratorImpl(this.myDiffusion);
        this.monitor = new MonitorImpl(MONITOR_1);
        this.canal1 = new Canal(this.monitor, Executors.newScheduledThreadPool(4), 500L);
        this.generator.attach(this.canal1);


        this.pieChart1.setStartAngle(0);
        this.pieChart4.setStartAngle(0);
        this.setMonitor1Value(0);
        this.setMonitor4Value(0);

        // listener to change the broadcast method
        this.broadCastMethod.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == this.atomicBroadcast) {
                this.myDiffusion = new AtomicDiffusion();
            } else if (newValue == this.causalBroadcast) {
                this.myDiffusion = new CausalDiffusion();
            } else if (newValue == this.sequentialBroadcast) {
                // TODO: add sequential diffusion
            }

            // Create new generator
            this.generator = new GeneratorImpl(this.myDiffusion);

        });
    }

    public void generate() {
        this.generator.generate();

        this.generator.generate();
    }

    public void setMonitor1Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart1.setData(observableList);
    }

    public void setMonitor2Value(Integer value) {
        // TODO: implement method
    }

    public void setMonitor3Value(Integer value) {
        // TODO: implement method
    }

    public void setMonitor4Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart4.setData(observableList);
    }

    private ObservableList<Data> createPieChartData(Integer value) {
        List<Data> myList = new ArrayList<>();
        myList.add(new Data("", 100 - value));
        myList.add(new Data("value", value));

        return new ObservableListWrapper<>(myList);
    }

    @Override
    public void update(ChartIdentifier c, Integer i) {
        switch (c) {
            case MONITOR_1:
                this.setMonitor1Value(i);
                break;
            case MONITOR_2:
                // TODO: update monitor 2
                break;
            case MONITOR_3:
                // TODO: update monitor 2
                break;
            case MONITOR_4:
                this.setMonitor4Value(i);
                break;
        }
    }
}
