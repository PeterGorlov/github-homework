package ua.ithillel.dao;

public class DepartmentSingleton {
    private static DepartmentSingleton instance;
    private final DepartmentDao departmentDao = new DepartmentDatabaseDao();
//    private final DepartmentDao departmentDao = new DepartmentSimpleDao();

    public static synchronized DepartmentSingleton getInstance() {
        if (instance == null) {
            instance = new DepartmentSingleton();
        }
        return instance;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }
}
