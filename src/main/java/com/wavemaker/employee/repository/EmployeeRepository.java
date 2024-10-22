package com.wavemaker.employee.repository;

import com.wavemaker.employee.entities.Employee;

import java.util.List;

public interface EmployeeRepository {
    public void addEmployee(Employee employee);

    public Employee getEmployeeById(int empId);

    public List<Employee> getAllEmployees();

    public Employee deleteEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);
}
