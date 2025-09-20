package edu.icet.ecom.controller.customerManagement;


import edu.icet.ecom.model.CustomerDto;
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

public class CustomerManagementFormController implements Initializable {

    @FXML
    private TableView<CustomerDto> customerTable;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustAddress;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustTitle;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colSalary;

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
    private ComboBox<String> comboProvince;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private RadioButton radioMiss;

    @FXML
    private RadioButton radioMr;

    @FXML
    private ToggleGroup titleToggleGroup;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostal;

    @FXML
    private TextField txtSalary;


    CustomerManagementInterface service = new CustomerManagementService();
    ObservableList<CustomerDto> data = FXCollections.observableArrayList();



    @FXML
    void btnAddAction(ActionEvent event) {

        if(nullFieldCheck()){
            service.addCustomer(createDto());
            loadTbl();
        }
        else {
            AlertUtil.showAlert(Alert.AlertType.WARNING, "Fields cannot be empty");
        }
    }


    @FXML
    void btnUpdateAction(ActionEvent event) {
        //
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        //
    }

    @FXML
    void btnClearAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void    btnBackAction(ActionEvent event) {
        WindowSwitchUtil.setWindow(event, "/view/dashboard.fxml");
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        System.exit(0);
    }


    private void loadTbl(){
        data = service.getTblData();
        if(!data.isEmpty()){

            colCustID.setCellValueFactory(new PropertyValueFactory<>("custID"));
            colCustTitle.setCellValueFactory(new PropertyValueFactory<>("custTitle"));
            colCustName.setCellValueFactory(new PropertyValueFactory<>("custName"));
            colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
            colCustAddress.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

            customerTable.setItems(data);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTbl();
        tblRowSelector();
        setProvinces();
        datePickerConverter();      // Define formatter for output
    }


    // select table row
    private void tblRowSelector(){
        customerTable.getSelectionModel().selectedItemProperty().addListener((observableValue, prevSelect, newSelect) -> {

            if(newSelect != null){
                txtCustId.setText(newSelect.getCustID());
                txtName.setText(newSelect.getCustName());
                dateDOB.setValue(newSelect.getDob());
                txtSalary.setText(String.valueOf(newSelect.getSalary()));
                txtAddress.setText(newSelect.getCustAddress());
                txtCity.setText(newSelect.getCity());
                txtPostal.setText(newSelect.getPostalCode());

                titleToggleGroup.selectToggle( newSelect.getCustTitle().equalsIgnoreCase(radioMr.getText()) ? radioMr : radioMiss );

                comboProvince.setValue(newSelect.getProvince());
            }
        });
    }


    // set provinces combo
    private void setProvinces(){
        comboProvince.setItems(FXCollections.observableArrayList("Central", "Eastern", "North Central", "Northern", "North Western", "Sabaragamuwa", "Southern", "Uva", "Wayamba", "Western").sorted());
    }



    // convert data format from "M/d/yyyy" to "yyyy/M/d"
    private void datePickerConverter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");

        dateDOB.setConverter(new StringConverter<LocalDate>() {
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
        txtCustId.clear();
        titleToggleGroup.selectToggle(null);
        txtName.clear();
        dateDOB.setValue(LocalDate.now());
        txtSalary.clear();
        txtAddress.clear();
        comboProvince.setValue(null);
        txtPostal.clear();

    }

    // check for null input
    private boolean nullFieldCheck(){
        return ( txtCustId.getText().isBlank() || titleToggleGroup.getSelectedToggle() == null || txtName.getText().isBlank() || dateDOB.getValue().toString().isBlank() || txtSalary.getText().isBlank() || txtAddress.getText().isBlank() || txtCity.getText().isBlank() || comboProvince.getValue().isBlank() || txtPostal.getText().isBlank() ) ? false : true;
    }

    // customer DTO
    private CustomerDto createDto(){

        return new CustomerDto(
                txtCustId.getText(),

                ((RadioButton)titleToggleGroup.getSelectedToggle()).getText(),

                txtName.getText(),
                dateDOB.getValue(),
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                comboProvince.getValue(),
                txtPostal.getText()
        );
    }

}
