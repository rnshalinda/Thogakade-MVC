package edu.icet.ecom.controller.orderManagement;

import edu.icet.ecom.model.OrdersDto;
import javafx.collections.ObservableList;

public interface OrderManagementInterface {

    ObservableList<OrdersDto> getTblData();

    void addOrdersDto(OrdersDto ordersDto);

    void deleteOrder(String orderId);

    void updateOrdersDto(OrdersDto ordersDto);
}
