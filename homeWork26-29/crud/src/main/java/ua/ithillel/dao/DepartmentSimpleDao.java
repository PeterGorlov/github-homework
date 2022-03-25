package ua.ithillel.dao;

import ua.ithillel.model.Department;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DepartmentSimpleDao implements DepartmentDao {
    private List<Department> departmentList = new ArrayList<>();

    @Override
    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    @Override
    public void updateDepartment(Department department) {
        Department oldDepartment = getDepartment(department.getId());
        if (Objects.nonNull(oldDepartment)) {
            oldDepartment.setName(department.getName());
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentList.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Department> findDepartment() {
        return departmentList;
    }
}
