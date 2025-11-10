package com.example.Employee.Management.System.Entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeename;

    private String email;

    private String password;


    @ManyToOne
    private Role role;

    @ManyToOne
    private Department department;

    private LocalDate date_of_join;


}
