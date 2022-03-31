module com.mycompany.csc325covidtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.csc325covidtracker to javafx.fxml;
    exports com.mycompany.csc325covidtracker;
}
