package fr.istic.gm.aodp.controllers;

import com.sun.javafx.collections.ObservableListWrapper;
import fr.istic.gm.aodp.activeobject.impl.Canal;
import fr.istic.gm.aodp.activeobject.impl.GeneratorImpl;
import fr.istic.gm.aodp.activeobject.impl.MonitorImpl;
import fr.istic.gm.aodp.diffusion.Diffusion;
import fr.istic.gm.aodp.diffusion.impl.AtomicDiffusion;
import fr.istic.gm.aodp.diffusion.impl.CausalDiffusion;
import fr.istic.gm.aodp.diffusion.impl.SequentialDiffusion;
import fr.istic.gm.aodp.domain.Generator;
import fr.istic.gm.aodp.domain.Monitor;
import fr.istic.gm.aodp.domain.MonitorObserver;
import fr.istic.gm.aodp.enums.ChartIdentifier;
import fr.istic.gm.aodp.memento.impl.MementoFactoryImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static fr.istic.gm.aodp.enums.ChartIdentifier.*;
import static javafx.scene.chart.PieChart.Data;

@Getter
@Setter
public class MainController implements MonitorObserver {
    @FXML
    public Button generateButton;


    @FXML
    private ToggleGroup broadCastMethod;

    @FXML
    private RadioButton atomicBroadcast;

    @FXML
    private RadioButton sequentialBroadcast;

    @FXML
    private RadioButton causalBroadcast;

    @FXML
    private PieChart pieChart1;

    @FXML
    private PieChart pieChart2;

    @FXML
    private PieChart pieChart3;

    @FXML
    private PieChart pieChart4;

    private Generator generator;

    private Diffusion myDiffusion;

    private Canal canal1;

    private Canal canal2;

    private Canal canal3;

    private Canal canal4;

    private Monitor monitor1;

    private Monitor monitor2;

    private Monitor monitor3;

    private Monitor monitor4;

    private ScheduledExecutorService scheduledExecutorService;

    public void initialize() {
        this.myDiffusion = new CausalDiffusion();
        this.generator = new GeneratorImpl(this.myDiffusion);
        this.monitor1 = new MonitorImpl(MONITOR_1);
        this.monitor2 = new MonitorImpl(MONITOR_2);
        this.monitor3 = new MonitorImpl(MONITOR_3);
        this.monitor4 = new MonitorImpl(MONITOR_4);

        ScheduledExecutorService updateScheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledExecutorService getUpdateScheduledExecutorService = Executors.newScheduledThreadPool(2);

        this.canal1 = new Canal(this.monitor1, updateScheduledExecutorService, getUpdateScheduledExecutorService, 500L);
        this.canal2 = new Canal(this.monitor2, updateScheduledExecutorService, getUpdateScheduledExecutorService, 800L);
        this.canal3 = new Canal(this.monitor3, updateScheduledExecutorService, getUpdateScheduledExecutorService, 1000L);
        this.canal4 = new Canal(this.monitor4, updateScheduledExecutorService, getUpdateScheduledExecutorService, 1200L);

        this.generator.attach(this.canal1);
        this.generator.attach(this.canal2);
        this.generator.attach(this.canal3);
        this.generator.attach(this.canal4);

        this.monitor1.attach(this);
        this.monitor2.attach(this);
        this.monitor3.attach(this);
        this.monitor4.attach(this);


        // set default values
        this.pieChart1.setStartAngle(0);
        this.pieChart2.setStartAngle(0);
        this.pieChart3.setStartAngle(0);
        this.pieChart4.setStartAngle(0);
        this.setMonitor1Value(0);
        this.setMonitor2Value(0);
        this.setMonitor3Value(0);
        this.setMonitor4Value(0);

        // listener to change the broadcast method
        this.broadCastMethod.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == this.atomicBroadcast) {
                this.myDiffusion = new AtomicDiffusion();
            } else if (newValue == this.causalBroadcast) {
                this.myDiffusion = new CausalDiffusion();
            } else if (newValue == this.sequentialBroadcast) {
                this.myDiffusion = new SequentialDiffusion(new MementoFactoryImpl());
            }

            // Create new generator
            this.generator = new GeneratorImpl(this.myDiffusion);
            this.generator.attach(this.canal1);
            this.generator.attach(this.canal2);
            this.generator.attach(this.canal3);
            this.generator.attach(this.canal4);
        });
    }

    public void generate() {
        this.generator.generate();
    }

    private void setMonitor1Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart1.setData(observableList);
    }

    private void setMonitor2Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart2.setData(observableList);
    }

    private void setMonitor3Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart3.setData(observableList);
    }

    private void setMonitor4Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.pieChart4.setData(observableList);
    }

    private ObservableList<Data> createPieChartData(Integer value) {
        List<Data> myList = new ArrayList<>();
        myList.add(new Data("", 100 - value));
        myList.add(new Data(value.toString(), value));

        return new ObservableListWrapper<>(myList);
    }

    @Override
    public void update(ChartIdentifier c, Integer i) {
        switch (c) {
            case MONITOR_1:
                this.setMonitor1Value(i);
                break;
            case MONITOR_2:
                this.setMonitor2Value(i);
                break;
            case MONITOR_3:
                this.setMonitor3Value(i);
                break;
            case MONITOR_4:
                this.setMonitor4Value(i);
                break;
        }
    }
}
