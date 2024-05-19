package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class paymentPageController implements Initializable
{
    @FXML
    private Button payButton;
    @FXML
    private TextField id;
    @FXML
    private TextField payment;
    @FXML
    private TextField amountDue;

    public void onPayButton()
    {
        if(id.getText().isEmpty()|| payment.getText().isEmpty())
        {
            payButton.setText("Empty Field!");
        }

        int ID= Integer.parseInt(id.getText());
        Double PAYMENT= Double.valueOf(payment.getText());
        Double AmountDue= Double.valueOf(amountDue.getText());
        
        Boolean passengerFound=false;


        if (PAYMENT>=AmountDue)
        {
            for (int i = 0; i < StationManagement.getPassengers().size(); i++) {

                if(ID == StationManagement.getPassengers().get(i).getPassengerID())
                {
                    StationManagement.getPassengers().get(i).setPassengerTicket(StationManagement.getPassengerTicket());
                    passengerFound=true;
                    payButton.setText("Ticket Purchased!");
                }
            }
            if(!passengerFound)
            {
                payButton.setText("Invalid ID!");
            }

        }

    }
    public void resetPayButton()
    {
        payButton.setText("Pay");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        String fare= String.valueOf(StationManagement.getPassengerTicket().calculateFare());
        amountDue.setText(fare);
    }
}
