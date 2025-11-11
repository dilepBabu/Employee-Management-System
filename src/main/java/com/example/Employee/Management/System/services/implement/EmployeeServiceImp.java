package com.example.Employee.Management.System.services.implement;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import com.example.Employee.Management.System.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
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
    public List<Employee> getAllEmployee(Employee employee) {
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
}
