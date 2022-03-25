package ua.ithillel;

import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

public class EmployeeDatabasesMain {
    public static void main(String[] args) throws BusinessException {
        try {
            AppConfig.init();
            EmployeeManageService ems = new EmployeeManageService();
            DepartmentManageService dms = new DepartmentManageService();
            ems.delete(52L);
            ems.delete(53L);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}
