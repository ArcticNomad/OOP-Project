package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class mainTicketDetailsPageController
{
    @FXML
    private Button displayButton;
    @FXML
    private Button homeButton;
    private Boolean ID_Found=false;
    @FXML
    public TextField cnic;

    public static Long getID() {
        return ID;
    }

    public static void setID(Long ID) {
        mainTicketDetailsPageController.ID = ID;
    }

    static Long ID;

    public void onDisplayButton() throws IOException
    {

        if(cnic.getText().isEmpty())
        {
            displayButton.setText("Empty Field!");
            return;
        }
            try
            {
                ID= Long.valueOf(cnic.getText());

                if (StationManagement.checkID(ID))
                {
                    displayButton.setText("Invalid ID!");
                }

                for (int i = 0; i < StationManagement.getPassengers().size(); i++)
                {
                    if (ID.equals(StationManagement.getPassengers().get(i).getPassengerID()))
                    {
                        ID_Found=true;

                        Stage stage=(Stage) displayButton.getScene().getWindow();

                        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("TicketDetails.FXML"));

                        Scene scene= new Scene(fxmlLoader.load());

                        stage.setScene(scene);

                        stage.show();
                    }
                }
                if (!ID_Found)
                {
                    displayButton.setText("ID Not Found!");
                }
            }catch (NumberFormatException e)
            {
                displayButton.setText("Invalid Input!");
            }catch (NullPointerException e)
            {
                displayButton.setText("No Tickets Purchased!");
            }

    }

    public void resetDisplayButton()
    {
        displayButton.setText("Display");
    }
    public void onHomeButton() throws IOException {
        Stage stage=(Stage) homeButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }


}
