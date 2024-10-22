package com.wavemaker.employee.repository.rowmappers;

import com.wavemaker.employee.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee  mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee =new Employee();
        employee.setEmpId(rs.getInt(1));
        employee.setName(rs.getString(2));
        employee.setAge(rs.getInt(3));
        employee.setContact(rs.getString(4));
        employee.setGender(rs.getString(5));
       return  employee;
    }
}
