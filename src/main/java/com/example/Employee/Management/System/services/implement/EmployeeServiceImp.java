package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import com.example.Employee.Management.System.Securityservices.CustomeUserDetail;
import com.example.Employee.Management.System.Securityservices.CustomeUserDetailService;
import com.example.Employee.Management.System.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomeUserDetailService customeUserDetailService;

    @Autowired
    private Jwtservice jwtservice;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee oldEmployee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));

        oldEmployee.setEmployeename(employee.getEmployeename());
        oldEmployee.setDepartment(employee.getDepartment());
        oldEmployee.setEmail(employee.getEmail());
        oldEmployee.setDate_of_join(employee.getDate_of_join());
        oldEmployee.setRole(employee.getRole());

        return employeeRepository.save(oldEmployee);
    }

    @Override
    public void deleteById(Long id) {

        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByDeptId(Long deptid) {
        return employeeRepository.findByDepartmentId(deptid);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public String verify(Employee employee){

           Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword()));
           final CustomeUserDetail userDetails = (CustomeUserDetail) customeUserDetailService
                .loadUserByUsername(employee.getEmail());
           if(authentication.isAuthenticated())
            {
                return jwtservice.generateToken(employee.getEmail());
            }
           return "failure";
    }
}
