package com.mycompany.csc325covidtracker;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
