package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.model.Employee;
import com.lms.model.Role;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

    @Query("SELECT e FROM Employee e WHERE e.role =:role")
    List<Employee> findEmployeesByRole(@Param("role")Role role);
}
