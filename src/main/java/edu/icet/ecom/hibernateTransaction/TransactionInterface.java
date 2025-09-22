package edu.icet.ecom.hibernateTransaction;


public interface TransactionInterface {

    public <T> void executeAdd( T dto );
    public <T> void executeDelete( Class<T> type, String id );
    public <T> void executeUpdate( T dto );
}
