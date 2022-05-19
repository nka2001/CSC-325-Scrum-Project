module com.csc229labfiles.bar_chart_experiment {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.csc229labfiles.bar_chart_experiment to javafx.fxml;
    exports com.csc229labfiles.bar_chart_experiment;
}
