package com.example.personnel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    private String id;
    @Pattern(regexp = "^[a-zA-Z ]{3,}$", message = "firstName should be longer then 3 letters")
    private String firstName;
    @Pattern(regexp = "^.{5,}$", message = "lastName should be longer then 5 symbols")
    private String lastName;
    @Pattern(regexp = "^.{3,}$", message = "department should be longer then 3 symbols")
    private String department;
    @Min(value = 1500, message = "Salary can't be less than 1500")
    private Double salary;

    @Pattern(regexp = "^\\d{4}-\\w{2}-\\d{2}$", message="hired should be a date")
    private String hired;

    public Employee(String id, String firstName, String lastName, String department, Double salary, String hired) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.hired = hired;
    }

    public Employee() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
