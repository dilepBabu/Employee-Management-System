package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Department;
import com.example.Employee.Management.System.Repository.DepartmentRepository;
import com.example.Employee.Management.System.services.DepartmentServices;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImp implements DepartmentServices {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getallDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long deptid) {
        return departmentRepository.findById(deptid).orElseThrow(()->new RuntimeException("Department not found"));
    }
}
