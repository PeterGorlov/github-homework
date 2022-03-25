package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Long addEmployee(Employee employee) throws DaoException;

    void updateEmployee(Employee employee) throws DaoException;

    void deleteEmployee(Long id) throws DaoException;

    Employee getEmployee(Long id) throws DaoException;

    List<Employee> findEmployees() throws DaoException;
}
