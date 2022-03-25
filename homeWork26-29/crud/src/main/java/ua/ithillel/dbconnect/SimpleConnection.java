package ua.ithillel.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

public class SimpleConnection implements DbConnection{
    @Override
    public Connection getConnection() throws SQLException {
        return DatabaseConnectionSingleton.getInstance().getConnection();
    }
}
