package com.wavemaker.employee.service.impl;

import com.wavemaker.employee.pojo.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import com.wavemaker.employee.repository.impl.EmployeeRepositoryImpl;
import com.wavemaker.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
//    @Qualifier("employeeRepository")
    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository  employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeRepository.getEmployeeById(empId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return employeeRepository.deleteEmployee(empId);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }
}
