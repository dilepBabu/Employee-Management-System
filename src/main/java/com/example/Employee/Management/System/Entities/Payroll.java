package com.example.Employee.Management.System.Entities;


import jakarta.persistence.*;

import java.time.Month;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Month month;



    private Long base_salary;

    private Long bonus;

    private Long deductions;

    private Long total_salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Long getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(Long base_salary) {
        this.base_salary = base_salary;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getDeductions() {
        return deductions;
    }

    public void setDeductions(Long deductions) {
        this.deductions = deductions;
    }

    public Long getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(Long total_salary) {
        this.total_salary = total_salary;
    }
}
