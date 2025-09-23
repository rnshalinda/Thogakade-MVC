package edu.icet.ecom.controller.dashboard;

import edu.icet.ecom.util.ExitUtil;
import edu.icet.ecom.util.WindowSwitchUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class DashboardController {


    @FXML
    void btnCustomerMngAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/customerManagement.fxml");
    }


    @FXML
    void btnItemMngAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/itemManagement.fxml");
    }


    @FXML
    void btnOrderMngAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/orderManagement.fxml");
    }

    @FXML
    void btnEditOrderAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/orderDetailManagement.fxml");
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        ExitUtil.exit();
    }


}
