package com.mycompany.csc325covidtracker;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    private void switchToUserInfo() throws IOException {
        App.setRoot("userinfo");
    }
    
    
    @FXML
    private void switchToAge() throws IOException{
        App.setRoot("userage");
    }
    
    @FXML
    private void switchToLocation() throws IOException{
        App.setRoot("userLocation");
    }
    
    @FXML
    private void switchToEthnicity() throws IOException{
        App.setRoot("userEthicity");
    }
    
    @FXML
    private void close(){
        System.exit(0);
    }
}
