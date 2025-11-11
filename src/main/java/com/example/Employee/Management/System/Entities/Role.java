package com.example.Employee.Management.System.Entities;


import com.example.Employee.Management.System.Enums.RoleTypes;
import jakarta.persistence.*;

@Entity
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleTypes role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleTypes getRole() {
        return role;
    }

    public void setRole(RoleTypes role) {
        this.role = role;
    }
}
