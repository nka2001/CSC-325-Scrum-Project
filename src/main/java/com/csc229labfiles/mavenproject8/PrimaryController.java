package com.csc229labfiles.mavenproject8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PrimaryController {
        @FXML
        PieChart pieChart;

        @FXML
        private void handleCovidData(ActionEvent event) {
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Latino", 13),
                    new PieChart.Data("Cacausion", 25),
                    new PieChart.Data("African American", 10),
                    new PieChart.Data("Asian", 22),
              new PieChart.Data("pacific Islander", 22));
            pieChart.setData(pieChartData);
            pieChart.setStartAngle(90);

            //Setting the title of the Pie chart 
            //setting the direction to arrange the data 
            //Setting the length of the label line 
            //Setting the labels of the pie chart visible  
            //Setting the start angle of the pie chart  
        }
    }


