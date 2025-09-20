package edu.icet.ecom.dbConnection;

import edu.icet.ecom.exception.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection db;
    private Connection connection;

    private DbConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_mvc", "root","1234");
    }

    public static DbConnection getInstance() throws SQLException {
        if(db == null){
            db = new DbConnection();
        }
        return db;
    }

    public Connection getConnection(){
        return connection;
    }

}
