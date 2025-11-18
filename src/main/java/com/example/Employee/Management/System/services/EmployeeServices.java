package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long id,Employee employee);

    void deleteById(Long id);

    List<Employee> getAllEmployee();

    List<Employee> getByDeptId(Long deptid);

    Optional<Employee> getEmployeeById(Long id);

}
