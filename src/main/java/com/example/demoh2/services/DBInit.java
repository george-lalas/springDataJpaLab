package com.example.demoh2.services;


import com.example.demoh2.models.Address;
import com.example.demoh2.models.Cubicle;
import com.example.demoh2.models.Employee;
import com.example.demoh2.repositories.AddressRepository;
import com.example.demoh2.repositories.CubicleRepository;
import com.example.demoh2.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class DBInit {
    private static final Logger log = LoggerFactory.getLogger(DBInit.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CubicleRepository cubicleRepository;
    @Autowired
    private AddressRepository addressRepository;


    @Transactional
    public void dbInit(){
        log.debug("Initializing Database");
        log.debug("---------------------------------------------------");
        log.debug("Saving Cubicles...");
        Cubicle cubicle1 = new Cubicle();
        cubicle1.setCubicleNumber(1);
        Cubicle cubicle2 = new Cubicle();
        cubicle2.setCubicleNumber(2);

        cubicleRepository.save(cubicle1);
        cubicleRepository.save(cubicle2);

        log.debug("Total Cubicles saved: {}", cubicleRepository.findAll().size());
        log.debug("---------------------------------------------------");
        log.debug("Saving Employees...");
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
        log.debug("---------------------------------------------------");

        log.debug("Printing Employees");
        log.debug("---------------------------------------------------");
        log.debug("EMPLOYEES : {}", employeeRepository.findAll().toString());
        log.debug("Employee Table size : {}", employeeRepository.findAll().size());
        log.debug("---------------------------------------------------");
        log.debug("Find Employees by name");
        log.debug("---------------------------------------------------");
        Employee employeeFromDB = employeeRepository.findByName("Mitsos");
        log.debug("Employee #1 : {}", employeeFromDB);
        Employee employeeFromDB2 = employeeRepository.findByName("Kitsos");
        log.debug("Employee #2 : {}", employeeFromDB2);
        log.debug("---------------------------------------------------");
        log.debug("DB INIT ended!");
    }


}
