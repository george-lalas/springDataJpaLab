package com.example.demoh2.models;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private  Long id;

    @Column
    private String street;

    @Column
    private int number;

    @ManyToOne
    private Employee employee;

    public Address() {
    }

    public Address(String street, int number, Employee employee) {
        this.street = street;
        this.number = number;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", employee=" + employee.getName()+
                '}';
    }
}
