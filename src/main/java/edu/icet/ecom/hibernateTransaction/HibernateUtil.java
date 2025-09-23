package edu.icet.ecom.hibernateTransaction;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory factory = null;

    private static SessionFactory buildSessionFactory() {

        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(edu.icet.ecom.model.CustomerDto.class)
                .addAnnotatedClass(edu.icet.ecom.model.ItemDto.class)
                .addAnnotatedClass(edu.icet.ecom.model.OrderDetailDto.class)
                .addAnnotatedClass(edu.icet.ecom.model.OrdersDto.class)
                .buildSessionFactory();

    }


    // 'synchronized' is used to make it thread-safe
    // To avoid, If two threads call getSessionFactory() at the same time
    public static synchronized SessionFactory getSessionFactory(){

        if (factory == null) {
            factory = buildSessionFactory();
        }
        return factory;
    }

    public static void closeFactory() {
        getSessionFactory().close();
    }
}
