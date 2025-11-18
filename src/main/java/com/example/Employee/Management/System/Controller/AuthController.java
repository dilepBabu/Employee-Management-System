package com.example.Employee.Management.System.Controller;


import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import com.example.Employee.Management.System.services.implement.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



        @PostMapping("/signup")
        public String signup(@RequestBody Employee employee)
        {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeRepository.save(employee);
            return "User registered successfully!";
        }

        @PostMapping("/login")
        public String login(@RequestBody Employee employee)
        {
            return employeeServiceImp.verify(employee);
        }



}
