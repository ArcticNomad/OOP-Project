package com.example.trainManagementProject;

import com.example.trainManagementProject.backendClasses.Route.*;
import com.example.trainManagementProject.backendClasses.Station.Cities;
import com.example.trainManagementProject.backendClasses.Station.Station;
import com.example.trainManagementProject.backendClasses.StationManagement.StationManagement;
import com.example.trainManagementProject.backendClasses.Train.BusinessClass;
import com.example.trainManagementProject.backendClasses.Train.EconomyClass;
import com.example.trainManagementProject.backendClasses.Train.Facilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;

public class MainAdminPageController implements Initializable
{


    // STATION DETAILS

    @FXML
    private TextField stationName;
    public ChoiceBox<Cities> stationCity=new ChoiceBox<>();
    @FXML
    private Button addStationButton ;
    @FXML
    private Button addTrainButton;
    @FXML
    private Button addRouteButton;

    // TRAIN DETAILS
    @FXML
    public TextField trainNumber;
    @FXML
    private TextField trainSpeed;
    @FXML
    private TextField trainCapacity;
    @FXML
    private TextField businessCapacity;
    @FXML
    private ChoiceBox<Facilities> businessFacility=new ChoiceBox<>();
    @FXML
    private TextField economyCapacity;
    @FXML
    private ChoiceBox<Facilities> economyFacility=new ChoiceBox<>();

    // ROUTE DETAILS
    @FXML
    public TextField departStationName;
    @FXML
    private TextField arrivalStationName;

    // ROUTE SCHEDULE DETAILS
    @FXML
    private ChoiceBox<Days> departDay;
    @FXML
    private ChoiceBox<Months> departMonth;
    @FXML
    private TextField departYear;
    @FXML
    private ChoiceBox<Days> arrivalDay;
    @FXML
    private ChoiceBox<Months> arrivalMonth;
    @FXML
    private TextField arrivalYear;

    @FXML
    private TextField departHour;
    @FXML
    private TextField departMin;
    @FXML
    private TextField arrivalHour;

    @FXML
    private TextField arrivalMin;
    @FXML
    private ChoiceBox<Timing> departAmPm=new ChoiceBox<>();
    @FXML
    private ChoiceBox<Timing> arrivalAmPm=new ChoiceBox<>();

    @FXML
    private TextField distanceBwStations;
    @FXML
    private TextField assignRouteText;
    @FXML
    private Button assignRouteButton;
    @FXML
    private TextArea trainNumbers;
    @FXML
    private TextArea stationLists;

    @FXML
    private Button homeButton;
    public void onAddStationButton() throws IOException
    {
        if(stationName.getText().isEmpty() || stationCity.getValue()==null)
        {
            addStationButton.setText("Empty Field !");
        }

        else if (checkStringForInteger(stationName.getText()))
        {
            addStationButton.setText("Alphabets Only !");
        }

        else if (StationManagement.checkDuplicateStation(stationName.getText()))
        {
            addStationButton.setText("Duplicate Station!");
        }
        else
        {
            StationManagement.addStation(stationName.getText(),stationCity.getValue());
            addStationButton.setText("Added!");
        }

    }

    public static BusinessClass businessClass;
    public static EconomyClass economyClass;

    public void onAddTrainButton()
    {
        if(trainNumber.getText().isEmpty()||trainSpeed.getText().isEmpty()||businessCapacity.getText().isEmpty()||economyCapacity.getText().isEmpty()||trainCapacity.getText().isEmpty()||businessFacility.getItems().isEmpty()||economyFacility.getItems().isEmpty())
        {
            addTrainButton.setText("Empty Field!");
            return;
        }
        try {
            Integer businessCap = Integer.valueOf(businessCapacity.getText());
            Integer ecoCap = Integer.valueOf(economyCapacity.getText());



            int cap = Integer.parseInt(trainCapacity.getText());
            int num = Integer.parseInt(trainNumber.getText());
            int speed = Integer.parseInt(trainSpeed.getText());

            if (StationManagement.checkTrainCapacity(cap))
            {
                addTrainButton.setText("Invalid Capacity!");
                return;
            }

            businessClass = new BusinessClass(businessCap, businessFacility.getValue());
            economyClass = new EconomyClass(ecoCap, economyFacility.getValue());

            if(StationManagement.checkTrainSpeed(speed))
            {
                addTrainButton.setText("Invalid Speed!");
                return;
            }

            if (StationManagement.checkClassCapacity(businessCap, ecoCap,cap))
            {
                addTrainButton.setText("Invalid Class Capacity!");
                return;
            }
            if(StationManagement.checkTrainNumber(num))
            {
                addTrainButton.setText("Change Train Number");
                return;

            }

            StationManagement.addTrain(num, speed, cap, businessClass, economyClass);
            addTrainButton.setText("Added!");
        }catch (NumberFormatException e)
        {
            addTrainButton.setText("Invalid Input!");
        }

    }

    @FXML
    public void onAddRouteButton() {
        // Check if any fields are empty
        if (departStationName.getText().isEmpty() || arrivalStationName.getText().isEmpty() ||
                departAmPm.getValue()==null || departDay.getValue()==null||
                departHour.getText().isEmpty() || departMin.getText().isEmpty() ||
                departMonth.getValue()==null || departYear.getText().isEmpty() ||
                arrivalAmPm.getValue()==null || arrivalDay.getValue()==null ||
                arrivalHour.getText().isEmpty() || arrivalMin.getText().isEmpty() ||
                arrivalMonth.getValue()==null || arrivalYear.getText().isEmpty() || distanceBwStations.getText().isEmpty())
        {

            addRouteButton.setText("Empty Field!");
            return;
        }

        // Validate distance between stations
        if (!distanceBwStations.getText().isEmpty()) {
            try {
                Route.distanceBetweenStations = Integer.parseInt(distanceBwStations.getText());
            } catch (NumberFormatException e) {
                addRouteButton.setText("Invalid Distance!");
                return;
            }
        }

        // Validate station names contain only alphabets
        if (checkStringForInteger(departStationName.getText())) {
            departStationName.setPromptText("Alphabets Only!");
            return;
        }
        if (checkStringForInteger(arrivalStationName.getText())) {
            arrivalStationName.setPromptText("Alphabets Only!");
            return;
        }

        // Check if both stations exist
        if (!StationManagement.checkStation(departStationName.getText(), arrivalStationName.getText())) {
            addRouteButton.setText("Station Not Found!");
            return;
        }


        // Attempt to add the route
        try {
            Station departStation = StationManagement.getStationByName(StationManagement.getStations(), departStationName.getText());
            Station arriveStation = StationManagement.getStationByName(StationManagement.getStations(), arrivalStationName.getText());


            Integer depYear = Integer.valueOf(departYear.getText());
            Integer arriveYear = Integer.valueOf(arrivalYear.getText());
            Integer depHour = Integer.valueOf(departHour.getText());
            Integer depMin = Integer.valueOf(departMin.getText());
            Integer arriveMin = Integer.valueOf(arrivalMin.getText());
            Integer arriveHour = Integer.valueOf(arrivalHour.getText());

            if(depHour<=0 || depHour>12 || arriveHour<=0 || arriveHour>12 || arriveMin<=0 || arriveMin>60 || depMin<=0 || depMin>60)
            {
                addRouteButton.setText("Invalid Time Input!");
                return;
            }
            if (arriveYear!=depYear)
            {
                addRouteButton.setText("Invalid Year Input!");
                return;
            }

            Schedule schedule = new Schedule(departDay.getValue(), departMonth.getValue(), depYear,
                    arrivalDay.getValue(), arrivalMonth.getValue(), arriveYear,
                    depHour, depMin, arriveHour, arriveMin,
                    departAmPm.getValue(), arrivalAmPm.getValue());

            StationManagement.addRoute(departStation, arriveStation, schedule);

            addRouteButton.setText("Added!");
        } catch (NullPointerException e) {
            addRouteButton.setText("Invalid Station!");
        } catch (NumberFormatException e) {
            addRouteButton.setText("Invalid Input!");
        }
        catch (IllegalArgumentException e)
        {
            addRouteButton.setText("Invalid Input!");
        }
    }


    public void onAssignRouteButton()
    {
        Boolean trainFound=false;

        if(assignRouteText.getText().isEmpty())
        {
            assignRouteButton.setText("Empty Field!");
            return;
        }

        try {
            for (int i = 0; i < StationManagement.getTrains().size(); i++) {
                Integer num = Integer.valueOf(assignRouteText.getText());
                if (num.equals(StationManagement.getTrains().get(i).getTrainNUmber())) {
                    StationManagement.getTrains().get(i).setTrainRoute(StationManagement.getTrainRoute());
                    assignRouteButton.setText("Assigned!");
                    trainFound = true;
                }
            }
            if (!trainFound) {
                assignRouteButton.setText("Train Not Found!");
            }
        }catch (NumberFormatException e){
            assignRouteButton.setText("Invalid Input!");
        }
    }
    public void resetStationButton()
    {
        addStationButton.setText("Add Station");
    }
    public void resetTrainButton()
    {
        addTrainButton.setText("Add Train");
    }

    public void resetRouteButton()
    {
        addRouteButton.setText("Add Route");
    }
    public void resetAssignRouteButton()
    {
        assignRouteButton.setText("Assign Route");
    }
    public void onTrainRefreshButton()
    {
        trainNumbers.clear();

        for (int i = 0; i < StationManagement.getTrains().size(); i++) {
            String trainNumb = String.valueOf(StationManagement.getTrains().get(i).getTrainNUmber());
            trainNumbers.appendText("Train " + (i + 1) + " - " + trainNumb + "\n");
        }
    }
    public void onStationRefreshButton()
    {
        stationLists.clear();

        for (int i = 0; i < StationManagement.getStations().size(); i++)
        {
            stationLists.appendText("Station "+(i+1)+" -"+StationManagement.getStations().get(i).getStationName()+"\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        businessFacility.getItems().addAll(Facilities.values());
        economyFacility.getItems().addAll(Facilities.values());
        businessFacility.setValue(Facilities.NONE);
        economyFacility.setValue(Facilities.NONE);

        stationCity.getItems().addAll(Cities.values());

        departDay.getItems().addAll(Days.values());
        arrivalDay.getItems().addAll(Days.values());
        departMonth.getItems().addAll(Months.values());
        arrivalMonth.getItems().addAll(Months.values());
        departAmPm.getItems().add(Timing.PM);
        departAmPm.getItems().add(Timing.AM);
        arrivalAmPm.getItems().add(Timing.AM);
        arrivalAmPm.getItems().add(Timing.PM);

        trainNumbers.setEditable(false);
        stationLists.setEditable(false);
    }


    public void onHomeButton() throws IOException {

        Stage stage= (Stage) homeButton.getScene().getWindow();

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("selectionScreen.FXML"));

        Scene scene=new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.show();
    }
    public Boolean checkStringForInteger(String s)
    {
        s.toCharArray();

        for (int i = 0; i < s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
}
