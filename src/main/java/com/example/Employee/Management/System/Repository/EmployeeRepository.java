package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    @Query("SELECT e FROM Empoyee e WHERE e.role.role_name= :rolename")
    List<Employee> findByRoleName(@Param("rolename") String rolename);

    Employee findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);


}
