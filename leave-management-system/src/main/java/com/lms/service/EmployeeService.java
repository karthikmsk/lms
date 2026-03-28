package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.model.Employee;
import com.lms.model.Role;
import com.lms.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getEmployeesByRole(Role role) {
        return employeeRepo.findEmployeesByRole(role);
    }

    public Employee addEmployee(Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        return savedEmployee;
    }
}
