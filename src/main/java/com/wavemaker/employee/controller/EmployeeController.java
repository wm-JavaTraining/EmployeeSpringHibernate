package com.wavemaker.employee.controller;

import com.wavemaker.employee.entities.Employee;
import com.wavemaker.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/{empId}")  // Using path variable
    public Employee getEmployeeByEmpId(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{empId}")
    public Employee deleteEmployee(@PathVariable int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        return employeeService.deleteEmployee(employee);
    }

    @PutMapping("/{empId}")
    public boolean updateEmployee(@PathVariable int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        employee.setName("Roopa");
        return employeeService.updateEmployee(employee);
    }

}

