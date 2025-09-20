package edu.icet.ecom.controller.orderDetailManagement;

import edu.icet.ecom.model.OrderDetailDto;
import javafx.collections.ObservableList;

public interface OrderDetailManagementInterface {

    ObservableList<OrderDetailDto> getTblData();

    void addOrderDetailDto(OrderDetailDto orderDetailDto);
}
