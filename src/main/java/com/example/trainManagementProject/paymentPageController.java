package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class paymentPageController
{
    @FXML
    private Button payButton;
    @FXML
    private TextField id;

    public void onPayButton()
    {
        int ID= Integer.parseInt(id.getText());

        for (int i = 0; i < StationManagement.getPassengers().size(); i++) {

            if(ID == StationManagement.getPassengers().get(i).getPassengerID())
            {
                StationManagement.getPassengers().get(i).setPassengerTicket(StationManagement.getPassengerTicket());
                payButton.setText("Ticket Purchased!");
            }
        }
    }

}
