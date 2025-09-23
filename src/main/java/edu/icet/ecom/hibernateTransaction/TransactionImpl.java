package edu.icet.ecom.hibernateTransaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TransactionImpl implements TransactionInterface {

    Session session;
    Transaction transaction;

    public void initializeSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void commitAndCloseSession() {

        transaction.commit();
        session.close();
        HibernateUtil.closeFactory();
    }


    // fetch table data
    @Override
    public <T> ObservableList<T> getTblData( Class<T> type ) {

        ObservableList<T> list = FXCollections.observableArrayList();

        initializeSession();
        list.addAll( session.createQuery( "FROM "+type.getSimpleName(), type ).getResultList() );      // here eg: "FROM "+type.getSimpleName() => "FROM ItemDto"
        commitAndCloseSession();

        return list;
    }


    // add table record
    @Override
    public <T> void executeAdd( T dto) {

        initializeSession();
        session.persist( dto );
        commitAndCloseSession();
    }


    // update table record
    @Override
    public <T> void executeUpdate( T dto) {

        initializeSession();
        session.merge( dto );
        commitAndCloseSession();
    }


    // delete table record (single primary key)
    @Override
    public <T> void executeDelete(Class<T> type, String id) {

        initializeSession();
        session.remove(session.find( type, id ));
        commitAndCloseSession();
    }


    // delete table record (composite primary key)
    @Override
    public <T> void executeDelete(Class<T> type, Object compositeKey) {

        initializeSession();
        session.remove( session.find( type, compositeKey));
        commitAndCloseSession();
    }

}
