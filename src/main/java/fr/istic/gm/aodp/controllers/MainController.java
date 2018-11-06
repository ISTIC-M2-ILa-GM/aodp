package fr.istic.gm.aodp.controllers;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ToggleGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.chart.PieChart.Data;

@Getter
@Setter
public class MainController {
    @FXML
    private ToggleGroup broadCastMethod;

    @FXML
    private PieChart monitor1;

    @FXML
    private BarChart<Integer, Integer> monitor2;

    @FXML
    private BarChart<Integer, Integer> monitor3;

    @FXML
    private PieChart monitor4;

    public void initialize() {
        // listener to change the broadcast method
        this.broadCastMethod.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {

        });

        // dummy code
        this.monitor1.setStartAngle(0);
        this.monitor4.setStartAngle(0);
        this.setMonitor1Value(45);
        this.setMonitor2Value(22);
        this.setMonitor4Value(75);
    }

    public void setMonitor1Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.monitor1.setData(observableList);
    }

    public void setMonitor2Value(Integer value) {
        // Commented code below does not work

        /*

        ObservableList<XYChart.Data<Integer, Integer>> observableData = createBarChartData(value);
        Series<Integer, Integer> series = new Series<>();
        series.setData(observableData);
        List<Series<Integer, Integer>> seriesList = new ArrayList<>();
        seriesList.add(series);

        ObservableList<Series<Integer, Integer>> observableSeries = new ObservableListWrapper(seriesList);

        this.monitor2.setData(observableSeries);

        */
    }

    public void setMonitor4Value(Integer value) {
        ObservableList<Data> observableList = createPieChartData(value);
        this.monitor4.setData(observableList);
    }

    private ObservableList<Data> createPieChartData(Integer value) {
        List<Data> myList = new ArrayList<>();
        myList.add(new Data("", 100 - value));
        myList.add(new Data("value", value));

        return new ObservableListWrapper<>(myList);
    }

    /*

    private ObservableList<XYChart.Data<Integer, Integer>> createBarChartData(Integer value) {
        List<XYChart.Data<Integer, Integer>> list = new ArrayList<>();
        list.add(new XYChart.Data(0, value));

        ObservableList<XYChart.Data<Integer, Integer>> dataList;
        dataList = new ObservableListWrapper<XYChart.Data<Integer, Integer>>(list);

        return dataList;
    }

    */
}
