package edu.icet.ecom.hibernateTransaction;


import javafx.collections.ObservableList;

public interface TransactionInterface {

     <T> void executeAdd( T dto );
     <T> void executeDelete( Class<T> type, String id );
     <T> void executeUpdate( T dto );
     <T> void executeDelete( Class<T> type, String id1, String id2);

     // get all table data
     <T> ObservableList<T> getTblData( Class<T> type );
}
