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



    @Override
    public <T> ObservableList<T> getTblData( Class<T> type ) {

        ObservableList<T> list = FXCollections.observableArrayList();

        initializeSession();
        list.addAll( session.createQuery( "FROM "+type.getSimpleName(), type ).getResultList() );      // here eg: "FROM "+type.getSimpleName() => FROM ItemDto
        commitAndCloseSession();

        return list;
    }



    @Override
    public <T> void executeAdd( T dto) {

        initializeSession();
        session.persist( dto );
        commitAndCloseSession();
    }

    @Override
    public <T> void executeDelete(Class<T> type, String id) {

        initializeSession();
        session.remove(session.find( type, id ));
        commitAndCloseSession();
    }

    @Override
    public <T> void executeUpdate( T dto) {

        initializeSession();
        session.merge( dto );
        commitAndCloseSession();
    }


    @Override
    public <T> void executeDelete(Class<T> type, String id1, String id2) {

        initializeSession();
//        session.remove( session.find( type, id1, id2));
    }

}
