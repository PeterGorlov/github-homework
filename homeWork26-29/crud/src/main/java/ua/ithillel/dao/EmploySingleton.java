package ua.ithillel.dao;

public class EmploySingleton {
    private static EmploySingleton instance;
    private final EmployeeDao employeeDao = new EmployeeDatabaseDao();
//    private final EmployeeDao employeeDao = new EmployeeSimpleDao();

    public static synchronized EmploySingleton getInstance() {
        if (instance == null) {
            instance = new EmploySingleton();
        }
        return instance;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
