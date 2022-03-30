package com.awsSA.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private long id;
     
    private String name;
     
    private int salary;


    public Employee() {
    };
   

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
 
    public void setId(long id2) {
        this.id = id2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

