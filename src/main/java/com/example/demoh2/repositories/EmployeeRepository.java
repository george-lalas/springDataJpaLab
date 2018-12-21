package com.example.demoh2.repositories;


import com.example.demoh2.models.Cubicle;
import com.example.demoh2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByAssignedCubicle(Cubicle cubicle);
    Employee findByName(String name);
}
