package com.wavemaker.employee.service;

import com.wavemaker.employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void  addEmployee(Employee employee);
    public  Employee getEmployeeById(int empId);
    public List<Employee> getAllEmployees();
    public  Employee  deleteEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);

    
}
