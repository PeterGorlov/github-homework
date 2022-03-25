package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;

import java.util.List;

public interface DepartmentDao {
    void addDepartment(Department employee) throws DaoException;

    void updateDepartment(Department employee) throws DaoException;

    void deleteDepartment(Long id) throws DaoException;

    Department getDepartment(Long id) throws DaoException;

    List<Department> findDepartment() throws DaoException;

}
