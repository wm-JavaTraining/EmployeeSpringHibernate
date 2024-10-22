package com.wavemaker.employee.repository.impl;

import com.wavemaker.employee.entities.Employee;
import com.wavemaker.employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeRepositoryInDbImpl")
public class EmployeeRepositoryInDbImpl implements EmployeeRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

//    @Autowired
//    SessionFactory sessionFactory;

    public EmployeeRepositoryInDbImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        hibernateTemplate.save(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        Employee employee = hibernateTemplate.get(Employee.class, empId);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
        return employees;
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Employee employee) {
        hibernateTemplate.delete(employee);
        return employee;

    }

    @Override
    @Transactional
    public boolean updateEmployee(Employee employee) {
        hibernateTemplate.update(employee);
        return true;
    }
}
