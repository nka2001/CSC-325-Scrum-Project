package com.mycompany.csc325covidtracker;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    @FXML
    private void switchToAge() throws IOException{
        App.setRoot("secondary_1");
    }
    
    @FXML
    private void switchToLocation() throws IOException{
        App.setRoot("secondary_2_1");
    }
    
    @FXML
    private void switchToEthnicity() throws IOException{
        App.setRoot("secondary_2");
    }
    
    @FXML
    private void close(){
        System.exit(0);
    }
}
