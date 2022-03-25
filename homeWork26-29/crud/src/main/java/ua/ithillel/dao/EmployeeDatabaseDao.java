package ua.ithillel.dao;

import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {
    private static final String INSERT = "INSERT INTO employee(name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private static final String SELECT = "SELECT * FROM employee ";



    @Override
    public Long addEmployee(Employee employee) throws DaoException {
        Long employeeId = null;
        try {
            PreparedStatement pstm = CON.prepareStatement(INSERT, new String[]{"id", "name"});
            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            int count = pstm.executeUpdate();
            System.out.println(count + " Row inserted");
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                employeeId = gk.getLong(ID);
                System.out.println("------------ " + gk.getString(NAME));
            }

            return employeeId;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override

    public void updateEmployee(Employee employee) throws DaoException {

        try {
            PreparedStatement pstmt = CON.prepareStatement(UPDATE);
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getSalary());
            pstmt.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstmt.setNull(4, Types.NULL);
            } else {
                pstmt.setLong(4, employee.getChiefId());
            }
            pstmt.setLong(5, employee.getId());
            int count = pstmt.executeUpdate();
            System.out.println(count + " Row update");


        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void deleteEmployee(Long id) throws DaoException {

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
    public Employee getEmployee(Long id) throws DaoException {
        Employee employee = null;
        try {
            PreparedStatement pstmt = CON.prepareStatement(SELECT_ONE);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Long chief_id = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chief_id = null;
                }
                employee = new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chief_id,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployees() throws DaoException {

        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement stmt = CON.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Long chief_id = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chief_id,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
                employeeList.add(employee);
            }


        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return employeeList;
    }
}
