package edu.icet.ecom.controller.customerManagement;

import edu.icet.ecom.dbConnection.DbConnection;
import edu.icet.ecom.hibernateTransaction.TransactionImpl;
import edu.icet.ecom.hibernateTransaction.TransactionInterface;
import edu.icet.ecom.model.CustomerDto;
import edu.icet.ecom.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class CustomerManagementService implements CustomerManagementInterface {

    TransactionInterface transaction = new TransactionImpl();

    // get table data from db
    @Override
    public ObservableList<CustomerDto> getTblData() {

        ObservableList<CustomerDto> list = transaction.getTblData( CustomerDto.class);
        return list;
    }

    // Add new customer to db
    @Override
    public void addCustomer(CustomerDto custDto) {

        transaction.executeAdd(custDto);
    }


    // delete customer
    @Override
    public void deleteCustomer( String id ) {

        transaction.executeDelete( CustomerDto.class, id );
    }

    //  update customer
    @Override
    public void updateCustomer( CustomerDto custDto ) {

        transaction.executeUpdate( custDto );
    }

}





// get table data from db
//   @Override
//    public ObservableList<CustomerDto> getTblData() {
//
//        ObservableList<CustomerDto> list = FXCollections.observableArrayList();
//
//        String sql = "SELECT * FROM customer;";
//
//        try (ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement(sql).executeQuery()) {
//
//            while (rst.next()) {
//                list.add(
//                        new CustomerDto(
//                                rst.getString("CustID"),
//                                rst.getString("CustTitle"),
//                                rst.getString("CustName"),
//                                LocalDate.parse(rst.getString("Dob")),
//                                rst.getDouble("salary"),
//                                rst.getString("CustAddress"),
//                                rst.getString("City"),
//                                rst.getString("Province"),
//                                rst.getString("PostalCode")
//                        )
//                );
//            }
//
//        } catch (SQLException e) {
////            throw new DbException("Failed to fetch customer data from db", e);
//            AlertUtil.showAlert(Alert.AlertType.ERROR, "Failed to fetch customer data from db\n"+e.getMessage() );
//        }
//
//        return list;
//    }



// Add new customer to db
//    @Override
//    public void addCustomer(CustomerDto custDto) {
//
//        String sql = "INSERT INTO customer (CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
//
//        try {
//            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement(sql);
//
//            stm.setObject(1, custDto.getCustID());
//            stm.setObject(2, custDto.getCustTitle());
//            stm.setObject(3, custDto.getCustName());
//            stm.setObject(4, custDto.getDob());
//            stm.setObject(5, custDto.getSalary());
//            stm.setObject(6, custDto.getCustAddress());
//            stm.setObject(7, custDto.getCity());
//            stm.setObject(8, custDto.getProvince());
//            stm.setObject(9, custDto.getPostalCode());
//
//            stm.executeUpdate();
//
//            AlertUtil.showAlert(Alert.AlertType.CONFIRMATION, "Customer added Successfully");
//
//        } catch (SQLException e) {
////            throw new RuntimeException(e);
//            AlertUtil.showAlert(Alert.AlertType.ERROR, "DB error! Could not add Customer");
//
//        }
//    }