package com.example.demoh2.repositories;


import com.example.demoh2.models.Cubicle;
import com.example.demoh2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CubicleRepository extends JpaRepository<Cubicle, Long> {

    Cubicle findCubicleByEmployee(Employee employee);

    Cubicle findCubicleByCubicleNumber(int number);
}
