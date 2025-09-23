package edu.icet.ecom.controller.itemManagement;

import edu.icet.ecom.dbConnection.DbConnection;
import edu.icet.ecom.hibernateTransaction.TransactionImpl;
import edu.icet.ecom.hibernateTransaction.TransactionInterface;
import edu.icet.ecom.model.ItemDto;
import edu.icet.ecom.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemManagementService implements  ItemManagementInterface{

    TransactionInterface transaction = new TransactionImpl();


    // get item table data from db
    @Override
    public ObservableList<ItemDto> getTblData() {

        ObservableList<ItemDto> list = transaction.getTblData( ItemDto.class );

        return list;
    }

    // Add item to db
    @Override
    public void addItem(ItemDto itemDto) {

        transaction.executeAdd(itemDto);
    }



    // delete item
    @Override
    public void deleteItem(String itemId) {

        transaction.executeDelete( ItemDto.class, itemId);
    }

    // update item
    @Override
    public void updateItem(ItemDto itemDto) {

        transaction.executeUpdate( itemDto);
    }
}





// get item table data from db
//@Override
//public ObservableList<ItemDto> getTblData() {
//
//    ObservableList<ItemDto> list = FXCollections.observableArrayList();
//    String sql = "SELECT * FROM item;";
//
//    try(ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement(sql).executeQuery()){
//
//        while (rst.next()){
//
//            list.add(
//                    new ItemDto(
//                            rst.getString("ItemCode"),
//                            rst.getString("Description"),
//                            rst.getString("PackSize"),
//                            rst.getDouble("UnitPrice"),
//                            rst.getInt("QtyOnHand")
//                    )
//            );
//        }
//
//    }
//    catch (SQLException e){
////            throw new DbException("Failed to fetch item data from db", e);
//        AlertUtil.showAlert(Alert.AlertType.ERROR, "Failed to fetch item data from db\n"+e.getMessage() );
//
//    }
//
//    return list;
//}



// Add item to db
//    @Override
//    public void addItem(ItemDto itemDto) {

//        String sql = "INSERT INTO item (ItemCode, Description, PackSize, UnitPrice, QtyOnHand) VALUES (?, ?, ?, ?, ?);";
//
//        try {
//            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement(sql);
//
//            stm.setObject(1, itemDto.getItemCode());
//            stm.setObject(2, itemDto.getDescription());
//            stm.setObject(3, itemDto.getPackSize());
//            stm.setObject(4, itemDto.getUnitPrice());
//            stm.setObject(5, itemDto.getQtyOnHand());
//
//
//            stm.executeUpdate();
//
//            AlertUtil.showAlert(Alert.AlertType.CONFIRMATION, "Item added Successfully");
//
//        } catch (SQLException e) {
////            throw new RuntimeException(e);
//            AlertUtil.showAlert(Alert.AlertType.ERROR, "DB error! Could not add Item");
//
//        }
//    }