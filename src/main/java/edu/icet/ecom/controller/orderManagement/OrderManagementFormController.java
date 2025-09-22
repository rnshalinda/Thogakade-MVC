package edu.icet.ecom.controller.orderManagement;

import edu.icet.ecom.model.OrderDetailDto;
import edu.icet.ecom.model.OrdersDto;
import edu.icet.ecom.util.AlertUtil;
import edu.icet.ecom.util.WindowSwitchUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class OrderManagementFormController implements Initializable {

    @FXML
    private TableView<OrdersDto> ordersTable;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnUpdate;

    @FXML
    private DatePicker dateOrderDate;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtOrderId;


    OrderManagementInterface service = new OrderManagementService();
    ObservableList<OrdersDto> data = FXCollections.observableArrayList();


    @FXML
    void btnAddAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.addOrdersDto(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.updateOrdersDto(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        if(!txtOrderId.getText().isBlank()){
            service.deleteOrder(txtOrderId.getText());
        }
        else AlertUtil.showAlert(Alert.AlertType.WARNING, "Order-ID field cannot be empty");

    }

    @FXML
    void btnClearAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnBackAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/dashboard.fxml");
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        System.exit(0);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTbl();
        tblRowSelector();
        datePickerConverter();   // change default date format
    }


    // populate table
    private void loadTbl(){

        data = service.getTblData();

        if(!data.isEmpty()){

            colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            colOrderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
            colCustID.setCellValueFactory(new PropertyValueFactory<>("CustID"));

            ordersTable.setItems(data);
        }
    }

    // Get selected table row
    private void tblRowSelector() {

        ordersTable.getSelectionModel().selectedItemProperty().addListener((observableValue, prevSelect, newSelect) -> {
            if(newSelect != null) {
                txtOrderId.setText(newSelect.getOrderID());
                txtCustId.setText(newSelect.getCustID());
                dateOrderDate.setValue(newSelect.getOrderDate());
            }
        } );
    }


    // convert data format from "M/d/yyyy" to "yyyy/M/d"
    private void datePickerConverter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");

        dateOrderDate.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                return (date != null) ? formatter.format(date) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string != null && !string.isEmpty())
                        ? LocalDate.parse(string, formatter)
                        : null;
            }
        });
    }


    // clear all input fields
    private void clearFields(){
        txtOrderId.clear();
        dateOrderDate.setValue(LocalDate.now());
        txtCustId.clear();
    }

    // check for null input
    private boolean nullFieldCheck(){
        return ( txtOrderId.getText().isBlank() || dateOrderDate.getValue().toString().isBlank() || txtCustId.getText().isBlank() ) ? false : true;
    }

    // Order DTO
    private OrdersDto createDto(){
        return new OrdersDto(
                txtOrderId.getText(),
                dateOrderDate.getValue(),
                txtCustId.getText()
        );
    }


}
