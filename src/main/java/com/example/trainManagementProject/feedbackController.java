package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class feedbackController {

    @FXML
    private CheckBox average;
    @FXML
    private Button backButton;

    @FXML
    private CheckBox bad;

    @FXML
    private TextField contact;

    @FXML
    private TextField description;

    @FXML
    private CheckBox good;

    @FXML
    private TextField name;

    @FXML
    private Button submit;

    private String feedbackNature;

    public void onSubmitButton()
    {
        if(name.getText().isEmpty()|| contact.getText().isEmpty())
        {
            submit.setText("Empty Field!");
        }
        else
        {
            int Contact= Integer.parseInt(contact.getText());
            StationManagement.addFeedback(name.getText(),description.getText(),Contact,feedbackNature);
            submit.setText("Submitted !");
        }
    }

    public void onGoodCheckBox() {
        if (good.isSelected()) {
            bad.setDisable(true);
            average.setDisable(true);
            feedbackNature="Good";
        } else {
            bad.setDisable(false);
            average.setDisable(false);
        }
    }

    public void onAverageCheckBox() {
        if (average.isSelected()) {
            good.setDisable(true);
            bad.setDisable(true);
            feedbackNature="Average";
        } else {
            good.setDisable(false);
            bad.setDisable(false);
        }
    }

    public void onBadCheckBox() {
        if (bad.isSelected()) {
            good.setDisable(true);
            average.setDisable(true);
            feedbackNature="Bad";
        } else {
            good.setDisable(false);
            average.setDisable(false);
        }
    }

    public void onBackButton() throws IOException {
        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
    public void resetSubmitButton()
    {
        submit.setText("Submit");
    }

}
