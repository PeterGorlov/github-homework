package ua.ithillel.dao;

import ua.ithillel.model.Employee;

import java.util.*;

public class EmployeeSimpleDao implements EmployeeDao {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Long addEmployee(Employee employee) {
        Long newId = generateId();
        employee.setId(newId);
        employeeList.add(employee);
        return newId;
    }

    private long generateId() {
        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        while (Objects.nonNull(getEmployee(id))) {
            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        }
        return id;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee oldEmployee = getEmployee(employee.getId());
        if (Objects.nonNull(oldEmployee)) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setSalary(employee.getSalary());
            oldEmployee.setDepartmentId(employee.getDepartmentId());
            oldEmployee.setChiefId(employee.getChiefId());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }
}
