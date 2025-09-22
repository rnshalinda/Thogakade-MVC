package edu.icet.ecom.hibernateTransaction;

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

}
