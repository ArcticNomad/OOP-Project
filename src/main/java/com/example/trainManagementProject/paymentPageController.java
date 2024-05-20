package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class paymentPageController implements Initializable
{
    @FXML
    private Button payButton;
    @FXML
    private Button homeButton;
    @FXML
    private TextField id;
    @FXML
    private TextField payment;
    @FXML
    private TextField amountDue;
    @FXML
    private TextField change;
    @FXML
    private Button backButton;

    public void onPayButton()
    {
        if(id.getText().isEmpty()|| payment.getText().isEmpty())
        {
            payButton.setText("Empty Field!");
            return;
        }

        Boolean passengerFound=false;


        try {

            Long ID= Long.parseLong(id.getText());
            Double PAYMENT= Double.valueOf(payment.getText());
            Double AmountDue= Double.valueOf(amountDue.getText());

            if(PAYMENT<AmountDue)
            {
                payButton.setText("Insufficient Funds !");
                return;
            }

            if (PAYMENT >= AmountDue) {
                for (int i = 0; i < StationManagement.getPassengers().size(); i++) {

                    if (ID.equals(StationManagement.getPassengers().get(i).getPassengerID()))
                    {
                        StationManagement.getPassengerTicket().setPassenger(StationManagement.getPassengers().get(i));

                        StationManagement.getPassengerTicket().getPassenger().setFirstName(StationManagement.getPassengers().get(i).getFirstName());
                        StationManagement.getPassengerTicket().getPassenger().setLastName(StationManagement.getPassengers().get(i).getLastName());

                        StationManagement.getPassengerTicket().getPassenger().setPassengerID(ID);

                        StationManagement.getPassengers().get(i).setPassengerTicket(StationManagement.getPassengerTicket());
                        passengerFound = true;
                        payButton.setText("Ticket Purchased!");
                        double calculatedChange = StationManagement.getPassengerTicket().calculateChange(PAYMENT, AmountDue);
                        String cc = String.valueOf(calculatedChange);
                        change.setText(cc);
                    }
                }
                if (!passengerFound) {
                    payButton.setText("Invalid ID!");
                }

            }
        }catch (NumberFormatException e)
        {
            payButton.setText("Invalid Input!");
        }

    }
    public void resetPayButton()
    {
        payButton.setText("Pay");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        amountDue.setEditable(false);
        change.setEditable(false);
        String fare= String.valueOf(StationManagement.getPassengerTicket().calculateFare());
        amountDue.setText(fare);
    }
    public void onBackButton() throws IOException {
        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("buyTicket.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }

    public void onHomeButton() throws IOException {
        Stage stage=(Stage) backButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("mainPassengerPage.FXML"));

        Scene scene= new Scene(fxmlLoader.load());

        stage.setScene(scene);

        stage.show();
    }
}
