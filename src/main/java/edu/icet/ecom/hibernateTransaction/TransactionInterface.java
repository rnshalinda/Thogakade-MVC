package edu.icet.ecom.hibernateTransaction;


import javafx.collections.ObservableList;

public interface TransactionInterface {

     <T> void executeAdd( T dto );
     <T> void executeUpdate( T dto );

     <T> void executeDelete( Class<T> type, String id );              // for single primary key
     <T> void executeDelete( Class<T> type, Object compositeKey);     // for composite primary key

     // get all table data
     <T> ObservableList<T> getTblData( Class<T> type );
}
