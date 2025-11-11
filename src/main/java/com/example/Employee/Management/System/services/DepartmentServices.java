package com.example.Employee.Management.System.services;

import com.example.Employee.Management.System.Entities.Department;

import java.util.List;

public interface DepartmentServices {

    Department addDepartment(Department department);

    List<Department> getallDepartment();

    Department getDepartmentById(Long deptid);
}
