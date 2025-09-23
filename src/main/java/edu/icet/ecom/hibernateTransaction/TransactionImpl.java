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

    private void commitSession() {

        transaction.commit();
        session.close();

//        HibernateUtil.closeFactory();
//        should not close the SessionFactory per method consumes resources — only closed at app shutdown
//
//        SessionFactory → heavy object, meant to be created once per app
//          It keeps the database connections, caches, and metadata about entities.
//
//        Hibernate itself recommends treating it as a singleton.
//
//        Session → lightweight, short-lived.
//          You open a session for a transaction or request, use it, then close it.
//          can create thousands of sessions from one SessionFactory.

    }


    // fetch table data
    @Override
    public <T> ObservableList<T> getTblData( Class<T> type ) {

        ObservableList<T> list = FXCollections.observableArrayList();

        initializeSession();
        list.addAll( session.createQuery( "FROM "+type.getSimpleName(), type ).getResultList() );      // here eg: "FROM "+type.getSimpleName() => "FROM ItemDto"
        commitSession();

        return list;
    }


    // add table record
    @Override
    public <T> void executeAdd( T dto) {

        initializeSession();
        session.persist( dto );
        commitSession();
    }


    // update table record
    @Override
    public <T> void executeUpdate( T dto) {

        initializeSession();
        session.merge( dto );
        commitSession();
    }


    // delete table record (single primary key)
    @Override
    public <T> void executeDelete(Class<T> type, String id) {

        initializeSession();
        session.remove(session.find( type, id ));
        commitSession();
    }


    // delete table record (composite primary key)
    @Override
    public <T> void executeDelete(Class<T> type, Object compositeKey) {

        initializeSession();
        session.remove( session.find( type, compositeKey));
        commitSession();
    }

}
