package com.wavemaker.employee.repository.impl;

import com.wavemaker.employee.entities.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("employeeRepositoryInMemoryImpl")
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
    private static final Map<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public void  addEmployee(Employee employee) {
        logger.info("Adding new employee: {}", employee);
        int empId = -1;
        empId = getMaxEmpId();
        empId += 1;
        employee.setEmpId(empId);
        logger.debug("Generated new employee ID: {}", empId);

        logger.info("Adding employee with ID: {}", employee.getEmpId());

        if (employeeMap.containsKey(employee.getEmpId())) {
            logger.error("Employee with ID {} already exists.", employee.getEmpId());

        }
        employeeMap.put(employee.getEmpId(), employee);
        logger.info("Employee with ID {} added successfully.", employee.getEmpId());
    }

    @Override
    public Employee getEmployeeById(int empId) {
        logger.info("Fetching employee with ID: {}", empId);
        Employee employee = employeeMap.get(empId);
        if (employee == null) {
            logger.error("Employee with ID {} not found.", empId);
        }
        logger.info("Employee found: {}", employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees.");
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public Employee  deleteEmployee(Employee employee) {
        logger.info("Deleting employee with ID: {}", employee.getEmpId());
        if (!employeeMap.containsKey(employee.getEmpId())) {
            logger.error("Employee with ID {} not found.", employee.getEmpId());
            return employee;
        }
         employee = employeeMap.remove(employee);
        logger.info("Employee with ID {} deleted successfully.", employee.getEmpId());
        return  employee;

    }

    @Override
    public boolean updateEmployee(Employee employee) {
        logger.info("Updating employee with ID: {}", employee.getEmpId());
        if (!employeeMap.containsKey(employee.getEmpId())) {
            logger.error("Employee with ID {} not found.", employee.getEmpId());
            return false;
        }
        employeeMap.put(employee.getEmpId(), employee);
        logger.info("Employee with ID {} updated successfully.", employee.getEmpId());
        return true;
    }

    private int getMaxEmpId() {
        int maxEmpId = 0;
        for (int i : employeeMap.keySet()) {
            maxEmpId = Math.max(maxEmpId, i);
        }
        return maxEmpId;
    }
}
