module com.example.file_io {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.file_io to javafx.fxml;
    exports com.example.file_io;
    exports com.example.file_io.controller;
    opens com.example.file_io.controller to javafx.fxml;
}