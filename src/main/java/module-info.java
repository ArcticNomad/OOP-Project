module com.example.trainmanagementproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trainmanagementproject to javafx.fxml;
    exports com.example.trainmanagementproject;
}