package com.example.Employee.Management.System.Controller;


import com.example.Employee.Management.System.Entities.Department;
import com.example.Employee.Management.System.Repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentController {


    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/adddepartment")
    public Department add(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

}
