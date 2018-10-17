package fr.istic.gm.aodp.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainController {
    @FXML
    private PieChart monitor1;

    @FXML
    private BarChart<Integer, Integer> monitor2;

    @FXML
    private BarChart<Integer, Integer> monitor3;

    @FXML
    private PieChart monitor4;
}
