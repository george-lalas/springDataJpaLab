package com.example.demoh2.models;


import javax.persistence.*;

@Entity
@Table(name = "cubicle")
public class Cubicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne (mappedBy = "assignedCubicle")
    private Employee employee;

    @Column
    private int cubicleNumber;

    public Cubicle() {
    }

    public Cubicle(Employee employee, int cubicleNumber) {
        this.employee = employee;
        this.cubicleNumber = cubicleNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getCubicleNumber() {
        return cubicleNumber;
    }

    public void setCubicleNumber(int cubicleNumber) {
        this.cubicleNumber = cubicleNumber;
    }

    @Override
    public String toString() {
        return "Cubicle{" +
                "id=" + id +
                ", employee=" + employee.getName() +
                ", cubicleNumber=" + cubicleNumber +
                '}';
    }
}
