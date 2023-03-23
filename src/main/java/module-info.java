module com.example.prtinterfaz4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prtinterfaz4 to javafx.fxml;
    exports com.example.prtinterfaz4;
}