module com.example.ok {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ok to javafx.fxml;
    exports com.example.ok;
}