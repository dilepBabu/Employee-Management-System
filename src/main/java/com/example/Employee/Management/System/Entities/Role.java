package com.example.Employee.Management.System.Entities;


import com.example.Employee.Management.System.Enums.RoleTypes;
import jakarta.persistence.*;

@Entity
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoleTypes role_name;
}
