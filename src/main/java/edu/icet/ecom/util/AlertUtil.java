package edu.icet.ecom.util;

import javafx.scene.control.Alert;

public class AlertUtil {

    public static void showAlert(Alert.AlertType alertType, String msg){
        Alert alert = new Alert(alertType);
        alert.setTitle("Alert");
        alert.setContentText(msg);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
