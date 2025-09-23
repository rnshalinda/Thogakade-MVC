package edu.icet.ecom.controller.orderDetailManagement;

import edu.icet.ecom.dbConnection.DbConnection;
import edu.icet.ecom.hibernateTransaction.TransactionImpl;
import edu.icet.ecom.hibernateTransaction.TransactionInterface;
import edu.icet.ecom.model.OrderDetailDto;
import edu.icet.ecom.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailManagementService implements OrderDetailManagementInterface{

    TransactionInterface transaction = new TransactionImpl();

    // Get order-detail table data from db
    @Override
    public ObservableList<OrderDetailDto> getTblData() {

        ObservableList<OrderDetailDto> list = transaction.getTblData( OrderDetailDto.class);
        return list;
    }

    // add order detail to db
    @Override
    public void addOrderDetailDto(OrderDetailDto orderDetailDto) {

        transaction.executeAdd(orderDetailDto);
    }


    // delete order-detail
    @Override
    public void deleteOrderDetail(String text, String text1) {

//        transaction.executeDelete();
    }

    // update order-detail
    @Override
    public void updateOrderDetailDto(OrderDetailDto orderDetailDto) {

        transaction.executeUpdate( orderDetailDto );
    }
}






// get order-detail table data from db
//    @Override
//    public ObservableList<OrderDetailDto> getTblData() {
//
//        ObservableList<OrderDetailDto> list = FXCollections.observableArrayList();
//
//        String sql = "SELECT * FROM orderdetail";
//
//        try(ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement(sql).executeQuery()){
//
//            while (rst.next()){
//                list.add(
//                        new OrderDetailDto(
//                                rst.getString("OrderID"),
//                                rst.getString("ItemCode"),
//                                rst.getInt("OrderQTY"),
//                                rst.getDouble("Discount")
//                                //rst.getDouble("Total")
//                        )
//                );
//            }
//
//        }catch (SQLException e){
////            throw new DbException("Failed to fetch order-detail data from db",e);
//            AlertUtil.showAlert(Alert.AlertType.ERROR, "Failed to fetch order-detail data from db\n"+e.getMessage() );
//
//        }
//
//        return list;
//    }





// add order detail to db
//    @Override
//    public void addOrderDetailDto(OrderDetailDto orderDetailDto) {
//
//        String sql = "INSERT INTO orderdetail (OrderID, ItemCode, OrderQTY, Discount) VALUES (?, ?, ?, ?);";
//
//        try {
//            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement(sql);
//
//            stm.setObject(1, orderDetailDto.getOrderID());
//            stm.setObject(2, orderDetailDto.getItemCode());
//            stm.setObject(3, orderDetailDto.getOrderQTY());
//            stm.setObject(4, orderDetailDto.getDiscount());
//
//            stm.executeUpdate();
//
//            AlertUtil.showAlert(Alert.AlertType.CONFIRMATION, "Order-detail added Successfully");
//
//        } catch (SQLException e) {
////            throw new RuntimeException(e);
//            AlertUtil.showAlert(Alert.AlertType.ERROR, "DB error! Could not add Order-detail");
//
//        }
//    }