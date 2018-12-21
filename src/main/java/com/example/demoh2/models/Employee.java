package com.example.demoh2.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToOne
    private Cubicle assignedCubicle;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Employee() {
    }



    public Employee(String name, Cubicle assignedCubicle, List<Address> addresses) {
        this.name = name;
        this.assignedCubicle = assignedCubicle;
        this.addresses = addresses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cubicle getAssignedCubicle() {
        return assignedCubicle;
    }

    public void setAssignedCubicle(Cubicle assignedCubicle) {
        this.assignedCubicle = assignedCubicle;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assignedCubicle=" + assignedCubicle.getCubicleNumber() +
                ", addresses=" + addresses +
                '}';
    }

}
