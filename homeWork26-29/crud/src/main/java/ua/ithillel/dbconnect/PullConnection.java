package ua.ithillel.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

public class PullConnection implements DbConnection {
    @Override
    public Connection getConnection() throws SQLException {
        return DBCPDataSource.getConnection();
    }
}
