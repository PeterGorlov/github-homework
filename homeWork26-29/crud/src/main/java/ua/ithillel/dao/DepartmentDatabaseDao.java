package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.ithillel.util.AppConstant.*;


public class DepartmentDatabaseDao implements DepartmentDao {
    private static final String INSERT = "INSERT INTO department(name, id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE department SET name = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM department WHERE id = ?";
    private static final String SELECT_ONE = "SELECT * FROM department WHERE id = ?";
    private static final String SELECT = "SELECT * FROM department ";

    @Override
    public void addDepartment(Department department) throws DaoException {
        try {
            PreparedStatement pstm = CON.prepareStatement(INSERT);
            pstm.setString(1, department.getName());
            pstm.setLong(2, department.getId());
            int count = pstm.executeUpdate();
            System.out.println(count + " Row inserted");
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void updateDepartment(Department department) throws DaoException {
        try {
            PreparedStatement pstmt = CON.prepareStatement(UPDATE);
            pstmt.setString(1, department.getName());
            pstmt.setLong(2, department.getId());
            int count = pstmt.executeUpdate();
            System.out.println(count + " Row update");

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void deleteDepartment(Long id) throws DaoException {
        try {
            PreparedStatement pstmt = CON.prepareStatement(DELETE);
            pstmt.setLong(1, id);
            int count = pstmt.executeUpdate();
            System.out.println(count + " Row delete");

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Department getDepartment(Long id) throws DaoException {
        Department department = null;
        try {
            PreparedStatement pstmt = CON.prepareStatement(SELECT_ONE);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                department = new Department(
                        rs.getLong(ID),
                        rs.getString(NAME));
            }


        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return department;
    }

    @Override
    public List<Department> findDepartment() throws DaoException {
        List<Department> departmentList = new ArrayList<>();
        try {
            Statement stmt = CON.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Department department = new Department(
                        rs.getLong(ID),
                        rs.getString(NAME)
                );
                departmentList.add(department);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return departmentList;
    }
}
