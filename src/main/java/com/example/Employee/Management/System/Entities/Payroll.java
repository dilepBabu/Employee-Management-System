package com.example.Employee.Management.System.Entities;


import jakarta.persistence.*;

import java.time.Month;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Employee employee;

    private Month month;



    private Long base_salary;

    private Long bonus;

    private Long deductions;

    private Long total_salary;
}
