package ua.ithillel.util;

import ua.ithillel.dbconnect.DbConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class AppConstant {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SALARY = "salary";
    public static final String CHIEF_ID = "chief_id";
    public static final String DEPARTMENT_ID = "department_id";
    public static Connection CON;

    static {
        try {
            CON = DbConnectionFactory.build().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private AppConstant() {
    }
}
