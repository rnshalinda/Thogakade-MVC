package edu.icet.ecom.controller.customerManagement;

import edu.icet.ecom.model.CustomerDto;
import javafx.collections.ObservableList;


public interface CustomerManagementInterface {

    ObservableList<CustomerDto> getTblData();
    void addCustomer(CustomerDto custDto);

}
