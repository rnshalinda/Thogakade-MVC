package edu.icet.ecom.controller.orderDetailManagement;

import edu.icet.ecom.model.OrderDetailDto;
import javafx.collections.ObservableList;

public interface OrderDetailManagementInterface {

    ObservableList<OrderDetailDto> getTblData();

    void addOrderDetailDto(OrderDetailDto orderDetailDto);

    void deleteOrderDetail(String orderId, String itemId);

    void updateOrderDetailDto(OrderDetailDto orderDetailDto);
}
