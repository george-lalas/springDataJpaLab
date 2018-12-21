package com.example.demoh2;

import com.example.demoh2.models.Address;
import com.example.demoh2.models.Cubicle;
import com.example.demoh2.models.Employee;
import com.example.demoh2.repositories.AddressRepository;
import com.example.demoh2.repositories.CubicleRepository;
import com.example.demoh2.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTests {

    private static final Logger log = LoggerFactory.getLogger(DataJpaTests.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CubicleRepository cubicleRepository;

    @Test
    public void dbTest(){
        log.info("Initializing Database");
        log.info("---------------------------------------------------");
        log.info("Saving Cubicles...");
        Cubicle cubicle1 = new Cubicle();
        cubicle1.setCubicleNumber(1);
        Cubicle cubicle2 = new Cubicle();
        cubicle2.setCubicleNumber(2);

        cubicleRepository.save(cubicle1);
        cubicleRepository.save(cubicle2);

        log.info("Total Cubicles saved: {}", cubicleRepository.findAll().size());
        log.info("---------------------------------------------------");
        log.info("Saving Employees...");
        Employee employee = new Employee();
        employee.setName("Mitsos");
        employee.setAssignedCubicle(cubicle1);
        Employee employee2 = new Employee();
        employee2.setName("Kitsos");
        employee2.setAssignedCubicle(cubicle2);
        Address address1 = new Address();
        address1.setNumber(12);
        address1.setStreet("Othonos Street");
        address1.setEmployee(employee);
        Address address2 = new Address();
        address2.setNumber(14);
        address2.setStreet("Agiou Alexandrou Street");
        address2.setEmployee(employee);
        Address address3 = new Address();
        address3.setNumber(14);
        address3.setStreet("Leoforos Sygrou");
        address3.setEmployee(employee2);
        Address address4 = new Address();
        address4.setNumber(14);
        address4.setStreet("Agiou Tade");
        address4.setEmployee(employee2);
        employee.setAddresses(Arrays.asList(address1,address2));
        employee2.setAddresses(Arrays.asList(address3,address4));
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        log.info("---------------------------------------------------");

        log.info("Printing Employees");
        log.info("---------------------------------------------------");
        log.info("EMPLOYEES : {}", employeeRepository.findAll().toString());
        log.info("Employee Table size : {}", employeeRepository.findAll().size());
        log.info("---------------------------------------------------");
        log.info("Find Employees by name");
        log.info("---------------------------------------------------");
        Employee employeeFromDB = employeeRepository.findByName("Mitsos");
        log.info("Employee #1 : {}", employeeFromDB);
        Employee employeeFromDB2 = employeeRepository.findByName("Kitsos");
        log.info("Employee #2 : {}", employeeFromDB2);
        log.info("---------------------------------------------------");
        log.info("DB INIT ended!");
    }
}
