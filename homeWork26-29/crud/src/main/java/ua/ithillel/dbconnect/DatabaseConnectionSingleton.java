package ua.ithillel.dbconnect;

import ua.ithillel.util.AppConfig;

import java.sql.*;

public class DatabaseConnectionSingleton {

    private static DatabaseConnectionSingleton instance;
    private Connection connection;


    public static synchronized DatabaseConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Connection con = DriverManager.getConnection(
                        AppConfig.getProperty("db.url"),
                        AppConfig.getProperty("db.user"),
                        AppConfig.getProperty("db.password"));

                System.out.println("Connection got");
                System.out.println("Simple connection");
                connection = con;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
