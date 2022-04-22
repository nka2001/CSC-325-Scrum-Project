package com.mycompany.csc325covidtracker;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class UserInfoController {

    @FXML
    private ToggleGroup ageDemo;
    @FXML
    private ToggleGroup ethn;
    @FXML
    private ToggleGroup VaccStatus;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}