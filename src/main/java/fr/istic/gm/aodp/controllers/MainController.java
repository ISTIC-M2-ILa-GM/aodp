package fr.istic.gm.aodp.controllers;

import com.sun.javafx.collections.ObservableListWrapper;
import fr.istic.gm.aodp.domain.Monitor;
import fr.istic.gm.aodp.domain.MonitorObserver;
import fr.istic.gm.aodp.enums.ChartIdentifier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ToggleGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.chart.PieChart.Data;

@Getter
@Setter
public class MainController implements MonitorObserver {
    @FXML
    private ToggleGroup broadCastMethod;

    @FXML
    private PieChart pieChart1;

    @FXML
    private BarChart<Integer, Integer> barChart2;

    @FXML
    private BarChart<Integer, Integer> barChart3;

    @FXML
    private PieChart pieChart4;

    private List<Monitor> monitors;

    public void initialize() {
        this.monitors = new ArrayList<>();

        // listener to change the broadcast method
        this.broadCastMethod.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            // TODO: change broadcast method
        });

        this.pieChart1.setStartAngle(0);
        this.pieChart4.setStartAngle(0);
        this.setMonitor1Value(0);
        this.setMonitor4Value(0);
    }

    public void addMonitor(Monitor monitor) {
        this.monitors.add(monitor);
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
