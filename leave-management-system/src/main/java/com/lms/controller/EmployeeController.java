package com.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Employee;
import com.lms.model.Role;
import com.lms.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee.isPresent()){
            return ResponseEntity.ok(employee.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("role/{role}")
    public ResponseEntity<List<Employee>> getEmployeesByRole(@PathVariable Role role){
        return ResponseEntity.ok(employeeService.getEmployeesByRole(role));
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
