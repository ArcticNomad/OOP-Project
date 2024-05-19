package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class feedbackController
{

    @FXML
    private CheckBox average;

    @FXML
    private CheckBox bad;

    @FXML
    private TextField contact;

    @FXML
    private TextField descripton;

    @FXML
    private CheckBox good;

    @FXML
    private TextField name;

    @FXML
    private Button submit;

    int feedbackNature;

    public void onSubmitButton()
    {


        //StationManagement.addFeedback();
    }

    public void onGoodCheckBox()
    {
        bad.setDisable(true);
        average.setDisable(true);
    }
    public void onAverageCheckBox()
    {
        good.setDisable(true);
        bad.setDisable(true);
    }
    public void onBadCheckBod()
    {
        good.setDisable(true);
        average.setDisable(true);
    }

    public void resetCheckBoxes()
    {
        good.setDisable(false);
        bad.setDisable(false);
        average.setDisable(false);
    }


}