package com.wavemaker.employee.controller;

import com.wavemaker.employee.pojo.Employee;
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
    public int addEMployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
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
    public boolean deleteEmployee(@PathVariable int empId) {
        return employeeService.deleteEmployee(empId);
    }

    @PutMapping
    public boolean updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}

