package com.example.file_io.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    public TextArea txtArea;

    FileChooser fileChooser;
    File file;


    public void onOpen(ActionEvent event) {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Ambil file");
        file = fileChooser.showOpenDialog(txtArea.getScene().getWindow());

        if (file == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("NO FILE SELECTED");
            alert.showAndWait();
        } else {
            try {
                Path path = Paths.get(file.toURI());
                String hasil = "";
                for (String something : Files.readAllLines(path)) {
                    hasil += something + '\n';
                }
                txtArea.setText(hasil);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void OnSaveAs() {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        chooser.getExtensionFilters().add(extFilter);
        File fileSaveas = chooser.showSaveDialog(txtArea.getScene().getWindow());
        if (fileSaveas == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No Name and Directory Selected, FAILED to SAVE DATA");
            alert.showAndWait();
        } else {
            Path p = Paths.get(fileSaveas.toURI());
            try {
                Files.write(p, txtArea.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void onSave(ActionEvent event) {
        if (file == null) {
            OnSaveAs();
        } else {
            Path p = Paths.get(file.toURI());
            try {

                Files.write(p, txtArea.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}