package com.csc229labfiles.bar_chart_experiment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;

public class PrimaryController implements Initializable {

 

@FXML
private BarChart barChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series series1=new XYChart.Series();
        series1.getData().add(new XYChart.Data( "onama", 20));
               barChart.getData().add(series1);
    }



}
