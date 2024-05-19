package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.Passenger.Passenger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addPassengerController
{
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField id;
    @FXML
    private TextField age;
    @FXML
    private Button doneButton;

    @FXML
    private static ArrayList <Passenger> passengers=new ArrayList<>();


    public void onDoneButton() throws IOException {

        if (firstName.getText().isEmpty()||lastName.getText().isEmpty()||id.getText().isEmpty()||age.getText().isEmpty())
        {
            doneButton.setText("Error!");
        }
        else {

            Integer ID= Integer.valueOf(id.getText());
            Integer Age= Integer.valueOf(age.getText());
            passengers.add(new Passenger(ID,firstName.getText(),lastName.getText(),Age));


            Stage stage = (Stage) doneButton.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

            stage.show();
        }
    }

}
