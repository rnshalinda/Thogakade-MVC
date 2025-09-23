package edu.icet.ecom.controller.orderManagement;

import edu.icet.ecom.dbConnection.DbConnection;
import edu.icet.ecom.exception.DbException;
import edu.icet.ecom.hibernateTransaction.TransactionImpl;
import edu.icet.ecom.hibernateTransaction.TransactionInterface;
import edu.icet.ecom.model.OrderDetailDto;
import edu.icet.ecom.model.OrdersDto;
import edu.icet.ecom.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderManagementService implements OrderManagementInterface{

    TransactionInterface transaction = new TransactionImpl();

    // get order table data from db
    @Override
    public ObservableList<OrdersDto> getTblData() {

        ObservableList<OrdersDto> list = transaction.getTblData( OrdersDto.class);

        return list;
    }

    // add order
    @Override
    public void addOrdersDto(OrdersDto ordersDto) {

        transaction.executeAdd( ordersDto );
    }

    // delete order
    @Override
    public void deleteOrder(String orderId) {

        transaction.executeDelete( OrdersDto.class, orderId );
    }

    // update order
    @Override
    public void updateOrdersDto(OrdersDto ordersDto) {

        transaction.executeUpdate( ordersDto );
    }


}




// get order table data from db
//@Override
//public ObservableList<OrdersDto> getTblData() {
//
//    ObservableList<OrdersDto> list = FXCollections.observableArrayList();
//
//    String sql = "SELECT * FROM orders";
//
//    try(ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement(sql).executeQuery()){
//
//        while (rst.next()){
//            list.add(
//                    new OrdersDto(
//                            rst.getString("OrderID"),
//                            LocalDate.parse( rst.getString("OrderDate") ),
//                            rst.getString("CustID")
//                    )
//            );
//        }
//
//    }catch (SQLException e){
////            throw new DbException("Failed to fetch orders from db",e);
//        AlertUtil.showAlert(Alert.AlertType.ERROR, "Failed to fetch order data from db\n"+e.getMessage() );
//
//    }
//    return list;
//}





//@Override
//public void addOrdersDto(OrdersDto ordersDto) {
//
////        String sql = "INSERT INTO orders (OrderID, OrderDate, CustID) VALUES (?, ?, ?);";
////
////        try {
////            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement(sql);
////
////            stm.setObject(1, ordersDto.getOrderID());
////            stm.setObject(2, ordersDto.getOrderDate());
////            stm.setObject(3, ordersDto.getCustID());
////
////            stm.executeUpdate();
////
////            AlertUtil.showAlert(Alert.AlertType.CONFIRMATION, "Order added Successfully");
////
////        } catch (SQLException e) {
//////            throw new RuntimeException(e);
////            AlertUtil.showAlert(Alert.AlertType.ERROR, "DB error! Could not add Order");
////
////        }
//}