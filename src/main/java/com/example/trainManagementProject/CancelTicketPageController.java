package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CancelTicketPageController
{
    @FXML
    private Button homeButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField cnic;

    public void onCancelTicketButton()
    {

        try
        {
            if (cnic.getText().isEmpty())
            {
                cancelButton.setText("Empty Field!");
                return;
            }


            Long CNIC= Long.valueOf(cnic.getText());

            if (StationManagement.checkID(CNIC))
            {
                cancelButton.setText("Invalid ID!");
                return;
            }
            for (int i = 0; i < StationManagement.getPassengers().size(); i++)
            {
                if (!StationManagement.getPassengers().get(i).getPassengerID().equals(CNIC))
                {
                    cancelButton.setText("ID not Found!");
                    return;
                }
            }

            for (int i = 0; i < StationManagement.getPassengers().size(); i++)
            {
                if(StationManagement.getPassengers().get(i).getPassengerTicket()!=null)
                {
                    StationManagement.setPassengerTicket(null);
                    StationManagement.getTrains().get(i).setCapacity(StationManagement.getTrains().get(i).getCapacity()+1);
                    cancelButton.setText("Cancelled!");
                    return;
                }
                else
                {
                    cancelButton.setText("No Ticket Purchased!");
                }
            }
        }catch (NullPointerException e)
        {
            cancelButton.setText("No Ticket Purchased!");
        }catch (NumberFormatException e)
        {
            cancelButton.setText("Invalid Input!");
        }

    }

    public void onHomeButton() throws IOException {
        Stage stage=(Stage) homeButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("addPassenger.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
    public void resetCancelButton()
    {
        cancelButton.setText("Cancel");
    }
}
