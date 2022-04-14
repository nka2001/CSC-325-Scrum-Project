module com.csc229labfiles.mavenproject8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.csc229labfiles.mavenproject8 to javafx.fxml;
    exports com.csc229labfiles.mavenproject8;
}
