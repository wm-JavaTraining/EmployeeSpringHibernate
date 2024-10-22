package com.wavemaker.employee.service.impl;

import com.wavemaker.employee.entities.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import com.wavemaker.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    @Qualifier("employeeRepositoryInDbImpl")
    private  EmployeeRepository employeeRepository;


    @Override
    public void  addEmployee(Employee employee) {
         employeeRepository.addEmployee(employee);
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
    public  Employee  deleteEmployee(Employee employee) {
        return employeeRepository.deleteEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }
}
