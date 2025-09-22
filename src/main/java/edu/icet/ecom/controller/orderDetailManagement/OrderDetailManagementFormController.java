package edu.icet.ecom.controller.orderDetailManagement;

import edu.icet.ecom.model.ItemDto;
import edu.icet.ecom.model.OrderDetailDto;
import edu.icet.ecom.util.AlertUtil;
import edu.icet.ecom.util.WindowSwitchUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetailManagementFormController implements Initializable {

    @FXML
    private TableView<OrderDetailDto> orderDetailTable;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colOrderQTY;

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
    private Label lblTotal;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderQTY;


    OrderDetailManagementInterface service = new OrderDetailManagementService();
    ObservableList<OrderDetailDto> data = FXCollections.observableArrayList();


    @FXML
    void btnAddAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.addOrderDetailDto(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        if(nullFieldCheck()){
            service.updateOrderDetailDto(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        if(!txtOrderId.getText().isBlank() && !txtItemCode.getText().isBlank()){
            service.deleteOrderDetail(txtOrderId.getText(), txtItemCode.getText());
        }
        else AlertUtil.showAlert(Alert.AlertType.WARNING, "Order-ID & Item-Code fields cannot be empty");

    }

    @FXML
    void btnClearAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnBackAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event,"/view/dashboard.fxml");
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        System.exit(0);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTbl();
        tblRowSelector();
    }


    // populate table
    private void loadTbl(){

        data = service.getTblData();

        if(!data.isEmpty()){

            colOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colOrderQTY.setCellValueFactory(new PropertyValueFactory<>("orderQTY"));
            colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));

            orderDetailTable.setItems(data);
        }
    }

    // Get selected table row
    private void tblRowSelector() {

        orderDetailTable.getSelectionModel().selectedItemProperty().addListener((observableValue, prevSelect, newSelect) -> {
            if(newSelect != null) {
                txtOrderId.setText(newSelect.getOrderID());
                txtItemCode.setText(newSelect.getItemCode());
                txtOrderQTY.setText(String.valueOf(newSelect.getOrderQTY()));
                txtDiscount.setText(String.valueOf(newSelect.getDiscount()));
            }
        } );
    }


    // check for null input
    private boolean nullFieldCheck(){
        return ( txtOrderId.getText().isBlank() || txtItemCode.getText().isBlank() || txtOrderQTY.getText().isBlank() || txtDiscount.getText().isBlank() ) ? false : true;
    }

    // OrderDetail DTO
    private OrderDetailDto createDto(){
        return new OrderDetailDto(
                txtOrderId.getText(),
                txtItemCode.getText(),
                Integer.parseInt(txtOrderQTY.getText()),
                Double.parseDouble(txtDiscount.getText())
        );
    }

    // clear all input fields
    private void clearFields(){
        txtOrderId.clear();
        txtItemCode.clear();
        txtOrderQTY.clear();
        txtDiscount.clear();
    }
}
