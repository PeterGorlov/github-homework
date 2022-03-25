package ua.ithillel.service;

import ua.ithillel.dao.EmploySingleton;
import ua.ithillel.dao.EmployeeDao;
import ua.ithillel.dao.EmployeeSimpleDao;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {

    private final EmployeeDao employeeDao = EmploySingleton.getInstance().getEmployeeDao();
    private final RandomHttpService randomHttpService = new RandomHttpService();

    public Long add(Employee employee) throws BusinessException {
            //to do
//        int salary = randomHttpService.getNumber(1000, 10000);
//        employee.setSalary(salary);
        Long id = null;
        try {
            id = employeeDao.addEmployee(employee);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
        return id;
    }

    public void update(Employee employee) throws BusinessException {
        try {
            employeeDao.updateEmployee(employee);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) throws BusinessException {
        try {
            employeeDao.deleteEmployee(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public Employee get(Long id) throws BusinessException {
        try {
            return employeeDao.getEmployee(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public List<Employee> findAll() throws BusinessException {

        try {
            return employeeDao.findEmployees();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }
}
