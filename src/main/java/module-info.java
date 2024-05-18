module com.example.trainmanagementproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trainManagementProject to javafx.fxml;
    exports com.example.trainManagementProject;
}