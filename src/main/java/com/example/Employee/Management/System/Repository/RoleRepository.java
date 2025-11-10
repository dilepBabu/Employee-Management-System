package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findBy(Role role);
}
