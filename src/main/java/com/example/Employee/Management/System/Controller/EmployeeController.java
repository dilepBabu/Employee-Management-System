package com.example.Employee.Management.System.Controller;
import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.services.implement.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;


    @PostMapping("/addemployee")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImp.addEmployee(employee));
    }


    @GetMapping("/allemployee")
    public List<Employee> getemployee()
    {
        return employeeServiceImp.getAllEmployee();
    }
}
