package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Role;
import com.example.Employee.Management.System.Enums.RoleTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {


   List<Role> findByRole(RoleTypes role);
}
