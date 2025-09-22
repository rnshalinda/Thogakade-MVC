package edu.icet.ecom.hibernateTransaction;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory factory;

    private static SessionFactory buildSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(edu.icet.ecom.model.CustomerDto.class)
                    .addAnnotatedClass(edu.icet.ecom.model.ItemDto.class)
                    .addAnnotatedClass(edu.icet.ecom.model.OrderDetailDto.class)
                    .addAnnotatedClass(edu.icet.ecom.model.OrdersDto.class)
                    .buildSessionFactory();
        }
        return factory;
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    public static void closeFactory() {
        getSessionFactory().close();
        factory = null;
    }
}
