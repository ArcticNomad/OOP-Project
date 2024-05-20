package com.example.trainManagementProject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("selectionScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
        stage.setTitle("Train Management System");
        stage.setScene(scene);
        Image image = new Image("file:///C:/Users/Arc/Documents/GitHub/OOP-Project/src/trainImage.png");

        stage.getIcons().add(image);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}