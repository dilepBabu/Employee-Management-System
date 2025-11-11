package com.example.Employee.Management.System.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeename;

    private String email;

    private String password;


    @ManyToOne
    private Role role;

    @ManyToOne
    private Department department;

    private LocalDate date_of_join;

    public Long getEmployee_id() {
        return id;
    }

    public void setEmployee_id(Long employee_id) {
        this.id = employee_id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(LocalDate date_of_join) {
        this.date_of_join = date_of_join;
    }
}
