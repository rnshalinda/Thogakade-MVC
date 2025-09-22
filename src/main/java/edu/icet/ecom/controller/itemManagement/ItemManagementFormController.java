package edu.icet.ecom.controller.itemManagement;

import edu.icet.ecom.model.CustomerDto;
import edu.icet.ecom.model.ItemDto;
import edu.icet.ecom.util.AlertUtil;
import edu.icet.ecom.util.CommonStringFuncUtil;
import edu.icet.ecom.util.WindowSwitchUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ItemManagementFormController implements Initializable {


    @FXML
    private TableView<ItemDto> itemTable;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

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
    private ComboBox<String> comboUnit;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;


    ItemManagementInterface service = new ItemManagementService();
    ObservableList<ItemDto> data = FXCollections.observableArrayList();


    @FXML
    void btnAddAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.addItem(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.updateItem(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        if(!txtItemId.getText().isBlank()){
            service.deleteItem(txtItemId.getText());
        }
        else AlertUtil.showAlert(Alert.AlertType.WARNING, "Item-ID field cannot be empty");
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
        setUnitTypes();
    }

    private void loadTbl(){
        this.data = service.getTblData();

        if (!data.isEmpty()) {

            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

            itemTable.setItems(data);
        }
    }

    private void tblRowSelector(){

        itemTable.getSelectionModel().selectedItemProperty().addListener((observableValue, prevSelect, newSelect) -> {

            if(newSelect != null){
                txtItemId.setText(newSelect.getItemCode());
                txtDescription.setText(newSelect.getDescription());
                txtUnitPrice.setText(String.valueOf(newSelect.getUnitPrice()));
                txtQty.setText(String.valueOf(newSelect.getQtyOnHand()));


                txtPackSize.setText(CommonStringFuncUtil.extractDecimal(newSelect.getPackSize()));

                comboUnit.setValue(CommonStringFuncUtil.extractLetters(newSelect.getPackSize()));


            }
        });
    }

    // set combo values for unit
    private void setUnitTypes(){
        comboUnit.setItems(FXCollections.observableArrayList("g","kg","ml","L"));
    }

    // clear all input fields
    private void clearFields(){
        txtItemId.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtUnitPrice.clear();
        comboUnit.setValue(null);
        txtQty.clear();
    }


    // check for null input
    private boolean nullFieldCheck(){
        return ( txtItemId.getText().isBlank() || txtDescription.getText().isBlank() || txtPackSize.getText().isBlank() || txtUnitPrice.getText().isBlank() || txtQty.getText().isBlank() ) ? false : true;
    }

    // Item DTO
    private ItemDto createDto(){
        return new ItemDto(
                txtItemId.getText(),
                txtDescription.getText(),
                txtPackSize.getText()+comboUnit.getValue(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQty.getText())
        );
    }
}
