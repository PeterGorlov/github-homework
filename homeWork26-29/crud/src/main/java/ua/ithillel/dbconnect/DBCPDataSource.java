package ua.ithillel.dbconnect;

import org.apache.commons.dbcp2.BasicDataSource;
import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl(AppConfig.getProperty("db.url"));
        ds.setUsername(AppConfig.getProperty("db.user"));
        ds.setPassword(AppConfig.getProperty("db.password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("Pull connection");
        return ds.getConnection();
    }

    private DBCPDataSource(){ }
}
