package com.example.file_io;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FileIO_Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FileIO_Application.class.getResource("first_layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("File-I/O-2072042-MosesMarzukiSamosir");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}