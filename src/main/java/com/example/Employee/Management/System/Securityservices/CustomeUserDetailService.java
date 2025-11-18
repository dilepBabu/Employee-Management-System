package com.example.Employee.Management.System.Securityservices;

import com.example.Employee.Management.System.Entities.Employee;
import com.example.Employee.Management.System.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Employee employee=employeeRepository.findByEmail(email);
        if(employee==null)
        {
           throw new UsernameNotFoundException("employee not found");
        }
        return  new CustomeUserDetail(employee);


    }
}
