package com.example.Employee.Management.System.Repository;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Enums.RoleTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    @Query("SELECT e FROM Employee e WHERE e.role.role = :role")
    List<Employee> findByRoleType(@Param("role") RoleTypes role);




    Employee findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.department.deptid = :deptId")
    List<Employee> findByDepartmentId(@Param("deptId") Long deptId);



}
