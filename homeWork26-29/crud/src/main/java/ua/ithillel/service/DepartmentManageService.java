package ua.ithillel.service;

import ua.ithillel.dao.*;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;


import java.util.List;

public class DepartmentManageService {
    private final DepartmentDao departmentDao = DepartmentSingleton.getInstance().getDepartmentDao();

    public void add(Department department) throws BusinessException {
        try {
            departmentDao.addDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void update(Department department) throws BusinessException {
        try {
            departmentDao.updateDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) throws BusinessException {
        try {
            departmentDao.deleteDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public Department get(Long id) throws BusinessException {
        try {
            return departmentDao.getDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public List<Department> findAll() throws BusinessException {

        try {
            return departmentDao.findDepartment();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }
}
