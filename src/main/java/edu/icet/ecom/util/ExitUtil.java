package edu.icet.ecom.util;

import edu.icet.ecom.hibernateTransaction.HibernateUtil;

// Centralized exit and close hibernate Session-factory
public class ExitUtil {

    public static void exit(){
        if( HibernateUtil.getSessionFactory() != null){
            HibernateUtil.closeFactory();
        }

        System.exit(0);
    }
}
