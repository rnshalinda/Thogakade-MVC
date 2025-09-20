package edu.icet.ecom.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class WindowSwitchUtil {


    public static void setWindow(ActionEvent eve, String path) {
        Stage stage = (Stage) ((Node) eve.getSource()).getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(WindowSwitchUtil.class.getResource(path))));
            stage.show();
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
